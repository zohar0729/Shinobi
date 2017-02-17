package Shinobi;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Shinobi {
	private static String diffDate(Date dest){
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
		Twitter twitter = new TwitterFactory().getInstance();
		User user = twitter.verifyCredentials();
		
		System.out.println("ユーザー名\t\t:"+user.getName());
		System.out.println("ユーザーID\t\t:@"+user.getScreenName());
		System.out.println("ツイート数\t\t:"+user.getStatusesCount());
		System.out.println("最終ツイート\t:"+diffDate(user.getStatus().getCreatedAt()));
		
		
		
	    //Status status = twitter.updateStatus(args[0]);
	    //System.out.println("Successfully updated the status to [" + status.getText() + "].");
	}

}
