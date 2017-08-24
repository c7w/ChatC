package cf.cc7w.ChatC;

import java.util.regex.Pattern;

public class Mute {

	public static void setMuted(String pn,String time){
		
		int t = getSecond(time);
		ChatC.data.set(pn + ".mute.isMuted", true);
		ChatC.data.set(pn + ".mute.StartTime", Util.getTime());
		ChatC.data.set(pn + ".mute.Time", t);
		
		Data.trySaveData();
		
	}
	
	public static boolean getMuted(String pn){
		
		boolean isMuted = ChatC.data.getBoolean(pn + ".mute.isMuted");
		
		if(isMuted != true){
			
			return false;
			
		}
		
		if(
				
				Util.getDate(Util.getTime()).getTime() 
				- 
				Util.getDate(ChatC.data.getString(pn + ".mute.StartTime")).getTime() 
				< 
				(ChatC.data.getInt(pn + ".mute.Time") * 1000)
				
				){
			
			return true;
			
		}else{
			
			unMute(pn);
			
			return false;
			
		}

		
	}
	
	public static void unMute(String pn){
		
		ChatC.data.set(pn + ".mute.isMuted", false);
		ChatC.data.set(pn + ".mute.StartTime", Util.getTime());
		ChatC.data.set(pn + ".mute.Time", 0);
		Data.trySaveData();
		
	}
	
	public static int getSecond(String timeString){
		
		timeString = timeString.toLowerCase();
		
		int length = timeString.length() - 1;
		char last = timeString.charAt(length);
		
		if(last != 's' && last != 'd' && last != 'w' && last != 'h' && last != 'm'){
			
			timeString = timeString + "s";
			
		}
		
		int week = 0;
		int day = 0;
		int hour = 0;
		int minute = 0;
		int second = 0;
		
		if(timeString.contains("w")){
			
			Pattern weekSplit = Pattern.compile("[w]+");
			String[] weekString = weekSplit.split(timeString, 2);
			week = Util.numberOnly(weekString[0]);
			
			timeString = weekString[1];
			
		}
		
		if(timeString.contains("d")){
			
			Pattern daySplit = Pattern.compile("[d]+");
			String[] dayString = daySplit.split(timeString, 2);
			day = Util.numberOnly(dayString[0]);
			
			timeString = dayString[1];
			
		}
		
		if(timeString.contains("h")){
			
			Pattern hourSplit = Pattern.compile("[h]+");
			String[] hourString = hourSplit.split(timeString, 2);
			hour = Util.numberOnly(hourString[0]);
			
			timeString = hourString[1];
			
		}
		
		if(timeString.contains("m")){
			
			Pattern minuteSplit = Pattern.compile("[m]+");
			String[] minuteString = minuteSplit.split(timeString, 2);
			minute = Util.numberOnly(minuteString[0]);
			
			timeString = minuteString[1];
			
		}
		
		if(timeString.contains("s")){
			
			Pattern secondSplit = Pattern.compile("[s]+");
			String[] secondString = secondSplit.split(timeString, 2);
			second = Util.numberOnly(secondString[0]);
			
			timeString = secondString[1];
			
		}

		day = day + week * 7;
		hour = hour + day * 24;
		minute = minute + hour * 60;
		second = second + minute * 60;
		
		//System.out.println(second);
		
		return second;
	}
	
}
