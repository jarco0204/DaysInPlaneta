

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MonthDictTest.
 *
 * 
 */
public class MonthDictTest
{
    private MonthDict testMonthDict;

    /**
     * Default constructor for test class MonthDictTest
     */
    public MonthDictTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        testMonthDict = new MonthDict();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void getDaysInMonth()
    {
        MonthDict monthDic1 = new MonthDict();
        assertEquals(31, testMonthDict.getDaysInMonth(1));
        assertEquals(12, testMonthDict.getMonthRep("December"));
        assertEquals(7, testMonthDict.getMonthRep("July"));
        assertEquals(31, testMonthDict.getDaysInMonth("March"));
        assertEquals(28, testMonthDict.getDaysInMonth(2));
    }
}

