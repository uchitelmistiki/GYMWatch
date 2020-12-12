package ru.um.gymwatch.utils;

import java.io.UnsupportedEncodingException;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class DayOfWeekGetter {
    private static String getNameOfDayOfWeek(DayOfWeek dow) {
        String nameOfDayOfWeek = "";
        try {
            nameOfDayOfWeek = new String(dow.getDisplayName(TextStyle.FULL, new Locale("ru", "RU")).getBytes("UTF-8"), "Cp1251");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return nameOfDayOfWeek;
    }

    public static List<String> getDaysOfWeek() {
        return Arrays.stream(DayOfWeek.values()).map(DayOfWeekGetter::getNameOfDayOfWeek).collect(Collectors.toList());
    }
}