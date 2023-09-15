package utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

public class CustomDate {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static Date parseToDate(String dateStr) {
        java.util.Date date = null;
        try {
             date = sdf.parse(dateStr);
        } catch (ParseException e) {
            Logger.getLogger(CustomDate.class.getName()).log(java.util.logging.Level.SEVERE, null, "CustomDate:parseToDate -> " + e);
        }
        return new Date(date != null ? date.getTime() : 0);
    }

    public static String parseToString(Date dateStr) {
        return dateStr.toString();
    }
}
