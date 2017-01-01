package com.challenge.challenge_tournament;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class tournamentTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public tournamentTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( tournamentTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testtournament()
    {
        assertTrue( true );
    }
}
