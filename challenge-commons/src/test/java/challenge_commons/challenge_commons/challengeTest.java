package challenge_commons.challenge_commons;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class challengeTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public challengeTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( challengeTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testchallenge()
    {
        assertTrue( true );
    }
}
