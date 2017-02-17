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
		Twitter twitter = new TwitterFactory().getInstance();
		User user = twitter.verifyCredentials();
		
		System.out.println("���[�U�[��\t\t:"+user.getName());
		System.out.println("���[�U�[ID\t\t:@"+user.getScreenName());
		System.out.println("�c�C�[�g��\t\t:"+user.getStatusesCount());
		System.out.println("�ŏI�c�C�[�g\t:"+diffDate(user.getStatus().getCreatedAt()));
		
		
		
	    //Status status = twitter.updateStatus(args[0]);
	    //System.out.println("Successfully updated the status to [" + status.getText() + "].");
	}

}
