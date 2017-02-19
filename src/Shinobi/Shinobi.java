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
		setSize(300, 300);
		setLayout(new GridLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 表示するラベルのインスタンス化および初期化
		userName = new JLabel("ユーザー名:"+user.getName());
		userScreenName = new JLabel("ユーザーID:"+user.getScreenName());
		userStatusCount = new JLabel("ツイート数:"+user.getStatusesCount());
		userLatestStatus = new JLabel(
				"最新ツイート:"+Shinobi.diffDate(user.getStatus().getCreatedAt()));
		
		// コントロールのレイアウト
		Container contentPane = getContentPane();
		contentPane.add(userName, BorderLayout.NORTH);
		contentPane.add(userScreenName, BorderLayout.NORTH);
		contentPane.add(userStatusCount, BorderLayout.CENTER);
		contentPane.add(userLatestStatus, BorderLayout.EAST);
	}
	
}
