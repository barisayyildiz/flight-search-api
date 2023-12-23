package com.amadeus.flightsearch.utils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static long getEpochDateMillisecond(String isoDate) {
        ZonedDateTime startTime = ZonedDateTime.parse(isoDate);
        return startTime.toInstant().toEpochMilli();
    }

    public static String getIsoDateTime(long epochMilli) {
        Instant instant = Instant.ofEpochMilli(epochMilli);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        return zonedDateTime.format(formatter);
    }
}
