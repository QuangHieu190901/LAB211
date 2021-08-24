package bankloginsystem;

import java.util.Locale;
import java.util.Scanner;

public class GetInput {
    
    static Scanner s = new Scanner(System.in);
    static GetWordLanguage gwl = new GetWordLanguage();
    
    int getChoice(int min, int max, Locale language){
        while (true) {            
            try {
                int input = Integer.parseInt(s.nextLine());
                //out of range choice
                if(input < min || input > max) throw new NumberFormatException();
                else return input;
            } catch (NumberFormatException e) {
                System.out.print(gwl.getWordLanguage(language, "errorCheckInputIntLimit"));                
            }
        }
    }
    
    String getInputAccount(Locale language){
        //valid account
        String ACCOUNT_NUMBER_VALID = "^\\d{10}$";
        while (true) {
            System.out.print(gwl.getWordLanguage(language, "enterAccountNumber"));            
            String account = s.nextLine();
            if(account.matches(ACCOUNT_NUMBER_VALID)) return account;
            System.out.println(gwl.getWordLanguage(language, "errCheckInputAccount"));
        }
    }
    
    boolean isValidPassword(String password, Locale language){
        int passwordLength = password.length();
        //invalid length
        if(passwordLength < 8 || passwordLength > 31){
            System.out.println(gwl.getWordLanguage(language, "errCheckPassword"));
            return false;
        }
        //valid length
        else {
            int countDigit = 0;
            int countLetter = 0;
            //iterate over string password
            for (int i = 0; i < passwordLength - 1; i++) {
                //count digit
                if(Character.isDigit(password.charAt(i))) countDigit++;
                //count character
                if(Character.isAlphabetic(password.charAt(i))) countLetter++;
            }
            //password does not contain any digit or character
            if(countDigit < 1 || countLetter < 1){
                System.out.println(gwl.getWordLanguage(language, "errCheckPassword"));
                return false;
            }            
        }
        return true;
    }
    
    String getInputPassword(Locale language){
        while (true) {
            System.out.print(gwl.getWordLanguage(language, "enterPassword"));
            String password = s.nextLine();
            if(isValidPassword(password, language)) return password;
        }
    }
    
    boolean getInputCaptcha(String captcha, Locale language){
        while (true) {            
            System.out.print(gwl.getWordLanguage(language, "enterCaptcha"));
            String inputCaptcha = s.nextLine();
            return inputCaptcha.equals(captcha);
        }
    }
    
}
