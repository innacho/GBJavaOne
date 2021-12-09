package ru.geekbrains.hw2;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        int a = -20;
        int b = 10;
        boolean result = checkSum(a,b);
        if (result){
            System.out.println("The result of sum is within [10,20]");
        } else {
            System.out.println("The result of sum isn't within [10,20]");
        }

        isPositive(a);

        result = isNegative(a);
        if (result){
            System.out.println("The number is negative");
        } else {
            System.out.println("The number is positive");
        }

        int count = 5;
        String str = "String for printing";
        printMultipleStrings(count, str);

        int year = 2000;
        result = isLeapYear(year);
        String message = result ? "is a leap year" : "is not a leap year";
        System.out.printf("%d %s", year, message);
    }

    private static boolean checkSum (int a, int b){
        int sum;
        sum = a + b;
        return (sum>=10 && sum<=20) ? true : false;
    }

    private static void isPositive(int a){
        String message = (a>=0) ? "Number is positive" : "Number is negative";
        System.out.println(message);
    }

    private static boolean isNegative (int a){
        return (a < 0) ? true : false;
    }

    private static void printMultipleStrings (int count, String str) {
        if(count <= 0) {
            System.out.println("Wrong count value in printMultipleStrings");
            return;
        }
        for (int i = 0; i < count; i++){
            System.out.println(str);
        }
    }

    private static boolean isLeapYear(int year){
        if(year%4==0 || (year%400==0 && year%100!=0)) return true;
        return false;
    }
}
