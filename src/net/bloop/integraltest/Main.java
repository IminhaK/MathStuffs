package net.bloop.integraltest;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /*
    GOAL: Find the combination of three numbers that is closest to 100 in the form
    integral from a to b of x^c where a b and c are numbers 1-9 and do not repeat
    single digits only. (no 83, 8.3, 8/3, etc)

    ADDITION: allow a and b to be any numbers, skip times when b < a
    NOTE: if lower limit is 1 any value for max above 14 will return a = 5, b=15, c=1 which is exactly 100
     */

    private static ArrayList<NumberGroup> values = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter the lower limit: ");
        int MIN = scanner.nextInt();

        System.out.print("Enter the upper limit: ");
        int MAX = scanner.nextInt();

        //try each number as a
        for(int a = MIN; a <= MAX; a++)
        {
            //try each remaining number as b
            for(int b = MIN; b <= MAX; b++)
            {
                if(b == a || b < a)
                    continue;

                //try each remaining number as c
                for(int c = MIN; c <= MAX; c++)
                {
                    if(c == b)
                        continue;

                    double value = Math.pow(b, c+1)/(c+1) - Math.pow(a, c+1)/(c+1);
                    System.out.println("a=" + a +" b=" + b + " c=" + c + " ");
                    System.out.println(value);
                    values.add(new NumberGroup(a, b, c, value));
                }
            }
        }

        //Best is last
        values.sort((n1, n2) -> (int)(n2.getHealth() - n1.getHealth()));

        NumberGroup best = values.get(values.size() - 1);
        System.out.println("Closest value:");
        System.out.println("A = " + best.getA());
        System.out.println("B = " + best.getB());
        System.out.println("C = " + best.getC());
        System.out.println("Value = " + best.getValue());
    }
}
