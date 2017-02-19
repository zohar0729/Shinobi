package Shinobi;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Shinobi extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7904313262072651538L;
	Twitter twitter;
	User user;
	JLabel userName, userScreenName, userStatusCount, userLatestStatus;
	public static String diffDate(Date dest){
		long d = new Date().getTime() - dest.getTime();
		String s = "";
		
		if(d/1000 < 60){
			s = s + d/1000 + "�b�O";
		}else if(d/1000/60 < 60){
			s = s + d/1000/60 + "���O";
		}else if(d/1000/60/60 < 24){
			s = s + d/1000/60/60 + "���ԑO";
		}else if(d/1000/60/60/24 < 7){
			s = s + d/1000/60/60/24 + "���O";
		}else{
			s = s + dest;
		}
		
		return s;
	}
	public static void main(String[] args) throws TwitterException{
		Shinobi f = new Shinobi("Shinobi for Twitter");

		f.setVisible(true);
	}
	Shinobi(String title) throws TwitterException{
		twitter = new TwitterFactory().getInstance();
		user = twitter.verifyCredentials();
		
		// �E�B���h�E�̏�����
		setTitle(title);
		setSize(300, 300);
		setLayout(new GridLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// �\�����郉�x���̃C���X�^���X������я�����
		userName = new JLabel("���[�U�[��:"+user.getName());
		userScreenName = new JLabel("���[�U�[ID:"+user.getScreenName());
		userStatusCount = new JLabel("�c�C�[�g��:"+user.getStatusesCount());
		userLatestStatus = new JLabel(
				"�ŐV�c�C�[�g:"+Shinobi.diffDate(user.getStatus().getCreatedAt()));
		
		// �R���g���[���̃��C�A�E�g
		Container contentPane = getContentPane();
		contentPane.add(userName, BorderLayout.NORTH);
		contentPane.add(userScreenName, BorderLayout.NORTH);
		contentPane.add(userStatusCount, BorderLayout.CENTER);
		contentPane.add(userLatestStatus, BorderLayout.EAST);
	}
	
}
