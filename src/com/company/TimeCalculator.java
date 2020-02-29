package com.company;

import javax.swing.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class TimeCalculator {

    public TimeCalculator(){
        run();
    }
    private void run(){
        daysSinceIWereBorn();
        skypeMeeting();
        fridayTheThirteenth();
        toiletTime();
        finalOneAndTwo();
        finalThree();
    }
    private void daysSinceIWereBorn(){
        LocalDate myBirthDay = LocalDate.of(1995, 12, 15);
        LocalDate today = LocalDate.now();
        int daysSinceIWereBorn = (int) ChronoUnit.DAYS.between(myBirthDay, today);
        System.out.println(daysSinceIWereBorn + " days since I were born");
    }
    private void skypeMeeting(){
        String dateFormat = "yyyy-MM-dd h:mm a";
        String newYorkTime = "2020-04-15 4:30 PM";

        LocalDateTime stockholm = LocalDateTime.parse(newYorkTime, DateTimeFormatter.ofPattern(dateFormat, Locale.US));
        ZoneId stockHolmZoneId = ZoneId.of("Europe/Stockholm");
        ZonedDateTime stockHolmTime = stockholm.atZone(stockHolmZoneId);

        ZoneId newYorkZoneId = ZoneId.of("America/New_York");
        ZonedDateTime newYorkDateTime = stockHolmTime.withZoneSameInstant(newYorkZoneId);

        System.out.println("Time for meeting in New York-time: " + newYorkDateTime);
        System.out.println("Time for meeting in Stockholm: " + stockHolmTime);
    }
    private void fridayTheThirteenth(){
        LocalDate startDate = LocalDate.of(1900, 1, 1);
        LocalDate endDate = LocalDate.now();
        int fridayCounter = 0;
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1)){
            if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)){
                if (date.getDayOfMonth() == 13){
                fridayCounter++;
            }
            }
        }
        System.out.println("Number of fridays the 13:th: " + fridayCounter);
    }
    private void toiletTime(){
        double first = 14.5 * 60;
        int second = 27 * 60;
        LocalDate myBirthday = LocalDate.of(1995, 12, 15);
        LocalDate my80thBirthday = LocalDate.of(2075, 12, 15);
        LocalDate smartPhonesTookOverOurLives = LocalDate.of(2018, 1,1);

        long daysBeforeSmartPhones = ChronoUnit.DAYS.between(myBirthday, smartPhonesTookOverOurLives);
        long beforeSmartPhones = (long) (daysBeforeSmartPhones * first);
        long daysAfterSmartPhones = ChronoUnit.DAYS.between(smartPhonesTookOverOurLives, my80thBirthday);
        long afterSmartPhones = daysAfterSmartPhones * second;
        long totalToiletTime = beforeSmartPhones + afterSmartPhones;
        long daysOnToilet = totalToiletTime / 60 / 60 / 24;
        System.out.println(daysOnToilet + " days on the toilet");
    }
    private void finalOneAndTwo(){
        Duration life = Duration.ofMinutes(80 * (365 * 24 * 60));
        Duration sleep = Duration.ofMinutes(8 * 60 * (365 * 80));
        Duration work = Duration.ofMinutes(9 * 60 * (365 * 65));
        Duration toiletBeforePension = Duration.ofMinutes((long) ((365 * 65 * 24 * 60) * 0.02));
        Duration hygieneBeforePension = Duration.ofMinutes((65 * 365) * 30);
        Duration houseHoldBeforePension = Duration.ofMinutes((65 * 365) * 60);
        Duration eatingBeforePension = Duration.ofMinutes((65 * 365) * 30);
        Duration totalBeforePension = work.plus(toiletBeforePension).plus(hygieneBeforePension).
                plus(houseHoldBeforePension).plus(eatingBeforePension);

        Duration toiletAfterPension = Duration.ofMinutes((long) ((365 * 15 * 24 * 60) * 0.04));
        Duration hygieneAfterPension = Duration.ofMinutes((15 * 365) * 60);
        Duration houseHoldAfterPension = Duration.ofMinutes((15 * 365) * 120);
        Duration eatingAfterPension = Duration.ofMinutes((15 * 365) * 60);
        Duration totalAfterPension = toiletAfterPension.plus(hygieneAfterPension).plus(houseHoldAfterPension)
                .plus(eatingAfterPension);

        Duration freeTime = life.minus(sleep).minus(totalBeforePension).minus(totalAfterPension);
        float lifeLeftInPercentage = (float) freeTime.toMinutes() / life.toMinutes() * 100;
        System.out.println("Freetime left in percentage: " + lifeLeftInPercentage + "%");

        Duration lifeLeftInHours = life.minus(sleep).minus(totalBeforePension).minus(totalAfterPension);
        System.out.println("Freetime left in hours: " + lifeLeftInHours.toHours());
    }
    private void finalThree(){
        Duration life = Duration.ofMinutes(80 * (365 * 24 * 60));
        Duration sleep = Duration.ofMinutes(8 * 60 * (365 * 80));
        Duration phone = Duration.ofMinutes(3 * 60 * (365 * 80));
        Duration work = Duration.ofMinutes(9 * 60 * (365 * 65));

        Duration toiletBeforePension = Duration.ofMinutes((long) ((365 * 65 * 24 * 60) * 0.02));
        Duration hygieneBeforePension = Duration.ofMinutes((65 * 365) * 30);
        Duration houseHoldBeforePension = Duration.ofMinutes((65 * 365) * 60);
        Duration eatingBeforePension = Duration.ofMinutes((65 * 365) * 30);
        Duration totalBeforePension = work.plus(toiletBeforePension).plus(hygieneBeforePension).
                plus(houseHoldBeforePension).plus(eatingBeforePension);

        Duration toiletAfterPension = Duration.ofMinutes((long) ((365 * 15 * 24 * 60) * 0.04));
        Duration hygieneAfterPension = Duration.ofMinutes((15 * 365) * 60);
        Duration houseHoldAfterPension = Duration.ofMinutes((15 * 365) * 120);
        Duration eatingAfterPension = Duration.ofMinutes((15 * 365) * 60);
        Duration totalAfterPension = toiletAfterPension.plus(hygieneAfterPension).plus(houseHoldAfterPension)
                .plus(eatingAfterPension);

        Duration lifeLeftInHours = life.minus(sleep).minus(phone).minus(totalBeforePension).minus(totalAfterPension);
        System.out.println("Freetime left in hours (with smartphones involved): " + lifeLeftInHours.toHours());
    }
}
