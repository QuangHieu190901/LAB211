package fruitshop;

import java.util.Scanner;

public class GetInput {
    
    Scanner s = new Scanner(System.in);

    int getChoice(int min, int max){
        while (true) {            
            try {
                int choice = Integer.parseInt(s.nextLine());
                //out of range
                if(choice < min || choice > max) throw new NumberFormatException();
                else return choice;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number from " + min + " to " + max + ": ");
            }
        }
    }
    
    String getString(){
        while (true) {            
            String input = s.nextLine();
            //empty input
            if(input.isEmpty()) System.out.print("Not empty. Please re-enter: ");
            else return input;
        }
    }
    
    int getInt(){
        while (true) {            
            try {
                int input = Integer.parseInt(s.nextLine());
                //negetive input
                if(input <= 0) throw new NumberFormatException();
                else return input;
            } catch (NumberFormatException e) {
                System.out.print("Please input a positive integer: ");
            }
        }
    }
    
    double getDouble(){
        while (true) {            
            try {
                double input = Double.parseDouble(s.nextLine());
                //negetive input
                if(input <= 0) throw new NumberFormatException();
                else return input;
            } catch (NumberFormatException e) {
                System.out.print("Please input a positive number: ");
            }
        }
    }
    
    boolean getYN(){
        while (true) {            
            String option = getString();
            //choose yes
            if(option.equalsIgnoreCase("y")) return true;
            //choose no 
            else if(option.equalsIgnoreCase("n")) return false;
            else System.out.print("Please choose y/Y or n/N: ");
        }
    }
}
