package net.bloop.concatinationtest;

public class Concatenation {

    static int concat(int first, int second)
    {
        String firstS = Integer.toString(first);
        String secondS = Integer.toString(second);
        String concat = firstS + secondS;
        long finish = Long.parseLong(concat);

        return finish >= Integer.MAX_VALUE ? 0 : (int)finish;
    }
}
