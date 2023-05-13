package com.metattri.java;

public class WeekDayConverter {
    String[] weekDay = new String[7];
    int day;
    String suffix;

    public WeekDayConverter(int dayofWeek) {
        this.weekDay[0] = "Monday";
        this.weekDay[1] = "Tuesday";
        this.weekDay[2] = "Wednesday";
        this.weekDay[3] = "Thursday";
        this.weekDay[4] = "Friday";
        this.weekDay[5] = "Saturday";
        this.weekDay[6] = "Sunday";

        this.day = dayofWeek;
        if (day == 1) {
            this.suffix = "st";
        } else if (day == 2) {
            this.suffix = "nd";
        } else if (day == 3) {
            this.suffix = "rd";
        } else {
            this.suffix = "th";
        }
    }

    public static void main(String[] args) {
        WeekDayConverter myWeekDy = new WeekDayConverter(Integer.parseInt(args[0]));
        myWeekDy.conver();
    }

    public void conver() {
        System.out.printf("The %d%s day of the week is %s.", day, suffix, weekDay[day - 1]);
    }
}