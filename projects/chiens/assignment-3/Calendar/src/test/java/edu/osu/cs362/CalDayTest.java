package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		 GregorianCalendar g = new GregorianCalendar();
		 CalDay cal = new CalDay();
		 cal.iterator();
		 cal.toString();

//		 According to the test, the new LinkedList is an empty list rather than null
//		 LinkedList<String> isNULL = new LinkedList<String>();
//		 assertEquals(isNULL, null);
//

		 Appt appt0 = new Appt(100, 30 , 10 , 4 , 2017 ,
				 "Birthday Party", "This is my birthday party.");
		 Appt appt1 = new Appt(13, 30 , 10 , 4 , 2017 ,
				 "Birthday Party", "This is my birthday party.");
		 Appt appt2 = new Appt(10, 30 , 10 , 4 , 2017 ,
				 "Pay tuition", "I have to make a payment for spring term");
		 assertFalse(cal.isValid());
		 assertEquals(null, cal.iterator());

		 cal = new CalDay(g);

		 cal.iterator();
		 assertEquals(0,cal.getSizeAppts());

		 cal.addAppt(appt0);
		 assertEquals(0,cal.getSizeAppts());
		 cal.addAppt(appt1);
		 assertEquals(1,cal.getSizeAppts());
		 cal.addAppt(appt2);
		 assertEquals(2,cal.getSizeAppts());

		 System.out.println("iterator " + cal.iterator());
		 //assertEquals(cal.getAppts().iterator(), cal.iterator());

		 Iterator<Appt> e = cal.appts.iterator();
		 Iterator<?> test = cal.iterator();
			int i = 0;
		 while(e.hasNext()&&test.hasNext()) {
			 Object ele_e = e.next();
			 Object ele_t = test.next();
			 assertEquals(ele_e.toString(), ele_t.toString());
		 }
	 }

	 @Test
	public void test02() {
	 	//Test for getVal methods: add 1 for day, month, year
		 GregorianCalendar today = new GregorianCalendar();
		 GregorianCalendar tomorrow = new GregorianCalendar();
		 while(today.get(Calendar.DAY_OF_MONTH) != 1){
			 today.add(Calendar.DAY_OF_MONTH, 1);
			 tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		 }

		 tomorrow.add(Calendar.DAY_OF_MONTH, 1);
		 tomorrow.add(Calendar.YEAR, 1);
		 tomorrow.add(Calendar.MONTH, 1);

		 CalDay cal_today = new CalDay(today);
		 CalDay cal_tomo = new CalDay(tomorrow);
		 assertEquals(cal_today.getDay() + 1, cal_tomo.getDay());
		 tomorrow = new GregorianCalendar();
		 assertEquals(cal_today.getMonth()+1, cal_tomo.getMonth());
		 assertEquals(cal_today.getYear()+1, cal_tomo.getYear());

	 }

	 @Test
	public void test03() {
	 	//Test for Linkedlist appt
		 GregorianCalendar g = new GregorianCalendar();
		 CalDay cal = new CalDay(g);
		 Appt appt1 = new Appt(13, 30 , 10 , 4 , 2017 ,
				 "Birthday Party", "This is my birthdayT party.");
		 Appt appt11 = new Appt(13, 40 , 10 , 4 , 2017 ,
				 "Birthday Party", "This is my birthday party.");
		 Appt appt2 = new Appt(10, 30 , 10 , 4 , 2017 ,
				 "Pay tuition", "I have to make a payment for spring term");
		 Appt appt3 = new Appt(12, 30 , 10 , 4 , 2017 ,
				 "Pay tuition", "I have to make a payment for spring term");

		 cal.addAppt(appt1);
		 cal.addAppt(appt2);
		 cal.addAppt(appt3);
		 cal.addAppt(appt11);

		 for (int i = 0; i < cal.getAppts().size() - 1; i++) {
		 	//System.out.println(cal.getAppts().get(i).getStartMinute() + " " + cal.getAppts().get(i+1).getStartMinute());
		 	assertTrue(cal.getAppts().get(i).getStartHour() <= cal.getAppts().get(i+1).getStartHour());
		 	assertTrue(cal.getAppts().get(i).getStartMinute() <= cal.getAppts().get(i+1).getStartMinute());
		 }
	 }

	 @Test
	public void test04() {
	 	//Test for iterator
		 GregorianCalendar g = new GregorianCalendar();
		 CalDay cal = new CalDay(g);
		 Appt appt1 = new Appt(13, 30 , 10 , 4 , 2017 ,
				 "Birthday Party", "This is my birthday party.");
		 Appt appt2 = new Appt(10, 30 , 10 , 4 , 2017 ,
				 "Pay tuition", "I have to make a payment for spring term");
		 Appt appt3 = new Appt(12, 30 , 10 , 4 , 2017 ,
				 "Pay tuition", "I have to make a payment for spring term");

		 cal.addAppt(appt1);
		 cal.addAppt(appt2);
		 cal.addAppt(appt3);
	 }

	 @Test
	 public void test05() {
		 //Test for toString
		 GregorianCalendar g = new GregorianCalendar();
		 CalDay cal = new CalDay(g);
		 Appt appt1 = new Appt(13, 30 , 10 , 4 , 2017 ,
				 "Birthday Party", "This is my birthday party.");
		 Appt appt2 = new Appt(10, 30 , 10 , 4 , 2017 ,
				 "Pay tuition", "I have to make a payment for spring term");

		 cal.addAppt(appt1);
		 cal.addAppt(appt2);

		 StringBuilder sb = new StringBuilder();
		 String todayDate = (cal.getMonth()) + "/" + cal.getDay() + "/" + cal.getYear();
		 sb.append("\t --- " + todayDate + " --- \n");
		 sb.append(" --- -------- Appointments ------------ --- \n");
		 Iterator<Appt> itr = cal.appts.iterator();
		 while(itr.hasNext()) {
			 Object element = itr.next();
			 sb.append(element + " ");
		 }
		 //sb.append(cal.appts);
		 sb.append("\n");

		 assertEquals(sb.toString(), cal.toString());
	 }
}
