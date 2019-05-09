package net.bloop.concatinationtest;

import java.util.Scanner;

public class Main {


    /*
    GOAL: Take an input of two numbers and combine them into a single number
     */
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter the first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int second = scanner.nextInt();

        System.out.println("Combined number: " + Concatenation.concat(first, second));
    }
}
