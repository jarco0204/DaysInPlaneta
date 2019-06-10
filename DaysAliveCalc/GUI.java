import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JFrame; // Create main Window
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This program has the job of calculating the number of days alive of someone
 * The Algorithm is simple and depends on the birthday input 
 *
 * @author (Johan Arcos)
 * @version (0.0.1)
 */
public class GUI
{
    // Instances Variables
    private JFrame mainFrame;
    private JComboBox days;
    private JComboBox months;
    private JComboBox years;
   
    
    
    /**
     * This is the constructor of the class.
     * 
     */
    public GUI()
    {
       mainFrame = new JFrame();
       mainFrame.setSize(300, 200);
       mainFrame.setTitle("CARPE DIEM");
       mainFrame.setResizable(false);
       mainFrame.setLayout(new FlowLayout()); // This is the default LayoutManager, but I wanted to remember how to write a statement like this
       mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       mainFrame.getContentPane().setBackground(Color.gray); //To Change the background of a JFRame call the getContentPane method
       // JLabel To Specify the input the user needs to enter
       createMyJLabel();
       // 3 JComboBox to receive input from user
       createJComboBoxes();
       
       //Final Button
       createJButton();
       
       mainFrame.setVisible(true);
       // Create Secondary objects
       
    }
    /**
     * This function helps my program have high cohesion ( every logical task is associated with an specific function)
     * @param none
     * @return void
     */
    private void createMyJLabel()
    {
       /*ImageIcon imageIcon = new ImageIcon("text1.PNG");
       Image image = imageIcon.getImage(); // transform it
       Image newimg = image.getScaledInstance(42,42, java.awt.Image.SCALE_SMOOTH); // Scale it the smooth way
       imageIcon = new ImageIcon(newimg);
       This part is removed because of how my JAR file cannot contain this photo and it messes the alignment of the components
       */ 
       JLabel information = new JLabel(" Enter Birthday To Calculate:        ");
       information.setFont(new Font("SansSerif",Font.ROMAN_BASELINE, 16));
       mainFrame.add(information); 
    }
    /**
     * This function helps my program have high cohesion ( every logical task is associated with an specific function)
     * @param none
     * @return void
     */
    private void createJComboBoxes()
    {
        Integer daysOfMonth[]= new Integer[31];
       for (Integer i= 0; i<daysOfMonth.length; i++)
       {
           daysOfMonth[i]= i+1;
        }
       days = new JComboBox(daysOfMonth);
       mainFrame.add(days);
       //Second JCombo
       String monthNames[]={"January","February","March","April",
           "May","June","July","August","September","October",
           "November","December"};
       months = new JComboBox(monthNames);
       mainFrame.add(months);
       // third JCombo
       ArrayList<Integer> years1= new ArrayList<Integer>();
       for( int year= 1950; year<=Calendar.getInstance().get(Calendar.YEAR); year++)
       {
           years1.add(year);
        }
       years = new JComboBox(years1.toArray());
       mainFrame.add(years);
    }
    /**
     * This function helps my program have high cohesion ( every logical task is associated with an specific function)
     * @param none
     * @return void
     */
    private void createJButton()
    {
       JButton calculateIt = new JButton("Days Alive");
       calculateIt.setBackground(Color.ORANGE);
       calculateIt.setSize(60, 30);
       
       mainFrame.add(calculateIt);
       // The Event listener
       calculateIt.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               int answer = calculateTheDays(days.getSelectedItem(),months.getSelectedItem().toString(),years.getSelectedItem());
               JDialog d = new JDialog(mainFrame,"Every Day Is Unique",true);
               d.add(new JLabel("Today is your day:" + answer));
               d.setLocationRelativeTo(mainFrame);
               d.setSize(250,150);
               d.setVisible(true);
            }
        }); 
    }
    /**
     * This is a private function that performs the calculation of how many days one has been alive.
     * @param Three strings representing the day,month, and year.
     * @return an int representing the number of days in this congruent planet.
     */
    private int calculateTheDays(Object day, String month, Object year)
    {
        
        InformationHandler compInf = new InformationHandler(day, month, year);
        return compInf.getMagicalNumber();
        
        
    }
}
