package com.wipro.datetime;

import java.time.LocalDate;

public class DatesDifference {
    public static void getDateDiff(LocalDate dt1, LocalDate dt2) {
        if (dt1.isAfter(dt2)) {
            LocalDate temp = dt1;
            dt1 = dt2;
            dt2 = temp;
        }

        int years = dt2.getYear() - dt1.getYear();
        int months = dt2.getMonthValue() - dt1.getMonthValue();
        int days = dt2.getDayOfMonth() - dt1.getDayOfMonth();

        if (days < 0) {
            months -= 1;
            days += dt1.plusMonths(months + 1).lengthOfMonth();
        }

        if (months < 0) {
            years -= 1;
            months += 12;
        }

        System.out.println("Difference is: " + years + " years " + months + " months and " + days + " days.");
    }

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2024, 12, 28);
        LocalDate date2 = LocalDate.of(2025, 1, 6);

        getDateDiff(date1, date2);
    }
}
