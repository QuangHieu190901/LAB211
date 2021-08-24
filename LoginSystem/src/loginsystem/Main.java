package loginsystem;

import java.io.*;

public class Main {
    
    static GetInput g = new GetInput();
    
    public static boolean checkExistedDataFile(){
        File file = new File("user.dat");
        //data file not exist
        if(!file.exists()){
            try {
                System.out.println("Data file not exist.");
                file.createNewFile();
                System.out.println("Data file is created.");
                System.out.println();
                return false;
            } catch (IOException e) {
                
            }
        }
        return true;
    }
    
    public static boolean checkExistedUser(String username){
        File file = new File("user.dat");
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            //read every account until find the existed account
            while ((line = br.readLine()) != null) {                
                String[] account = line.split(";");
                //found existed user
                if(username.equals(account[0])) return true;
            }
            br.close();
            fr.close();
            return false;
        } catch (IOException e) {
            
        } 
        return false;
    }
    
    public static void addAccountData(String username, String password){
        File file = new File("user.dat");
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write(username + ";" + password + "\n");
            fw.close();
            System.out.println("Create sucessfully");
            System.out.println();
        } catch (IOException e) {
        }
    }
    
    public static void addAccount(){
        //file not exist
        if(!checkExistedDataFile()) return;
        //add user
        while (true) {
            String username = g.getUsername();
            //user name existed
            if (checkExistedUser(username)) {
                System.out.println("User is existed.");
            } else {
                String password = g.getPassword();
                addAccountData(username, password);
                return;
            }
        }
    }
    
    public static String getPasswordByUsername(String username){
        try {
            FileReader fr = new FileReader("user.dat");
            BufferedReader br = new BufferedReader(fr);
            String line;
            //read every account unitl find the username
            while ((line = br.readLine()) != null) {                
                String[] account = line.split(";");
                //account is found 
                if(username.equals(account[0])) return account[1];
            }
        } catch (IOException e) {
            
        }
        return null;
    }
    
    public static void login(){
        //data file not found
        if(!checkExistedDataFile()) return;
        //loop until user enter correct username and password
        while (true) {            
            String username = g.getUsername();
            //username exist
            if (checkExistedUser(username)) {
                //loop until user enter a correct password
                while (true) {
                    String password = g.getPassword();
                    //incorrect password
                    if (!password.equals(getPasswordByUsername(username))) {
                        System.out.println("Wrong password. Please re-input.");
                    } else {
                        System.out.println("Login successfully");
                        System.out.println();
                        return;
                    }
                }
            } else System.out.println("Username not existed. Please re-input.");
        }
       
    }
    
    public static void menu(){
        System.out.println("1. Create a new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
        System.out.print("> Choose: ");
    }

    public static void main(String[] args) {
        while (true) {            
            menu();
            int choice = g.getChoice(1, 3);
            switch(choice){
                case 1:
                    addAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3: 
                    return;
            }
        }
    }
    
}
