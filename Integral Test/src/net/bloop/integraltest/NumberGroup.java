package net.bloop.integraltest;

public class NumberGroup {

    private int a;
    private int b;
    private int c;
    private double value;

    public NumberGroup (int a, int b, int c, double value)
    {
        this.a=a;
        this.b=b;
        this.c=c;
        this.value=value;
    }

    public int getA()
    {
        return a;
    }

    public int getB()
    {
        return b;
    }

    public int getC()
    {
        return c;
    }

    public double getValue()
    {
        return value;
    }

    public double getHealth()
    {
        return Math.abs(100 - value);
    }
}
