package com.iotek.util;

import java.sql.Timestamp;
import java.util.Date;

public class TimeUtil {
    public static Timestamp getTimestamp(){
        return new Timestamp(new Date().getTime());
    }
}