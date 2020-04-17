package test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TestCalendar {
	public static void main(String[] args) {
		// GregorianCalendar clsCalendar = new GregorianCalendar( TimeZone.getTimeZone(
		// "Asia/Seoul" ) );
		GregorianCalendar clsCalendar = new GregorianCalendar(TimeZone.getTimeZone("America/Chicago"));

		String strText = String.format("%s:%04d-%02d-%02d %02d:%02d", "Time", clsCalendar.get(Calendar.YEAR),
				clsCalendar.get(Calendar.MONTH) + 1, clsCalendar.get(Calendar.DAY_OF_MONTH),
				clsCalendar.get(Calendar.HOUR_OF_DAY), clsCalendar.get(Calendar.MINUTE));

		System.out.println(strText);
		
		 System.out.println("ZONE_OFFSET: "
			        + (clsCalendar.get(Calendar.ZONE_OFFSET)/(60*60*1000))); // in hours
	}
}