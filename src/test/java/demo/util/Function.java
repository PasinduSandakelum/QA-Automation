package demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Function {


  public static String getTimeStamp(String dateFormat) {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
    String date = simpleDateFormat.format(new Date());
    return date;

  }

}
