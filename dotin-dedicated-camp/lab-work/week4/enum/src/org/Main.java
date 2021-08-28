package org;

import java.util.Scanner;

enum WeekDays {
    SATURDAY(0), SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4),
    THURSDAY(5), FRIDAY(6);
    public final int count;

    WeekDays(int count) {
        this.count = count;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        switch (in) {
            case 0:
                System.out.println(WeekDays.SATURDAY);
                break;
            case 1:
                System.out.println(WeekDays.SUNDAY);
                break;
            case 2:
                System.out.println(WeekDays.MONDAY);
                break;
            case 3:
                System.out.println(WeekDays.TUESDAY);
                break;
            case 4:
                System.out.println(WeekDays.WEDNESDAY);
                break;
            case 5:
                System.out.println(WeekDays.THURSDAY);
                break;
            case 6:
                System.out.println(WeekDays.FRIDAY);
                break;

            default:
                System.out.println("error");
        }
    }
}
