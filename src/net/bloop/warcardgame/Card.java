package net.bloop.warcardgame;

public class Card {

    public int ACE = 0;
    public int TWO = 1;
    public int THREE = 2;
    public int FOUR = 3;
    public int FIVE = 4;
    public int SIX = 5;
    public int SEVEN = 6;
    public int EIGHT = 7;
    public int NINE = 8;
    public int TEN = 9;
    public int JACK = 10;
    public int QUEEN = 11;
    public int KING = 12;

    public int HEART = 0;
    public int DIAMOND = 1;
    public int CLOVER = 2;
    public int SPADE = 3;

    private int type;
    private int suit;

    public Card(int type, int suit)
    {
        this.type = type;
        this.suit = suit;
    }

    public int getType()
    {
        return type;
    }

    public int getSuit()
    {
        return suit;
    }
}
