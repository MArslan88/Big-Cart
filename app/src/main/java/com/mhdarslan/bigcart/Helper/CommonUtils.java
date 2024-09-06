package com.mhdarslan.bigcart.Helper;

import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CommonUtils {
    public static String getDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }

    public static String getTodayTime() {
        DateFormat df = new SimpleDateFormat("hh:mm a");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }

    public static String padRight(String text, int totalWidth) {
        return String.format("%-" + totalWidth + "s", text);
    }


    public static String padLeft(String text, int totalWidth) {
        return String.format("%" + totalWidth + "s", text);
    }



    public static String getTodayDate() {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }


    public static String getDateToday() {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss aaa");
        String date = df.format(Calendar.getInstance().getTime());
        return date;
    }
    public static String repeat(String text, int length) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(text);
        }
        return sb.toString();
    }

    public static String getCurrentDay(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.getDefault());
        String currentDay = dayFormat.format(calendar.getTime());
        return  currentDay.toLowerCase(Locale.ROOT);
    }

    public static String getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        String currentTime = timeFormat.format(calendar.getTime());
        return currentTime;
    }

    public static String formatDecimal(double value){
        return String.format("%.2f", value);
    }

    public static void splitPrice(double price, TextView intPrice, TextView decPrice) {
        String originalPrice = formatDecimal(price);
        // Split the text into integer and decimal parts
        String[] parts = originalPrice.split("\\.");
        String integerPart = parts[0];
        String decimalPart = parts[1];
        intPrice.setText(integerPart);
        decPrice.setText("."+decimalPart);
    }

    public static boolean createCustomFolder(File file) {
        if (file.isDirectory()) {
            Log.d("Folder Work:", "Path already created");
            return true;
        } else {
            Log.d("Folder Work:", "Path is creating");
            if (file.mkdirs()) {
                Log.d("Folder Work:", "Path created successfully");
                return true;
            } else {
                Log.d("Folder Work:", "Failed to create path");
                return false;
            }
        }
    }

    public static void deleteCorruptedVideo(File file, String videoId) {
        String[] children = file.list();
        for (int i = 0; i < children.length; i++) {
            if (children[i].contains(videoId)) {
                new File(file, children[i]).delete();
            }
        }
    }
}
