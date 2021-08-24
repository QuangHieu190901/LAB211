package matrixcalculator;

public class Main {

    static Matrix m = new Matrix();
    static Calculator mc = new Calculator();
    static GetInput g = new GetInput();

    static void menu(){
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition matrix");
        System.out.println("2. Subtraction matrix");
        System.out.println("3. Multiplication matrix");
        System.out.println("4. Quit");
        System.out.print("Your choice: ");
    }
    
    static void addMatrices(){
        int[][] matrix1;
        int[][] matrix2;
        System.out.println("------ Addition ------");
        //user input first matrix
        matrix1 = m.getMatrix(1);
        //user input second matrix
        matrix2 = m.getMatrix(2);
        //2 matrices aren't addable
        if (mc.additionMatrix(matrix1, matrix2) == null) {
            System.out.println("2 matrices can not be added.");
            System.out.println("");
        } //2 matrices are addable
        else {
            System.out.println("-------- Result --------");
            m.printMatrix(matrix1);
            System.out.println("+");
            m.printMatrix(matrix2);
            System.out.println("=");
            m.printMatrix(mc.additionMatrix(matrix1, matrix2));
            System.out.println("");
        }
    }
    
    static void subtractMatrices(){
        int[][] matrix1;
        int[][] matrix2;
        System.out.println("------ Subtraction ------");
        //user input first matrix
        matrix1 = m.getMatrix(1);
        //user input second matrix
        matrix2 = m.getMatrix(2);
        //2 matrices aren't subtractable
        if (mc.subtractionMatrix(matrix1, matrix2) == null) {
            System.out.println("2 matrices can not be subtracted.");
            System.out.println("");
        } //2 matrices are subtractable
        else {
            System.out.println("-------- Result --------");
            m.printMatrix(matrix1);
            System.out.println("-");
            m.printMatrix(matrix2);
            System.out.println("=");
            m.printMatrix(mc.subtractionMatrix(matrix1, matrix2));
            System.out.println("");
        }
    }
    
    static void multiplyMatrices(){
        int[][] matrix1;
        int[][] matrix2;
        System.out.println("------ Multiplication ------");
        //user input first matrix
        matrix1 = m.getMatrix(1);
        //user input second matrix
        matrix2 = m.getMatrix(2);
        //2 matrices aren't able to multiply
        if (mc.multiplicationMatrix(matrix1, matrix2) == null) {
            System.out.println("2 matrices can not be multiplied.");
            System.out.println("");
        } //2 matrices are able to multiply
        else {
            System.out.println("-------- Result --------");
            m.printMatrix(matrix1);
            System.out.println("*");
            m.printMatrix(matrix2);
            System.out.println("=");
            m.printMatrix(mc.multiplicationMatrix(matrix1, matrix2));
            System.out.println("");
        }
    }
    
    static void display() {
        //loop until user quit program
        while (true) {
            menu();
            //user input a choice
            int choice = g.getChoice();
            switch (choice) {
                //Addition matrices
                case 1:
                    //add and display result
                    addMatrices();
                    break;
                //Subtraction matrices
                case 2:
                    //subtract and display result
                    subtractMatrices();
                    break;
                //Multiplication matrices
                case 3:
                    //multiply and display result
                    multiplyMatrices();
                    break;
                //Exit program
                case 4:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        display();
    }

}
