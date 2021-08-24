package comparedate;

import java.text.*;
import java.util.*;

public class Validate {
          
    //date format
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    static Scanner scanner = new Scanner(System.in);

    //check date format
    public static boolean checkDate(String inputDate){
        //date pattern
        String pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
        boolean isMatch = false;
        //user's date matches the format
        if(inputDate.matches(pattern)) isMatch = true;
        return isMatch;
    }

    //check valid date
    public static boolean isValidDate(String date){
        boolean valid = false;
        //date matches the format
        if(checkDate(date)){
            dateFormat.setLenient(false);
            //date is invalid
            try {
                dateFormat.parse(date);
                valid = true;
            } catch (ParseException e) {
                valid = false;
            }
        }
        return valid;
    }
    
    //check uesr's input 
    public static Date getInputDate() throws ParseException{
        //if the input is invalid, re-input until it is valid
        while (true) { 
            String inputDate = scanner.nextLine();
            //user input a valid date format then check the date's validation            
            if (checkDate(inputDate)) {
                //user's date is valid
                if(isValidDate(inputDate)) return dateFormat.parse(inputDate);
                //user's date is invalid
                else System.err.print("Date is unexist. Please input a date in format dd/MM/yyyy: ");
            } 
            //user do not input anything
            else if("".equals(inputDate)) System.err.print("Not empty. Please input a date in format dd/MM/yyyy: ");            
            //user input an invalid format
            else System.err.print("Please input a date in format dd/MM/yyyy: ");            
        }
    }
    
}
