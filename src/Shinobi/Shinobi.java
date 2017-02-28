package Shinobi;

import twitter4j.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import javax.swing.*;

class keyShortcut implements KeyListener{
	Boolean[] keyTable = new Boolean[2];
	public Boolean isTweetKey(){
		return keyTable[0] & keyTable[1];
	}
	keyShortcut(){
		keyTable[0] = false;
		keyTable[1] = false;
	}
	@Override
	public void keyPressed(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_CONTROL)keyTable[0] = true;
		if(event.getKeyCode() == KeyEvent.VK_ENTER)keyTable[1] = true;
	}

	@Override
	public void keyReleased(KeyEvent event) {
		if(event.getKeyCode() == KeyEvent.VK_CONTROL)keyTable[0] = false;
		if(event.getKeyCode() == KeyEvent.VK_ENTER)keyTable[1] = false;
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}

public class Shinobi extends JFrame{
	Twitter twitter;
	User user;
	JLabel userName, userStatusCount, userLatestStatus;
	TweetArea tweetArea;
	twitterComponent dummy1, dummy2, dummy3, dummy4;
	JPanel p;
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
		Shinobi f = new Shinobi("Shinobi");

		f.setVisible(true);
	}
	Shinobi(String title) throws TwitterException{
		// ユーザー情報の取得
		twitter = new TwitterFactory().getInstance();
		user = twitter.verifyCredentials();
		
		// ウィンドウの初期化
		setTitle(title);
		setSize(900, 600
				);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		// 表示するコントロールのインスタンス化および初期化
		userName = new JLabel(user.getName()+"(@"+user.getScreenName()+")");
		userStatusCount = new JLabel("ツイート数:"+user.getStatusesCount());
		userLatestStatus = new JLabel(
				"最新ツイート:"+Shinobi.diffDate(user.getStatus().getCreatedAt()));
		tweetArea = new TweetArea(twitter);
		dummy1 = new twitterComponent(twitter);
		dummy2 = new twitterComponent(twitter);
		dummy3 = new twitterComponent(twitter);
		dummy4 = new twitterComponent(twitter);
		p = new JPanel();
		
		// コントロールを配置する
		p.setLayout(new GridLayout(1, 5));
		p.add(tweetArea);
		p.add(dummy1);
		p.add(dummy2);
		p.add(dummy3);
		p.add(dummy4);
		
		add(p);
	}
	
}