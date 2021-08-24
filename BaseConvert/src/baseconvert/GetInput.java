package baseconvert;

import java.util.Scanner;

public class GetInput {
    
    Scanner s = new Scanner(System.in);
    
    public int getChoice(int min, int max){
        while (true) {            
            try {
                int choice = Integer.parseInt(s.nextLine());
                //user enter a valid option
                if(choice >= min && choice <= max) return choice;
                //user do not enter a valid option
                else throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.print("Please enter a number from " + min + " to " + max + ": ");
            }
        }
    }
    
    public String getBinary(){
        //binary pattern
        final String binaryPattern = "[0-1]*";
        System.out.print("Enter binary a number: ");
        //loop until user enter a binary
        while (true) {            
            String inputBinary = s.nextLine();          
            //user enter a binary number
            if(!inputBinary.isEmpty() && inputBinary.matches(binaryPattern)) 
                return inputBinary;
            //user do not enter or enter a non-binary number
            else System.out.print("Please enter a binary number: ");
        }
    }
    
    
    public String getHexa(){
        //hexa pattern
        final String hexaPattern = "[0-9A-F]*";
        System.out.print("Enter hexadecimal a number: ");
        //loop until user enter a hexa decimal
        while (true) {               
            String inputHexa = s.nextLine();
            //user enter a hexa decimal
            if(!inputHexa.isEmpty() && inputHexa.matches(hexaPattern))
                return inputHexa;
            //user do not enter or enter a non-binary number 
            else System.out.print("Please enter a hexadecimal: ");
        }
    }
    
    public String getDecimal(){
        //loop until user enter a decimal
        String pattern = "\\d+";
        System.out.print("Enter a decimal number: ");
        while (true) {            
            String input = s.nextLine();
            //user input character other than numbers or do not input
            if(!input.matches(pattern) || input.isEmpty()){
                System.out.print("Please input a decimal: ");
                continue;
            }
            return input;
        }
    }
}
