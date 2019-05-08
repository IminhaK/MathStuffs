package net.bloop.integraltest;

import java.util.ArrayList;

public class Main {

    /*
    GOAL: Find the combination of three numbers that is closest to 100 in the form
    integral from a to b of x^c where a b and c are numbers 1-9 and do not repeat
    single digits only. (no 83, 8.3, 8/3, etc)
     */

    private static ArrayList<NumberGroup> values = new ArrayList<NumberGroup>();

    public static void main(String[] args) {

        //try each number as a
        for(int a = 1; a <= 9; a++)
        {
            //try each remaining number as b
            for(int b = 1; b <= 9; b++)
            {
                if(b == a)
                    continue;

                //try each remaining number as c
                for(int c = 1; c <= 9; c++)
                {
                    if(c == b || c == a)
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
