package Shinobi;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

import java.awt.BorderLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Shinobi extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7904313262072651538L;
	Twitter twitter;
	User user;
	JLabel userName, userScreenName, userStatusCount, userLatestStatus;
	JLabel guide1, guide2;
	JButton send;
	JPanel info, guide;
	JTextArea tweetArea;
	public static String diffDate(Date dest){
		long d = new Date().getTime() - dest.getTime();
		String s = "";
		
		if(d/1000 < 60){
			s = s + d/1000 + "秒前";
		}else if(d/1000/60 < 60){
			s = s + d/1000/60 + "分前";
		}else if(d/1000/60/60 < 24){
			s = s + d/1000/60/60 + "時間前";
		}else if(d/1000/60/60/24 < 7){
			s = s + d/1000/60/60/24 + "日前";
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
		
		// ウィンドウの初期化
		setTitle(title);
		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 表示するラベルのインスタンス化および初期化
		userName = new JLabel(" "+user.getName());
		userScreenName = new JLabel("@"+user.getScreenName());
		userStatusCount = new JLabel("  ツイート数:"+user.getStatusesCount());
		userLatestStatus = new JLabel(
				"  最新ツイート:"+Shinobi.diffDate(user.getStatus().getCreatedAt()));
		info = new JPanel();
		guide = new JPanel();
		send = new JButton("送信");
		tweetArea = new JTextArea("今何してる？", 10, 14);
		
		// コントロールのレイアウト
		add(info, BorderLayout.NORTH);
		info.add(userName);
		info.add(userScreenName);
		info.add(userStatusCount);
		info.add(userLatestStatus);
		add(tweetArea, BorderLayout.CENTER);
		add(send, BorderLayout.SOUTH);
		
	}
	
}
