package cf.cc7w.ChatC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static String getTime(){
		
		Date nowTime = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = dateFormat.format(nowTime);
		
		return now;
		
	}
	
	public static String getTime(Long l){
		
		Date nowTime = new Date(l);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = dateFormat.format(nowTime);
		
		return now;
		
	}
	
	public static Date getDate(String timeString){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = null;

	    try {
			time = dateFormat.parse(timeString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return time;
		
	}
	
	public static int numberOnly(String s){
		
		int length = s.length();
		String temp = "";
		
		for(int i=0 ; i<length ; i++){
			
			char t = s.charAt(i);
			
			if(t >=48 && t <= 57){
				
				temp = temp + t;
				
			}
			
		}
		
		int a = Integer.valueOf(temp);
		
		return a;
		
	}
	
	
	
}
