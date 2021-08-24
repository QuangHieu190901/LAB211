package dayofdate;

import java.text.*;
import java.util.Date;

public class DayOfDate {
    
    //format day of the week of the date in full name
    DateFormat df = new SimpleDateFormat("EEEE");

    String determineDayOfDate(Date date){
        //day of the date of the week
        return df.format(date);
    }
    
}
