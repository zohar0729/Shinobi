package Shinobi;

import java.awt.*;
import java.awt.event.*;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

class myFrame extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6600124804508847360L;
	Twitter twitter;
	User user;
	
	Label userName, userScreenName, userStatusCount, userLatestStatus;
	
	myFrame(String title) throws TwitterException{
		twitter = new TwitterFactory().getInstance();
		user = twitter.verifyCredentials();
		
		userName = new Label("���[�U�[��:"+user.getName());
		userScreenName = new Label("���[�U�[ID:"+user.getScreenName());
		userStatusCount = new Label("�c�C�[�g��:"+user.getStatusesCount());
		userLatestStatus = new Label(
				"�ŐV�c�C�[�g:"+Shinobi.diffDate(user.getStatus().getCreatedAt()));
		
		setTitle(title);
		setSize(300, 300);
		setLayout(new GridLayout());
		addWindowListener(new myWindowAdapter());
		add(userName);
		add(userScreenName);
		add(userStatusCount);
		add(userLatestStatus);
	}
	
}

class myWindowAdapter extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		System.exit(0);
	}
}
