package Shinobi;

import twitter4j.TwitterException;
import java.util.Date;

public class Shinobi {
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
		myFrame f = new myFrame("Shinobi for Twitter");

		f.setVisible(true);
	}
}
