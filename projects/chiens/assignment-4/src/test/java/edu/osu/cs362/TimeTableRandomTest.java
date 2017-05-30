package edu.osu.cs362;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=20;

	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"NullAppts","NullAppt", "deleteAppt"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	@Test
	public void radnomtest()  throws Throwable  {
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		System.out.println("Start testing...");

		for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			long randomseed =10;//System.currentTimeMillis();
			Random random = new Random(randomseed);

			int mMonth = 6;
			int mYear = 2017;
			int mDay = 1;
			int mMinute = 30;
			int index, size;

			GregorianCalendar firstDay = new GregorianCalendar(mYear, mMonth, mDay );
			GregorianCalendar lastDay = (GregorianCalendar) firstDay.clone();
			lastDay.add(Calendar.DAY_OF_MONTH, 2);
			TimeTable tt = new TimeTable();
			GregorianCalendar g = new GregorianCalendar();
			CalDay cal = new CalDay(g);
			LinkedList<Appt> listAppts = new LinkedList<Appt>();

			String title="Birthday Party";
			String description="This is my birthday party.";
			//Construct a new Appointment object with the initial data
			Appt appt, randomAppt;


			for (int i = 0; i < 10; i++) {

				int newHour=(int) ValuesGenerator.getRandomIntBetween(random, -5, 30);
				appt = new Appt(newHour,
						mMinute ,
						mDay ,
						mMonth ,
						mYear ,
						title,
						description);

				listAppts.add(appt);
			}

			tt.getApptRange(listAppts, firstDay, lastDay);


		for (int i = 0; i < NUM_TESTS; i++){
			size = listAppts.size();
			Random rand = new Random();
			index = rand.nextInt(9);

			try {
				randomAppt = listAppts.get(index);
			} catch (Exception e){
				int newHour=(int) ValuesGenerator.getRandomIntBetween(random, -5, 30);
				randomAppt = new Appt(newHour,
						mMinute ,
						mDay ,
						mMonth ,
						mYear ,
						title,
						description);
			}

			String methodName = TimeTableRandomTest.RandomSelectMethod(random);

			if(methodName == "NullAppts")
				tt.deleteAppt(null, randomAppt);

			else if(methodName == "NullAppt")
				tt.deleteAppt(listAppts, null);

			else if(methodName == "deleteAppt")
				tt.deleteAppt(listAppts, randomAppt);


		}

			elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);

		}

		System.out.println("Done testing...");


	}


	
}
