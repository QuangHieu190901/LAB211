package dayofdate;

import java.util.*;
import java.text.*;

public class GetInput {
          
    //date format
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Scanner scanner = new Scanner(System.in);

    //check date's format
    public boolean checkDateFormat(String inputDate){
        //date format
        String format = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
        boolean isMatch = false;
        //user input a date matches the format
        if(inputDate.matches(format)) isMatch = true;
        return isMatch;
    }

    //check date's exist
    public boolean checkExistDate(String date){
        boolean valid = false;
        //date matches the format
        if(checkDateFormat(date)){
            dateFormat.setLenient(false);
            //date is invalid or not
            try {
                dateFormat.parse(date);
                //valid
                valid = true;
            } catch (ParseException e) {
                //invalid
                valid = false;
            }
        }
        return valid;
    }
    
    //check uesr's input 
    public Date getInputDate() throws ParseException{
        //if the input is invalid, re-input until it is valid
        while (true) { 
            String inputDate = scanner.nextLine();
            //user input a valid date format then check the date's validation            
            if (checkDateFormat(inputDate)) {
                //user's date is valid
                if(checkExistDate(inputDate)) return dateFormat.parse(inputDate);
                //user's date is invalid
                else System.err.print("Date is unexist. Please input a date in format dd/MM/yyyy: ");
            } 
            //user do not input anything
            else if("".equals(inputDate)) System.err.print("Not empty. Please input a date in format dd/MM/yyyy: ");            
            //user input an invalid format
            else System.err.print("Invalid format. Please input a date in format dd/MM/yyyy: ");            
        }
    }
        
}
