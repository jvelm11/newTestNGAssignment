package generic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TestUtilities {

	static Date morning, afternoon, evening, currenttime;
	SimpleDateFormat sdf;
	Calendar cal;
	LocalDate local;
	String wish,name,currentime1;
	DayOfWeek day;
	
	public String expectedWishText(String name) {
		
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cal = Calendar.getInstance(TimeZone.getDefault());
		sdf.setTimeZone(cal.getTimeZone());
		currentime1=sdf.format(cal.getTime());
		local = LocalDate.now();
		day=local.getDayOfWeek();
		
		try {
			currenttime = sdf.parse(currentime1);
			morning=sdf.parse(local+" "+"00:00:00");
			afternoon=sdf.parse(local+" "+"11:59:59");
			evening=sdf.parse(local+" "+"15:00:00");
		} catch (ParseException e) {
			
			System.out.println(e);
		}
		
		if(day==day.SATURDAY || day==day.SUNDAY) {
			
			return "Enjoy your weekend "+ name;
		}
		if(currenttime.compareTo(morning)>=0 && currenttime.compareTo(afternoon)<0) {
			
			return "Good morning "+name;
			
		}else if(currenttime.compareTo(afternoon)>0 && currenttime.compareTo(evening)<0) {
			
			return "Good afternoon "+name; 
			
		}else{
			
			return "Good evening "+name;
		}
		
		
	}
	
}
