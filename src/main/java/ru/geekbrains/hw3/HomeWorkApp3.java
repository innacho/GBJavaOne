package ru.geekbrains.hw3;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp3 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


// 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
// С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] intArr = {1,0,1,1,0,0,0,1,1,0};
        System.out.println("Initial array:  "+ Arrays.toString(intArr));
        for (int i=0; i < intArr.length; i++){
            int reversed = (intArr[i] == 0) ? 1 : 0;
            intArr[i] = reversed;
        }
        System.out.println("Reversed array: "+ Arrays.toString(intArr));
        System.out.println("*****************");

// 2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
        int arr[] = new int[100];
        for (int i=0; i < 100; i++){
            arr[i] = i+1;
        }
        System.out.println("Int array: "+ Arrays.toString(arr));
        System.out.println("*****************");

// 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] intArr2 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Initial array:    "+ Arrays.toString(intArr2));
        for (int i=0; i < intArr2.length; i++){
            if(intArr2[i]<6) intArr2[i]*=2;
        }
        System.out.println("Multiplied array: "+ Arrays.toString(intArr2));
        System.out.println("*****************");

// 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
// и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно).
// Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
        int n;
        n = getNumberFromScanner("Please, enter matrix size: ", 2, 20);
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if(i==j || i == n-j-1){
                    matrix[i][j]=1;
                } else {
                    matrix[i][j]=0;;
                }
            }
        }
        System.out.println("Matrix:");
        for (int i = 0; i < n; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println("*****************");

// 5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len,
// каждая ячейка которого равна initialValue;
        int len;
        int initialValue;
        len = getNumberFromScanner("Please, enter array's length: ", 1, 200);
        initialValue = getNumberFromScanner("Please, enter array's initial value: ", -100000, 100000);
        System.out.println("Method created array with length " + len + " and initial value " + initialValue);
        System.out.println(Arrays.toString(createArray(len, initialValue)));
        System.out.println("*****************");

// 6. * Задать одномерный массив и найти в нем минимальный и максимальный значения элементов;
        int length;
        length = getNumberFromScanner("Please, enter array's length: ", 1, 200);
        int intArr3[] = new int[length];
        Random rand = new Random();
        for(int i = 0; i < length; i++){
            intArr3[i] = rand.nextInt(100);
        }
        System.out.println("Random array: "+ Arrays.toString(intArr3));
        System.out.println("Max value in array is: " + findMax(intArr3));
        System.out.println("Min value in array is: " + findMin(intArr3));
        System.out.println("*****************");

// 7. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
// метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
// **Примеры:
// checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
// checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1
// checkBalance([1, 1, 1, 8, 1]) → false
// граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
        int[] intArr4 = {20, 2, 2, 2, 2, 2, 10};
        System.out.println("Array for checking balance: " + Arrays.toString(intArr4));
        if (checkBalance(intArr4)) {
            System.out.println("Array is balanced");
        } else {
            System.out.println("Array is not balanced");
        }

        sc.close();
    }

    private static int[] createArray (int len, int initialValue){
        int[] arr = new int[len];
        for (int i = 0; i < len; i++){
            arr[i] = initialValue;
        }
        return arr;
    }

    public static int getNumberFromScanner(String message, int min, int max){

        int number;
        do{
            System.out.println(message);
            number = sc.nextInt();
        } while (number < min || number > max);
        return number;
    }

    private static int findMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if (arr[i]>max) max = arr[i];
        }
        return max;
    }

    private static int findMin(int[] arr){
        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if (arr[i]<min) min = arr[i];
        }
        return min;
    }

    private static boolean checkBalance( int arr[]){
        for(int i = 1; i < arr.length; i++){
            int sumLeft = 0;
            for(int j = 0; j < i; j++){
                sumLeft+=arr[j];
            }
            int sumRight = 0;
            for(int j = i; j < arr.length; j++){
                sumRight+=arr[j];
            }
            if (sumLeft == sumRight) return true;
        }
        return false;
    }
}
