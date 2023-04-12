package org.bonn.ooka.buchungssystem.ss2022;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logging {
    private static List<String> logData;

    public Logging() {
        logData = new ArrayList<>();
    }

    public static void logData(String name){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm");
        String formattedNow = now.format(formatter);
        String logMessage = String.format("%s: Zugriff auf Buchungssystem über Methode %s. Suchwort: %s", formattedNow, "getHotelByName", name);
        System.out.println(logMessage);
        logData.add(logMessage);
    }

    public List<String> getLogData() {
        return logData;
    }

}
