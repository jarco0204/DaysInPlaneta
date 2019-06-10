

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InformationHandlerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InformationHandlerTest
{
    private InformationHandler endResult;

    /**
     * Default constructor for test class InformationHandlerTest
     */
    public InformationHandlerTest()
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
        endResult = new InformationHandler(2, "April", 1999);
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
    /**
     * I created an instance of the InformationHandler with my birthday data,
     * I made the calculation by hand and through a third-party
     * piece of software that checks the days passed between two dates.
     * SAME result.
     */
    public void testingMethod()
    {
        assertEquals(7363, endResult.getMagicalNumber());
    }
}

