package ru.geekbrains.hw2;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        int a = -20;
        int b = 10;
        boolean result;

        result = checkSum(a,b);
        if (result){
            System.out.println("The result of sum " + a + "+" + b + " is within [10,20]");
        } else {
            System.out.println("The result of sum " + a + "+" + b + " isn't within [10,20]");
        }
        System.out.println("*************");

        isPositive(a);
        System.out.println("*************");

        result = isNegative(a);
        if (result){
            System.out.println("The number " + a + " is negative");
        } else {
            System.out.println("The number " + a + " is positive");
        }
        System.out.println("*************");

        int count = 4;
        String str = "String for printing";
        printMultipleStrings(count, str);
        System.out.println("*************");

        int year = 2000;
        result = isLeapYear(year);
        String message;
        message = result ? "is a leap year" : "is not a leap year";
        System.out.printf("%d %s", year, message);
    }

    private static boolean checkSum (int a, int b){
        return (a + b >=10) && (a + b <=20);
    }

    private static void isPositive(int a){
        String message;
        message = (a>=0) ? a + " is positive" : a + " is negative";
        System.out.println(message);
    }

    private static boolean isNegative (int a){
        return (a < 0);
    }

    private static void printMultipleStrings (int count, String str) {
        for (int i = 1; i <= count; i++){
            System.out.println("String # "+ i + ": " + str);
        }
    }

    private static boolean isLeapYear(int year){
        return (year%4==0) && (year%100!=0) || (year%400==0);
    }
}
