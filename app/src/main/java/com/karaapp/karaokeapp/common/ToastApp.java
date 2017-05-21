package com.karaapp.karaokeapp.common;

import android.content.Context;
import android.widget.Toast;

import com.karaapp.karaokeapp.data.Config;

/**
 * Created by Nganq on 4/24/2017.
 */

public class ToastApp{
    public static void makeShort(Context context, String mess){
        if(Config.FLAG_DEBUG){
            StackTraceElement stackTraceElement = (new Throwable()).getStackTrace()[1];
            String text = stackTraceElement.getFileName() + "in" + stackTraceElement.getMethodName() +"at line" + stackTraceElement.getLineNumber() + ":" + mess;
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
        }
    }

    public static void makeLong(Context context, String mess) {
        if(Config.FLAG_DEBUG){
            StackTraceElement stackTraceElement = (new Throwable()).getStackTrace()[1];
            String text = stackTraceElement.getFileName() + " in " + stackTraceElement.getMethodName() + " at line: " + stackTraceElement.getLineNumber() + ": " + mess;
            Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        }
    }

    public static void makeTextShort(Context context, String mess) {
        Toast.makeText(context, mess, Toast.LENGTH_SHORT).show();
    }

    public static void makeTextLong(Context context, String mess) {
        Toast.makeText(context, mess, Toast.LENGTH_LONG).show();
    }
}