import java.util.Calendar;
/**
 * In ordee to make my program have a high degree of cohesion and low coupling,
 * I am keeping the GUI class separate from every other function 
 * that deals with the calculation of the variable.
 *
 * @author (Johan Arcos)
 * @version (1.1.1)
 */
public class InformationHandler
{
  //Instances, low coupling — implies declaring fields as privates.
  private LeapYearCalc leapYears; // Array that contains leap years
  private MonthDict monthDays; // Month Conversion to numerical value
  private int daysAnswer;
  
  /**
   * This constructor initializes both variables
   * 
   */
 
  public InformationHandler(Object day, String month, Object year)
  {
      // Initiating fields
      daysAnswer = 0;
      monthDays = new MonthDict();
      leapYears = new LeapYearCalc();
      // Initiating parameters variables
      int bornDay = (Integer) day; // Casting and unboxing
      int bornYear = (Integer) year;
      int numMonthRepre = monthDays.getMonthRep(month);
      
      
      
      calculateDaysBornYear(bornDay,month, numMonthRepre,bornYear);
      bornYear++;
      calculateDaysYearTillCurrent(bornYear);
      calculateDaysPassed();
      /*
      
      
      */
      
    }
    /**
       * Public method to return the answer calculated
     * @return int
     */
   public int getMagicalNumber()
    {
      return daysAnswer;
    }
    /**
     * This method calculates the days passed since the born day (INCLUDING) to the end of
     * the born year
     * @param int, String, int, int ( day, Month, MonthAsNumber, year)
     * @return void
     */
   private void calculateDaysBornYear(int dayBorn, String monthBorn, int monthRepre, int yearBorn)
   {
       int daysInMonth = monthDays.getDaysInMonth(monthBorn);
       if (leapYears.checkYear(yearBorn))
      { // If the year is leap only these two months we care to make the
          //Calculation.
          if (monthBorn.equals("January"))
                {
                 daysAnswer = daysInMonth- dayBorn;
                 //Since this is not a traditional substraction, I am going to add one extray day to the daysAnswer
                 //which represents the born day.
                 daysAnswer++;
                 monthRepre++;
                 daysInMonth= monthDays.getDaysInMonth(monthRepre); // Getting the days in Februry
                 daysInMonth++; // 29 days in February
                 daysAnswer = daysAnswer + daysInMonth;
                 monthRepre++; // Move to March
                 
                }
          else if (monthBorn.equals("February"))
                { 
                    daysInMonth++; //29 days
                    daysAnswer = daysInMonth - dayBorn;
                    daysAnswer++; // Including day born
                    monthRepre++; // Move to March
                    
            }
          else 
          {
              daysAnswer = daysInMonth - dayBorn;
              daysAnswer++; //Including day born
              monthRepre++;
            }
            
        }
       else
       { // Process the born month
           daysAnswer = daysInMonth - dayBorn; 
           daysAnswer++; // Same reason as above
           monthRepre++; // We move to a new month to process
        }
        // Execute tge same algorithm to calculate reamaining days
         while(monthRepre <= 12)
                    {
                        daysInMonth = monthDays.getDaysInMonth(monthRepre);
                        daysAnswer= daysAnswer + daysInMonth;
                        monthRepre++; // Processing another month
                    }
         
    }
    /**
     * This method calculates the days passed from born year until current year
     * @param int representing bornYear
     * @ return void
     */
    private void calculateDaysYearTillCurrent(int bornYear)
    {
        // Now Calculating the days from next year from born year to the beginning of this year
      
      while(bornYear< Calendar.getInstance().get(Calendar.YEAR))
      {
          if (leapYears.checkYear(bornYear))
          {
              daysAnswer = daysAnswer + leapYears.getDaysInYear(true);
              
              
            }
          else
          {
              daysAnswer = daysAnswer + leapYears.getDaysInYear(false);
            }
           bornYear++;
        }
    }
    /**
     * This function calculates the days that has passed until today
     * @param void
     * @return void
     */
    private void calculateDaysPassed()
    {
        Calendar now = Calendar.getInstance();
      
      int currentDayNumber = now.get(Calendar.DAY_OF_YEAR);
     
      daysAnswer= daysAnswer + currentDayNumber;
    }
}
