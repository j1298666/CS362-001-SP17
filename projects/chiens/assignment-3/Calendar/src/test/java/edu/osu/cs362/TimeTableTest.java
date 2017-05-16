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
		 Calendar defaultDay = Calendar.getInstance();
		 while (defaultDay.get(Calendar.DAY_OF_MONTH) != 1){
			 defaultDay.add(Calendar.DAY_OF_MONTH, 1);
		 }//get first of next month avoid error
		 mMonth = defaultDay.get(Calendar.MONTH)+1;
		 mYear = defaultDay.get(Calendar.YEAR);
		 mDay = defaultDay.get(Calendar.DAY_OF_MONTH);

		 LinkedList<Appt> appts = new LinkedList<Appt>();
		 GregorianCalendar firstDay = new GregorianCalendar(mYear, mMonth, mDay );
		 GregorianCalendar lastDay = (GregorianCalendar) firstDay.clone();
		 lastDay.add(Calendar.DAY_OF_MONTH, 1);

		 //System.out.println("1 get appt range " + tt.getApptRange(appts, firstDay, lastDay));
		 //System.out.println("");
		 try {
		 	firstDay.add(Calendar.DAY_OF_MONTH, 2);
			 tt.getApptRange(appts, firstDay, lastDay);
		 } catch (Exception e) {
		 	System.out.println("Caught: " + e.getLocalizedMessage());
		 	lastDay.add(Calendar.DAY_OF_MONTH, 3);
		 }
		 //System.out.println("DATE: " + firstDay.get(Calendar.MONTH) + " " + firstDay.get(Calendar.DAY_OF_MONTH) + " in " + firstDay.get(Calendar.YEAR));
		 //System.out.println("DATE: " + lastDay.get(Calendar.MONTH) + " " + lastDay.get(Calendar.DATE));

		 tt.getApptRange(appts, firstDay, lastDay);
		 assertEquals((int)(tt.getApptRange(appts, firstDay, lastDay).getFirst().getDay()+1),
				 tt.getApptRange(appts, firstDay, lastDay).getLast().getDay());

	 }
	 @Test
	public void test02 () throws Throwable  {
	 	//test for getApptOccurences
		 TimeTable tt = new TimeTable();
		 int mMonth = 6;
		 int mYear = 2017;
		 int mDay = 1;

		 Appt appt0 = new Appt(100, 30 , mDay , mMonth , 2017 ,
				 "Birthday Party", "This is my birthday party.");
		 Appt appt1 = new Appt(13, 30 , mDay , mMonth , 2017 ,
				 "Birthday Party", "This is my birthday party.");
		 Appt appt2 = new Appt(10, 30 , mDay , mMonth , 2017 ,
				 "Pay tuition", "I have to make a payment for spring term");
		 Appt appt3 = new Appt(10, 30 , mDay+1 , mMonth , 2017 ,
				 "Dental", "Time for dental examination");
		 Appt appt4 = new Appt(10, 30 , mDay+5 , mMonth , 2017 ,
				 "Summer Vacation", "Take a break in summer");

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 GregorianCalendar firstDay = new GregorianCalendar(mYear, mMonth, mDay );
		 GregorianCalendar lastDay = (GregorianCalendar) firstDay.clone();
		 lastDay.add(Calendar.DAY_OF_MONTH, 2);

		 listAppts.add(appt0);
		 assertEquals(0,tt.getApptRange(listAppts, firstDay, lastDay).getFirst().getSizeAppts());
		 listAppts.add(appt1);
		 assertEquals(1,tt.getApptRange(listAppts, firstDay, lastDay).getFirst().getSizeAppts());
		 listAppts.add(appt2);
		 assertEquals(2,tt.getApptRange(listAppts, firstDay, lastDay).getFirst().getSizeAppts());
		 assertEquals(0,tt.getApptRange(listAppts, firstDay, lastDay).getLast().getSizeAppts());
		 //System.out.println("test add appts\n" + tt.getApptRange(listAppts, firstDay, lastDay).getFirst().getAppts());
		 listAppts.add(appt3);
		 //System.out.println("test add appts\n" + tt.getApptRange(listAppts, firstDay, lastDay).getLast().getAppts());
		 assertEquals(1,tt.getApptRange(listAppts, firstDay, lastDay).getLast().getSizeAppts());
		 listAppts.add(appt4);
		 assertEquals(2,tt.getApptRange(listAppts, firstDay, lastDay).size());

		 tt.getApptRange(listAppts, firstDay, lastDay);

	 }

	 @Test
	public void test03() throws Throwable  {
	 	//test for deleteAppt
		 TimeTable tt = new TimeTable();
		 int mMonth = 6;
		 int mYear = 2017;
		 int mDay = 1;

		 Appt appt1 = new Appt(13, 30 , mDay , mMonth , 2017 ,
				 "Birthday Party", "This is my birthday party.");
		 Appt appt2 = new Appt(10, 30 , mDay+1 , mMonth , 2017 ,
				 "Pay tuition", "I have to make a payment for spring term");
		 Appt appt0 = null;
		 Appt appt00 = new Appt(100, 30 , mDay+1 , mMonth , 2017 ,
				 "Pay tuition", "I have to make a payment for spring term");



		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 GregorianCalendar firstDay = new GregorianCalendar(mYear, mMonth, mDay );
		 GregorianCalendar lastDay = (GregorianCalendar) firstDay.clone();
		 lastDay.add(Calendar.DAY_OF_MONTH, 2);

		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 tt.getApptRange(listAppts, firstDay, lastDay);
		 assertEquals(1,tt.getApptRange(listAppts, firstDay, lastDay).getFirst().getSizeAppts());
		 assertEquals(1,tt.getApptRange(listAppts, firstDay, lastDay).getLast().getSizeAppts());

		 tt.deleteAppt(listAppts, appt2);
		 assertEquals(0,tt.getApptRange(listAppts, firstDay, lastDay).getLast().getSizeAppts());
		 System.out.println("test add appts\n" + tt.getApptRange(listAppts, firstDay, lastDay).getLast().getAppts());
		 assertEquals(null,tt.deleteAppt(listAppts, appt00));
		 tt.deleteAppt(listAppts, appt2);
		 assertEquals(null,tt.deleteAppt(listAppts, appt0));
		 listAppts = null;
		 assertEquals(null,tt.deleteAppt(listAppts, appt0));
	 }


}
