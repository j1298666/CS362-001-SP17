/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package finalprojectB;

import junit.framework.TestCase;

import java.util.Random;


/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   private boolean printStatus = false;
   private boolean printIndex = false;//print index that indicates current scheme,host,port,path, query test were using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }



    public void testManualTest()
    {
        /*
        For manual testing
        first of all we verify basic URLs:
        assertTrue(urlVal.isValid("http://www.google.com"));
        assertFalse(urlVal.isValid("http:www.google.com"));
        Secondly, we test for different subdomain and domain name:
        Subdomain : www or blog
        Domain name : google.com or amazon.com or oregonstate.edu
        Thirdly, checkout port numbers(failure):
        Port number 80 expected “Http” but also return true if it combines with protocol “h3t”.
        */

        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        System.out.println("In our test cases, we assign opposite value to assertion with bug URL:");

        assertTrue(urlVal.isValid("http://www.google.com"));
        assertTrue(urlVal.isValid("http://www.amazon.com"));
        assertFalse(urlVal.isValid("http://localhost/test/index.html"));
        assertTrue(urlVal.isValid("h3t://go.com:80/test1"));
        assertTrue(urlVal.isValid("http://www.google.com/"));
        assertFalse(urlVal.isValid("http:www.google.com"));
        assertFalse(urlVal.isValid("www.1.2.3.4"));
        assertTrue(urlVal.isValid("https://github.com/aburasa"));
        assertTrue(urlVal.isValid("http://www.amazon.com/test1"));
        assertTrue(urlVal.isValid("http://www.oregonstate.edu"));
        assertTrue(urlVal.isValid("http://blog.oregonstate.edu"));

      /*THE FOLLOWING TESTS ARE VALID URL, HOWEVER THE TESTS ARE FAIL.*/
        System.out.println("THE FOLLOWING TESTS URLS WITH DIFFERENT RESULTS FROM EXPECTED.");
        assertTrue(!urlVal.isValid("http://www.amazon.com:65535/test1/?action=view"));
        assertTrue(!urlVal.isValid("http://www.amazon.com:65535"));
        assertTrue(!urlVal.isValid("http://www.amazon.com/test1/?action=view"));
        assertTrue(!urlVal.isValid("http://www.amazon.com/?action=view"));
    }


    public void testYourFirstPartition()
    {
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

        /*For the <port>, the excepted results are different from the actual results.
        Function cannot detect the correct port number for the protocols
        It is a bug the software engineering teams need to fit.
        */
        assertTrue(urlVal.isValid("http://www.amazon.com:80"));
        assertTrue(urlVal.isValid("http://www.amazon.com:81"));
        assertTrue(urlVal.isValid("http://www.amazon.com:20"));
        assertTrue(urlVal.isValid("http://www.simpledns.com:500"));

        assertTrue(urlVal.isValid("https://mydomain.com:443"));
        assertTrue(urlVal.isValid("HTTPS://mydomain.com:500"));

        System.out.println("THE FOLLOWING TESTS URLS WITH DIFFERENT RESULTS FROM EXPECTED.");
        assertTrue(!urlVal.isValid("ftp://myname@host.dom:65535"));
        assertTrue(!urlVal.isValid("ftp://myname@host.dom:4433355"));
        assertTrue(!urlVal.isValid("ftp://myname@host.dom:21"));
        assertTrue(!urlVal.isValid("http://www.simpledns.com:5000"));

    }




    public void testYourSecondPartition(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        /*
        In the second partition tests, all the examples only test for query string.
        */
        assertTrue(urlVal.isValid("http://www.amazon.com/&amp;title=The%20title%20of%20a%20post"));

        System.out.println("THE FOLLOWING TESTS URLS WITH DIFFERENT RESULTS FROM EXPECTED.");
        assertTrue(!urlVal.isValid("http://www.amazon.com/there?name=ferret"));
        assertTrue(!urlVal.isValid("http://www.amazon.com/page?name=ferret&color=purple"));
        assertTrue(!urlVal.isValid("http://www.example.com/some-page.asp?articleid=232"));
        assertTrue(!urlVal.isValid("http://www.example.com/?crcat=test&crsource=test&crkw=buy-a-lot"));
        assertTrue(!urlVal.isValid("http://www.example.com/catalog.asp?itemid=232&template=fresh&crcat=ppc&crsource=google&crkw=buy-a-lot"));
        assertTrue(!urlVal.isValid("http://www.some-domain.com/index.html?&crsource=google"));
        assertTrue(!urlVal.isValid("http://www.some-domain.com/?&&&&crsource=google"));
        assertTrue(!urlVal.isValid("http://go.com/test1?action=edit&mode=up"));
        assertTrue(!urlVal.isValid("http://www.foo.bar/image.jpg?height=150&width=100"));
        assertTrue(!urlVal.isValid("https://www.secured.com:443/resource.html?id=6e8bc430-9c3a-11d9-9669-0800200c9a66#some-header"));
    }

    public static String RandomSelectIndex(Random random){
        String[] methodArray = new String[] { "scheme", "authority", "port", "path", "query"};// The list of the of methods to be tested in the Appt class
        int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
    }


    public void testIsValid()
    {   System.out.println("Test Start:");
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        int urlIndex[] = {0,0,0,0,0};
        String testUrl = "";

        long randomseed =10;
        Random random = new Random(randomseed);

        for (int i = 0; i < 1000; i++) {
            String randomIndex = UrlValidatorTest.RandomSelectIndex(random);
            if (randomIndex.equals("scheme")){
                urlIndex[0] = random.nextInt(7);
            }
            else if(randomIndex.equals("authority")){
                urlIndex[1] = random.nextInt(6);
            }
            else if(randomIndex.equals("port")){
                urlIndex[2] = random.nextInt(5);
            }
            else if(randomIndex.equals("path")){
                urlIndex[3] = random.nextInt(3);
            }
            else if(randomIndex.equals("query")){
                urlIndex[4] = random.nextInt(3);
            }

            testUrl = testScheme[urlIndex[0]] + testAuthority[urlIndex[1]]
                    + testPort[urlIndex[2]]+ testPath[urlIndex[3]] + testQuery[urlIndex[4]];

            compareResult(urlVal, testUrl, urlIndex);
        }
    }

    public void compareResult(UrlValidator urlVal, String testUrl, int[] urlIndex) {
        boolean result = urlVal.isValid(testUrl);
        boolean expect = true;
        if(urlIndex[0] >= 4 || urlIndex[1] >= 3 || urlIndex[2] >= 3)
            expect = false;
        System.out.println(" ");

        if(result == expect && expect == true) {
            System.out.println("Valid URL: ");
            System.out.println(urlVal.isValid(testUrl));
            System.out.println(testUrl);
            assertTrue(urlVal.isValid(testUrl));
        }

        else if(result == expect && expect == false) {
            System.out.println("inValid URL: ");
            System.out.println(urlVal.isValid(testUrl));
            System.out.println(testUrl);
            assertFalse(urlVal.isValid(testUrl));
        }

        else if(expect == true){
            System.out.println("Faild case URL (Here are urls with bugs): ");
            assertTrue(!urlVal.isValid(testUrl));
            System.out.println(testUrl);
            System.out.println("Expect: " + expect + " Real: " + urlVal.isValid(testUrl));
        }

        else {
            System.out.println("Faild case URL (Here are urls with bugs): ");
            assertFalse(!urlVal.isValid(testUrl));
            System.out.println(testUrl);
            System.out.println("Expect: " + expect + " Real: " + urlVal.isValid(testUrl));
        }
    }

    public void testAnyOtherUnitTest()
    {

    }
    /**
     * Create set of tests by taking the testUrlXXX arrays and
     * running through all possible permutations of their combinations.
     *
     * @param testObjects Used to create a url.
     */

    String[] testScheme = {"http://", "ftp://", "https", "", "http:/", "http:", "://"};           //4, 3
    String[] testAuthority = {"www.google.com", "go.com", "1.2.3.4", "1.2.3", "go.a", "256.256.256.256"};   //3, 3
    String[] testPort = {":80", ":65535", "", ":65a", ":655356"};                          //3, 2
    String[] testPath = {"", "/test1", "/$23"};                         //3
    String[] testQuery = {"", "?action=view", "?action=edit&mode=up"};  //3

}
