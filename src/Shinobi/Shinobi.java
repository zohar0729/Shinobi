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
	private static long diffDate(Date d){
		long b, a;
		Date date = new Date();
		b=d.getTime();
		a=date.getTime();
		
		System.out.println(a-b);
		
		return a-b;
	}
	
	public static void main(String[] args) throws TwitterException{
		Twitter twitter = new TwitterFactory().getInstance();
		User user = twitter.verifyCredentials();
		Date diff = new Date(diffDate(user.getStatus().getCreatedAt()));
		System.out.println(new Date());
		System.out.println(user.getStatus().getCreatedAt());
		SimpleDateFormat sdf = new SimpleDateFormat("MM��dd��HH����mm��ss�b�O");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		
		System.out.println("���[�U�[��\t\t:"+user.getName());
		System.out.println("���[�U�[ID\t\t:"+user.getScreenName());
		System.out.println("�c�C�[�g��\t\t:"+user.getStatusesCount());
		System.out.println("�ŏI�c�C�[�g\t:"+sdf.format(diff));
		
	    //Status status = twitter.updateStatus(args[0]);
	    //System.out.println("Successfully updated the status to [" + status.getText() + "].");
	}

}
