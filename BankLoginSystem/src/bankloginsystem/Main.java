package bankloginsystem;

import java.util.Hashtable;
import java.util.Locale;
import java.util.Random;

public class Main {
    
    static GetInput g = new GetInput();
    static GetWordLanguage gwl = new GetWordLanguage();
    
    static String generateCaptcha(){
        Random r = new Random();
        final char[] chars = {'1', 'A', 'a', 'B', 'b', 'C',
        'c', '2', 'D', 'd', 'E', 'e', 'F', 'f', '3', 'G', 'g', 'H', 'h',
        'I', 'i', 'J', 'j', 'K', 'k', 'L', 'l', '4', 'M', 'm', 'N', 'n',
        'O', 'o', '5', 'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't',
        '6', '7', 'U', 'u', 'V', 'v', 'U', 'u', 'W', 'w', '8', 'X', 'x',
        'Y', 'y', 'Z', 'z', '9'};
        final int LENGTH = 6;
        StringBuilder sb = new StringBuilder();
        //create 6 random character for the captcha
        for (int i = 0; i < LENGTH; i++) {
            //pick a random character in chars array
            int index = r.nextInt(chars.length);
            sb.append(chars[index]);
        }
        return sb.toString();
    }
    
    static void login(Locale language){
        Hashtable<String, String> accounts = new Hashtable<>();
        accounts.put("1234567890", "abcd1234");
        accounts.put("0123456789", "abcd1234");
        String account = g.getInputAccount(language);
        String password = g.getInputPassword(language);
        while (true) { 
            //generate captcha
            String captcha = generateCaptcha();
            System.out.println("Captcha: " + captcha);
            //user enter right captcha
            if(g.getInputCaptcha(captcha, language)){
                //password matches with existed account
                if(password.equals(accounts.get(account))){
                    System.out.println(gwl.getWordLanguage(language, "loginSuccess"));
                    break;
                } else {
                    System.out.println(gwl.getWordLanguage(language, "loginFail"));
                    break;
                }
            } else {
                System.out.println(gwl.getWordLanguage(language, "errCaptchaIncorrect"));
            }
        }
    }
    
    static void menu(){
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
    }
    
    static void display(){
        Locale vietnamese = new Locale("vi", "VI");
        Locale english = Locale.ENGLISH;
        menu();
        int choice = g.getChoice(1, 3, english);
        switch(choice){
            case 1:
                login(vietnamese);
                break;
            case 2: 
                login(english);
                break;
            case 3:
                return;
        }
    }

    public static void main(String[] args) {
        display();
    }
    
}
