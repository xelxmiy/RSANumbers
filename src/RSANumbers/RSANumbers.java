package RSANumbers;
//imports 
import java.util.*;
import javax.swing.JOptionPane;

/**
 * @author Adam Belski
 * @version 1.0.0
 * @since 12-Feb-2023
 */
public class RSANumbers {
    //init vars
    static int Min = -1;
    static int Max = -1;
    static ArrayList<Integer> RSANumbers = new ArrayList<>();
    
    public static void main(String[] args) {
        //for debugging, pls ignore :3 thank
        Thread thread = new Thread(() -> {
             while (true) {
             System.out.println("min: " + Min);
             System.out.println("max: " + Max);
            }
         });
        thread.start();
        
        //my least fav part of every project is the UI
        //get the Min and Max
        //thanks WachCity code
        //geting the lower limit
        while(Min < 0) {
            try {
                Min = Integer.parseInt(JOptionPane.showInputDialog(
                     null, "Enter the lower limit of the range",
                     "RSANumbers",
                     JOptionPane.INFORMATION_MESSAGE));
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null,
                "Please enter a positive integer!",
                "RSANumbers", 
                JOptionPane.INFORMATION_MESSAGE);           
            }
        }
        //get our upper limit
        while(Max < 0) {
            try {
                Max = Integer.parseInt(JOptionPane.showInputDialog(
                     null,
                     "Enter the upper limit of the range",
                     "RSANumbers",
                     JOptionPane.INFORMATION_MESSAGE));
                //don't wanna implement backwards range 
                if(Max < Min) {
                    Max = -1;
                    throw new ArithmeticException("Unable to calculate ranges backwards");
                }
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null,
                "Please enter a positive integer greater than the Min!",
                "RSANumbers",
                JOptionPane.INFORMATION_MESSAGE);           
            }
        }
            //make our RSA calculation
            CheckRSA(Min, Max); 
            //display final results
            JOptionPane.showMessageDialog(null,
                "There are " + RSANumbers.size() + " RSA numbers between " + Min + " and " + Max + "." ,
                "RSANumbers",
                JOptionPane.INFORMATION_MESSAGE);
            //go again screen
            Object[] options = {"again", "quit"};
            int choice = JOptionPane.showOptionDialog(null,
                        "Thank you for using RSANumbers",
                   "RSANumbers",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                    null, options, null);
                        // play again
                        if(choice == JOptionPane.YES_OPTION) {
                            RSANumbers.removeAll(RSANumbers);
                            Min = -1;
                            Max = -1;
                            main(args);
                        }
                        else System.exit(0);    
        
    }
    public static void CheckRSA(int min, int max) {
        for(int i = min; i < max; i++) {
            if (isRSA(i)) {
                //since we only care about *how many* RSA numbers there are within
                //range we could just increment a counter, but i'd prefer to do it 
                //this way so if need be i could adapt it to show which nums those are
                RSANumbers.add(i);
            }
        }    
    }
    //check if the number is an RSA number
    public static boolean isRSA(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        count++;
      }
    }
    return count == 4;
    }
}
//this one was really short wow 