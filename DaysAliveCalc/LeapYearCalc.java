import java.util.HashSet;
import java.util.Calendar;
/**
 * This class has the job of calculating the leap years.
 * The rules to obey to calculate the years that are leap are as following:
 * Every year divisible by 4 is a leap year.
 * Century years are leap if divisible by 400.
 *
 * @author (Johan Arcos)
 * @version (1.1.1)
 */
public class LeapYearCalc
{
    private static final Integer STARTINGYEAR= 1900;
    private HashSet<Integer> collectionYears;
    private static final int NUMDAYSINYEAR=365;
    private static final int NUMDAYSINLEAPYEAR=366;
    /**
     * Constructor of the class
     */
    public LeapYearCalc()
    {
        collectionYears = new HashSet<>();
        addNumbers();
    }
    /**
     * Method adds the numbers from 1900 to today the years that are leap
     * @return void
     */
    private void addNumbers()
    {
        Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Integer year = STARTINGYEAR;
        while(year <= currentYear)
        {
            if(year % 100 == 0 ) //checking century years
            {
                if(year % 400== 0)
                {collectionYears.add(year);}
            }
            else 
            {
                if ( year % 4 == 0)
                collectionYears.add(year);
            }
            year++;
        }
    }
    /**
     * This is a public method that returns the panoply of leap years
     * @returns an array of integers
     */
    public Integer[] returnNumbers()
    {
        Integer[] array = new Integer[collectionYears.size()];
        collectionYears.toArray(array);
        return array;
    }
    /**
     * Method to calculate if the param month belongs to the leap yers
     * concoct
     */
    public boolean checkYear(int yearToCheck)
    {
        return collectionYears.contains(yearToCheck); //Auto-boxing
    }
    /**
     * Method to return the days in a year or leap year
     * @return int
     * @param a boolean; if true then we are returning 366 else 365
     */
    public int getDaysInYear( boolean answer)
    {
       if(answer == true)
       return NUMDAYSINLEAPYEAR;
       else
       return NUMDAYSINYEAR;
    }
}
