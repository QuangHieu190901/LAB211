package comparedate;

import java.text.*;
import java.util.*;

public class Main {
    //compare 2 dates
    public static void compareAndDisplay(Date date1, Date date2){
        //date 1 is before date 2
        if(date1.before(date2)) System.out.println("Date1 is before Date2");
        //date 2 is before date 1
        else if(date2.before(date1)) System.out.println("Date2 is before Date1");
        //same date 
        else System.out.println("Date1 and Date2 are the same");
        System.out.println("");
    }

    public static void main(String[] args) throws ParseException {
        System.out.print("Please enter the first date: ");
        //user input first date
        Date date1 = Validate.getInputDate();
        System.out.print("Please enter the second date: ");
        //user inpur second date
        Date date2 = Validate.getInputDate();
        System.out.println("");
        //compare date1 and date2
        compareAndDisplay(date1, date2);        
    }
    
}
