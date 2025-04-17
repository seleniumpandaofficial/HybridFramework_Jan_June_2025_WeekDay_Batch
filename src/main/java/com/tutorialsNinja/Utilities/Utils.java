package com.tutorialsNinja.Utilities;

import java.util.Date;

public class Utils {

    public static final int IMPLICIT_WAIT = 10;
    public static final int PAGELOADTIMEOUT_WAIT = 20;
    public static final int SCRIPTTIMEOUT_WAIT = 120;


    public static String emailWithDateTimeStamp(){
        Date date = new Date();
        String emailTimeStamp = date.toString().replace(" ", "_").replace(":", "_");
        return "seleniumpanda" + emailTimeStamp + "@gmail.com";
    }
}
