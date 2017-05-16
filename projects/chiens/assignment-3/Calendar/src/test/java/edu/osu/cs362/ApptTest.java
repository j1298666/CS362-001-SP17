package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
	 	//All pass
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(13, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
    //use set to give valid number
	 }

	@Test
	public void test02()  throws Throwable  {
		//All pass with lower boundary
		int startHour=0;
		int startMinute=0;
		int startDay=1;
		int startMonth=1;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);
		// assertions
		assertTrue(appt.getValid());
		assertEquals(0, appt.getStartHour());
		assertEquals(0, appt.getStartMinute());
		assertEquals(1, appt.getStartDay());
		assertEquals(1, appt.getStartMonth());
		assertEquals(2017, appt.getStartYear());
		assertEquals("Birthday Party", appt.getTitle());
		assertEquals("This is my birthday party.", appt.getDescription());
	}

    @Test
    public void test03()  throws Throwable  {
        //All pass with upper boundary
        int startHour=23;
        int startMinute=59;
        int startDay=31;
        int startMonth=12;
        int startYear=2017;
        String title="Birthday Party";
        String description="This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);
        // assertions
        assertTrue(appt.getValid());
        assertEquals(23, appt.getStartHour());
        assertEquals(59, appt.getStartMinute());
        assertEquals(31, appt.getStartDay());
        assertEquals(12, appt.getStartMonth());
        assertEquals(2017, appt.getStartYear());
        assertEquals("Birthday Party", appt.getTitle());
        assertEquals("This is my birthday party.", appt.getDescription());
    }

	 @Test
	public void test04() throws Throwable {
	 	 //Test failed for each upper boundary
		 //Test for each setValue to make sure each one influence valid
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 assertTrue(appt.getValid());

		 appt.setStartYear(200000);
		 appt.setStartMonth(50);
		 assertFalse(appt.getValid());
		 appt.setStartMonth(4);
		 assertTrue(appt.getValid());
		 appt.setStartDay(50);
		 assertFalse(appt.getValid());
		 appt.setStartDay(10);
		 assertTrue(appt.getValid());
		 appt.setStartMinute(70);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(30);
		 assertTrue(appt.getValid());
		 appt.setStartHour(100);
		 assertFalse(appt.getValid());
	 }

	 @Test
	 public void test05() throws Throwable {
	 	//set for lower boundary
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 assertTrue(appt.getValid());

		 appt.setStartYear(-1);
		 appt.setStartMonth(-1);
		 assertFalse(appt.getValid());
		 appt.setStartDay(-1);
		 assertFalse(appt.getValid());
		 appt.setStartMinute(-1);
		 assertFalse(appt.getValid());
		 appt.setStartHour(-1);
		 assertFalse(appt.getValid());
	 }
	 @Test
	public void test06() throws Throwable{
	 	//test for null string
		 int startHour=13;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title=null;
		 String description=null;
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 assertEquals("", appt.getDescription());
		 assertEquals("", appt.getTitle());
	}

	@Test
	public void test07() throws Throwable {
	 	//test for to string (pm)
		//invalid condition first
		int startHour=-1;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		String mString = appt.toString();

		appt.setStartHour(13);
		mString = appt.toString();

		assertEquals(mString, "\t"+ "4/10/2017 at 1:30pm ,Birthday Party, This is my birthday party."+"\n");
	}

	@Test
	public void test08() throws Throwable {
		//test for to string (pm)
		//invalid condition first
		int startHour=10;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		String mString = appt.toString();

		assertEquals(mString, "\t"+ "4/10/2017 at 10:30am ,Birthday Party, This is my birthday party."+"\n");
	}
	@Test
	public void test09() throws Throwable {
		//test for to string (printableHour = 0 , 11)
		//invalid condition first
		int startHour=0;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		String mString = appt.toString();

		assertEquals(mString, "\t"+ "4/10/2017 at 12:30am ,Birthday Party, This is my birthday party."+"\n");
		appt.setStartHour(11);
		mString = appt.toString();
		assertEquals(mString, "\t"+ "4/10/2017 at 11:30am ,Birthday Party, This is my birthday party."+"\n");

	}

}
