package matrixcalculator;

import java.util.Scanner;

public class GetInput {
    
    static Scanner s = new Scanner(System.in);
    
    public int getChoice(){
        //loop until user input a valid option
        while (true) {            
            try {
                //user choose an option
                int choice = Integer.parseInt(s.nextLine());
                //user choose out of range
                if(choice < 1 || choice > 4) throw new Exception();
                return choice;
            } catch (Exception e) {
                System.err.print("Please choose from 1 to 4. Re-input: ");
            }
        }
    }
       
    public int getMatrixSize(){
        //loop until user input a valid size
        while (true) {            
            try {
                //user input size
                int size = Integer.parseInt(s.nextLine());
                //invalid size
                if(size <= 0) throw new Exception();
                return size;
            } catch (Exception e) {
                System.err.print("Please input a positive integer. Re-input: ");
            }
        }
    }
    
    public int getMatrixElement(int row, int col, int matrix_n){
        //loop until user input a digit
        while (true) {            
            try {
                //user input a digit
                System.out.print("Enter Matrix" + matrix_n + "[" + row + "]" + "[" + col + "]:");
                int element = Integer.parseInt(s.nextLine());
                return element;
            } catch (NumberFormatException e) {
                System.out.println("Value of matrix is digit");
            }
        }
    }
}
