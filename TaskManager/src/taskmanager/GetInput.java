package taskmanager;

import java.text.*;
import java.util.*;

public class GetInput {

    Scanner s = new Scanner(System.in);

    int getChoice(int min, int max) {
        while (true) {
            try {
                int choice = Integer.parseInt(s.nextLine());
                //out of range
                if (choice < min || choice > max) throw new NumberFormatException();
                return choice;
                
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number from " + min + " to " + max + ": ");
            }
        }
    }

    String getString() {
        while (true) {
            String input = s.nextLine();
            //user do not input
            if (input.length() == 0) System.out.print("Not empty. Please re-input: "); 
            else return input;
        }
    }

    int getInt(int max){
        while (true) {            
            try {
                int input = Integer.parseInt(s.nextLine());
                if(input < 1 || input > max) throw new NumberFormatException();
                return input;
            } catch (NumberFormatException e) {
                System.out.print("Please input an integer from 1 to " + max + ": ");
            }
        }
    }
    
    double getFrom() {
        while (true) {
            try {
                double from = Double.parseDouble(s.nextLine());
                //valid input
                if (from % 0.5 == 0 && from >= 8.0 && from < 17.5) return from;
                 //invalid input
                else throw new NumberFormatException();               
            } catch (NumberFormatException e) {
                System.out.print("Please input a number divided by 0.5 and greater than 7.5 and smaller than 17.5: ");
            }
        }
    }
    
    double getTo(double from){
        while (true) {            
            try {
                double to = Double.parseDouble(s.nextLine());
                //valid input
                if (to % 0.5 == 0 && to >= 8.0 && to <= 17.5 && to > from) return to;
                 //invalid input
                else throw new NumberFormatException();               
            } catch (NumberFormatException e) {
                System.out.print("Please input a number divided by 0.5 and greater than " + from + " and smaller than 18: ");
            }
        }
    }
    
    int getTypeID() {
        while (true) {
            try {
                int id = Integer.parseInt(s.nextLine());
                //valid id
                if(id >= 1 && id <= 4) return id;
                //id out of range
                else throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.print("Please choose from 1 to 4: ");
            }
        }
    }

    //date format
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    //check date's format
    public boolean checkDateFormat(String inputDate) {
        //date format
        String format = "(0?[1-9]|[12][0-9]|3[01])\\-(0?[1-9]|1[0-2])\\-([0-9]{4})";
        boolean isMatch = false;
        //user input a date matches the format
        if (inputDate.matches(format)) {
            isMatch = true;
        }
        return isMatch;
    }

    //check date's exist
    public boolean checkExistDate(String date) {
        boolean valid = false;
        //date matches the format
        if (checkDateFormat(date)) {
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
    public String getInputDate() throws ParseException {
        //if the input is invalid, re-input until it is valid
        while (true) {
            String inputDate = s.nextLine().trim();
            //user input a valid date format then check the date's validation            
            if (checkDateFormat(inputDate)) {
                //user's date is valid
                if (checkExistDate(inputDate)) {
                    return inputDate;
                } //user's date is invalid
                else {
                    System.out.print("Date is unexist. Please input a date in format dd-MM-yyyy: ");
                }
            } //user do not input anything
            else if ("".equals(inputDate)) {
                System.out.print("Not empty. Please input a date in format dd-MM-yyyy: ");
            } //user input an invalid format
            else {
                System.out.print("Invalid format. Please input a date in format dd-MM-yyyy: ");
            }
        }
    }
    
}
