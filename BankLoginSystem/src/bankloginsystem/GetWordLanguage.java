package bankloginsystem;

import java.util.*;

public class GetWordLanguage {
    
    String getWordLanguage(Locale l, String message){
        ResourceBundle rb = ResourceBundle.getBundle("Language/lang", l);
        return rb.getString(message);
    }
    
}
