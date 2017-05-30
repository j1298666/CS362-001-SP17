package edu.osu.cs362;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=10;

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");

		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			 long randomseed =10;//System.currentTimeMillis();
			 Random random = new Random(randomseed);

			 GregorianCalendar g = new GregorianCalendar();
			 CalDay cal = new CalDay(g);
			 int startHour=13;
			 int startMinute=30;
			 int startDay=10;
			 int startMonth=4;
			 int startYear=2017;
			 String title="Birthday Party";
			 String description="This is my birthday party.";
			 //Construct a new Appointment object with the initial data
			 Appt appt;


			 for (int i = 0; i < NUM_TESTS; i++) {

				 int newHour=(int) ValuesGenerator.getRandomIntBetween(random, -5, 30);
				 appt = new Appt(newHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						 description);

				 cal.addAppt(appt);
			 }
			 //System.out.println("\n");
			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);

		 }

		 System.out.println("Done testing...");


	 }


	
}
