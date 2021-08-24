package baseconvert;

import java.math.BigInteger;

public class Main {
    
    static GetInput g = new GetInput();
    static Converter c = new Converter();
    
    static void convertBinary(){
        System.out.println();
        System.out.println("===== Convert To =====");
        System.out.println("1. Decimal.");
        System.out.println("2. Hexadecimal.");
        System.out.print("Base number output: ");
        //user choose output base
        int baseOutput = g.getChoice(1, 2);
        //user input a binary number
        String inputBin = g.getBinary();
        switch(baseOutput){
            case 1: //convert to dec
                System.out.println("=>" + inputBin + "(BIN) = " + c.convertBinToDec(inputBin) + "(DEC)");
                System.out.println();
                break;
            case 2://convert to hex
                BigInteger dec = c.convertBinToDec(inputBin);
                System.out.println("=>" + inputBin + "(BIN) = " + c.convertDecToHex(dec) + "(HEX)");
                System.out.println();
                break;
                    
        }
    }
    
    static void convertDecimal(){
        System.out.println();
        System.out.println("===== Convert To =====");
        System.out.println("1. Binary.");
        System.out.println("2. Hexadecimal.");
        System.out.print("Base number output: ");
        //user choose output base
        int baseOutput = g.getChoice(1, 2);
        //user input a decimal number
        String inputDec = g.getDecimal();
        BigInteger dec = new BigInteger(inputDec);
        switch(baseOutput){
            case 1: //convert to bin
                String bin = c.convertDecToBin(dec);
                System.out.println("=>" + inputDec + "(DEC) = " + bin + "(BIN)");
                System.out.println();
                break;
            case 2://convert to hex
                String hex = c.convertDecToHex(dec);
                System.out.println("=>" + inputDec + "(DEC) = " + hex + "(HEX)");
                System.out.println();
                break;
                    
        }
    }
    
    static void convertHexadecimal(){
        System.out.println();
        System.out.println("===== Convert To =====");
        System.out.println("1. Binary.");
        System.out.println("2. Decimal.");
        System.out.print("Base number output: ");
        //user choose output base
        int baseOutput = g.getChoice(1, 2);
        String inputHex = g.getHexa();
        switch(baseOutput){
            case 1: //convert to bin
                BigInteger dec = c.convertHexToDec(inputHex);
                System.out.println("=>" + inputHex + "(HEX) = " + c.convertDecToBin(dec) + "(BIN)");
                System.out.println();
                break;
            case 2://convert to dec
                System.out.println("=>" + inputHex + "(HEX) = " + c.convertHexToDec(inputHex) + "(DEC)");
                System.out.println();
                break;
                    
        }
    }
    
    static void menu(){
        System.out.println("===== Base Converter =====");
        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Hexadecimal");
        System.out.println("4. Exit");
        System.out.print("Your Choice: ");
    }
    
    public static void main(String[] args) {
        //loop until user exit
        while (true) {            
            menu();
            //user choode input base
            int choice = g.getChoice(1, 4);
            switch (choice) { 
                case 1: //convert binary
                    convertBinary();
                    break;
                case 2: //convert decimal
                    convertDecimal();
                    break;
                case 3: //convert hexadecimal
                    convertHexadecimal();
                    break;
                case 4:
                    return;
            }
        }
    }
    
}
