package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
	 	//test for getAppRange
		 TimeTable tt = new TimeTable();

		 int mMonth;
		 int mYear;
		 int mDay;
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 mMonth = rightnow.get(Calendar.MONTH)+1;
		 mYear = rightnow.get(Calendar.YEAR);
		 mDay = rightnow.get(Calendar.DAY_OF_MONTH);


		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 GregorianCalendar firstDay = new GregorianCalendar(mYear, mMonth, mDay );
		 GregorianCalendar lastDay = (GregorianCalendar) firstDay.clone();
		 lastDay.add(Calendar.DAY_OF_MONTH, 1);

		 try {
		 	firstDay.add(Calendar.DAY_OF_MONTH, 5);
			 tt.getApptRange(appts, firstDay, lastDay);

		 } catch (Exception e) {
		 	System.out.println("Caught: " + e.getLocalizedMessage());
		 	lastDay.add(Calendar.DAY_OF_MONTH, 8);

		 }

		 System.out.println("DATE: " + firstDay.get(Calendar.MONTH) + " " + firstDay.get(Calendar.DAY_OF_MONTH) + " in " + firstDay.get(Calendar.YEAR));
		 System.out.println("DATE: " + lastDay.get(Calendar.MONTH) + " " + lastDay.get(Calendar.DATE));


		 tt.getApptRange(appts, firstDay, lastDay);
	 }
	 @Test
	public void test02 () {
	 	//test for getApptOccurences

		 Appt appt0 = new Appt(100, 30 , 10 , 4 , 2017 ,
				 "Birthday Party", "This is my birthday party.");
		 Appt appt1 = new Appt(13, 30 , 5 , 5 , 2017 ,
				 "Birthday Party", "This is my birthday party.");
		 Appt appt2 = new Appt(10, 30 , 6 , 5 , 2017 ,
				 "Pay tuition", "I have to make a payment for spring term");
		 Appt appt3 = new Appt(10, 30 , 12 , 4 , 2017 ,
				 "Dental", "Time for dental examination");
		 Appt appt4 = new Appt(10, 30 , 12 , 7 , 2017 ,
				 "Summer Vacation", "Take a break in summer");


		 TimeTable tt = new TimeTable();

		 int mMonth;
		 int mYear;
		 int mDay;
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 mMonth = rightnow.get(Calendar.MONTH)+1;
		 mYear = rightnow.get(Calendar.YEAR);
		 mDay = rightnow.get(Calendar.DAY_OF_MONTH);


		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 GregorianCalendar firstDay = new GregorianCalendar(mYear, mMonth, mDay );
		 GregorianCalendar lastDay = (GregorianCalendar) firstDay.clone();
		 lastDay.add(Calendar.DAY_OF_MONTH, 20);


		 System.out.println("DATE: " + firstDay.get(Calendar.MONTH) + " " + firstDay.get(Calendar.DAY_OF_MONTH) + " in " + firstDay.get(Calendar.YEAR));
		 System.out.println("DATE: " + lastDay.get(Calendar.MONTH) + " " + lastDay.get(Calendar.DATE));

		 listAppts.add(appt0);
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);
		 listAppts.add(appt4);


		 tt.getApptRange(listAppts, firstDay, lastDay);

	 }

	 @Test
	public void test03() {
	 	//test for deleteAppt
		 TimeTable tt = new TimeTable();

		 Appt appt1 = new Appt(13, 30 , 5 , 5 , 2017 ,
				 "Birthday Party", "This is my birthday party.");
		 Appt appt2 = new Appt(10, 30 , 6 , 5 , 2017 ,
				 "Pay tuition", "I have to make a payment for spring term");
		 Appt appt0 = null;
		 Appt appt00 = new Appt(100, 30 , 6 , 5 , 2017 ,
				 "Pay tuition", "I have to make a payment for spring term");

		 int mMonth;
		 int mYear;
		 int mDay;
		 Calendar rightnow = Calendar.getInstance();
		 //current month/year/date is today
		 mMonth = rightnow.get(Calendar.MONTH)+1;
		 mYear = rightnow.get(Calendar.YEAR);
		 mDay = rightnow.get(Calendar.DAY_OF_MONTH);

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 GregorianCalendar firstDay = new GregorianCalendar(mYear, mMonth, mDay );
		 GregorianCalendar lastDay = (GregorianCalendar) firstDay.clone();
		 lastDay.add(Calendar.DAY_OF_MONTH, 20);

		 listAppts.add(appt1);
		 listAppts.add(appt2);

		 tt.getApptRange(listAppts, firstDay, lastDay);
		 tt.deleteAppt(listAppts, appt2);
		 tt.deleteAppt(listAppts, appt00);
		 tt.deleteAppt(listAppts, appt2);
		 tt.deleteAppt(listAppts, appt0);

		 listAppts = null;
		 tt.deleteAppt(listAppts, appt0);



	 }

}


/*




 */
