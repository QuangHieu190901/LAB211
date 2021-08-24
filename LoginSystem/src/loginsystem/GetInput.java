package loginsystem;

import java.util.Scanner;

public class GetInput {
    
    Scanner s = new Scanner(System.in);
    
    int getChoice(int min, int max){
        while (true) {            
            try {
                int choice = Integer.parseInt(s.nextLine().trim());
                //out of range
                if(choice < min || choice > max) throw new Exception();
                else return choice;
            } catch (Exception e) {
                System.out.print("Please input an integer from " + min + " to " + max + ": ");
            }
        }
    }
    
    String getString(){
        while (true) {            
            String input = s.nextLine().trim();
            //empty input
            if(input.isEmpty()) System.out.print("Not Empty. Please re-input: ");
            else return input;
        }
    }
    
    
    String getUsername(){
        //valid username
        final String VALID_USERNAME = "^\\S{5}\\S*$";
        while (true) {
            System.out.print("Enter username: ");            
            String username = s.nextLine().trim();
            //valid username
            if(username.matches(VALID_USERNAME)) return username;
            else System.out.println("You must enter least at 5 character, and no space!");
        }
    }
    
    String getPassword(){
        //valid password
        final String VALID_PASSWORD = "^\\S{6}\\S*$";
        while (true) {            
            System.out.print("Enter password: ");
            String password = s.nextLine().trim();
            //valid password
            if(password.matches(VALID_PASSWORD)) return password;
            else System.out.println("You must enter least at 6 character, and no space!");
        }
    }
}
