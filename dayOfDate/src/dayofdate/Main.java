package dayofdate;

import java.text.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws ParseException {
        DayOfDate d = new DayOfDate();
        GetInput g = new GetInput();
        System.out.print("Please enter date with format [dd/mm/yyyy]: ");
        //user input a date and check that date is exist
        Date inputDate = g.getInputDate();
        //day of the week of the date
        System.out.print("Your day is " + d.determineDayOfDate(inputDate));
        System.out.println("");
    }
    
}
