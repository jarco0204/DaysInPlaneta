import java.util.HashMap;
/**
 * This is a class consisting of two HashMaps that links the String Month to its number representation, and then to its days in it.
 *
 * @author (Johan Arcos)
 * @version (1.1.1)
 */
public class MonthDict
{
    //Instances
    private HashMap<String, Integer> monthsToNum;
    private HashMap<Integer, Integer> daysInMonthNum;
    /**
     * Constructor of the class
     */
    public MonthDict()
    {
        monthsToNum = new HashMap<>();
        monthsToNum.put("January",1);
        monthsToNum.put("February",2);
        monthsToNum.put("March",3);
        monthsToNum.put("April",4);
        monthsToNum.put("May",5);
        monthsToNum.put("June",6);
        monthsToNum.put("July",7);
        monthsToNum.put("August",8);
        monthsToNum.put("September",9);
        monthsToNum.put("October",10);
        monthsToNum.put("November",11);
        monthsToNum.put("December",12);
        // Other map
        daysInMonthNum = new HashMap<>(); // the angle bracets can be ignored because I am specifying the tag in the Instance part
        daysInMonthNum.put(1,31);
        daysInMonthNum.put(2,28);// This part is tricky because February has 28 or 29 days
        daysInMonthNum.put(3,31);
        daysInMonthNum.put(4,30);
        daysInMonthNum.put(5,31);
        daysInMonthNum.put(6,30);
        daysInMonthNum.put(7,31);
        daysInMonthNum.put(8,31);
        daysInMonthNum.put(9,30);
        daysInMonthNum.put(10,31);
        daysInMonthNum.put(11,30);
        daysInMonthNum.put(12,31);
        
    }
    /**
     * Method to return the associated value of the month String representation to number
     * @param String the name of the month
     * @return an int of the value of the month
     */ 
    public int getMonthRep(String monthName)
    {
        return monthsToNum.get(monthName);
    }
    /**
     * This method calculates a Month String to the days in it
     * @param String the name of the month
     * @return an int representing the number of days
     */
    public int getDaysInMonth(String monthName)
    {
        return daysInMonthNum.get(monthsToNum.get(monthName));
    }
    /**
     * Overloaded method to get the days in month from month Int
     */
    public int getDaysInMonth(int monthRepre)
    {
        return daysInMonthNum.get(monthRepre);
    }
}
