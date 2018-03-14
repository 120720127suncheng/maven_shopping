package com.iotek.util;

/**
 * com.iotek.util
 *
 * @author <Author Administrator>
 * @date 2018/3/14 10:37
 */
public class Validate {
    public static void throwNull(String message){
        throw new NullPointerException(message);
    }
}