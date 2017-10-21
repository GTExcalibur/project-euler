package net.gtexcalibur.projecteuler;

import java.time.*;
import java.time.temporal.ChronoField;

/**
 * Created by George Turner on 10/20/2017.
 * <br> Problem 19 - Counting Sundays
 * <pre>
 *

 You are given the following information, but you may prefer to do some research for yourself.

     1 Jan 1900 was a Monday.
     Thirty days has September,
     April, June and November.
     All the rest have thirty-one,
     Saving February alone,
     Which has twenty-eight, rain or shine.
     And on leap years, twenty-nine.
     A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

 How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

 * </pre>
 */
public class Problem_019 {

    public static void main(String[] args) {
        Instant start = Instant.parse("1901-01-01T01:00:00Z");
        Instant end = Instant.parse("2000-12-31T01:00:00Z");
        Duration shift = Duration.ofDays(1);

        long count = 0;

        Instant local = start;

        while(local.isBefore(end)) {
            LocalDateTime localDateTime = LocalDateTime.ofInstant(local, ZoneId.systemDefault());

            if(
                    localDateTime.getDayOfMonth() == 1 &&
                    localDateTime.getDayOfWeek() == DayOfWeek.SUNDAY
            ) {
                count++;
            }

            local = local.plus(shift);
        }

        System.out.println(count);
    }
}
