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

		 cal = new CalDay(g);
		 cal.iterator();

		 String test = cal.getSizeAppts() + " ";
		 System.out.println(test + " here");

		 System.out.println(cal.getDay() + " here");			//day:	28
		 System.out.println(cal.getMonth() + " here");		//month: 3
		 System.out.println(cal.getYear() + " here");		//year: 2017

		 cal.addAppt(appt0);
		 cal.addAppt(appt1);
		 cal.addAppt(appt2);
		 cal.iterator();


		 cal.toString();
	 }

}
