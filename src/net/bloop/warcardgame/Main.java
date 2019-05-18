package net.bloop.warcardgame;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    /*
    GOAL: Replicate War the card game between two computer players
     */

    private static ArrayList<Card> cards = new ArrayList<>();
    private static ArrayList<Card> deck1 = new ArrayList<>();
    private static ArrayList<Card> deck2 = new ArrayList<>();

    public static void main(String[] args) {

        //Making the deck
        for(int i = 0; i < 13; i++)
        {
            for(int k = 0; k < 4; k++)
            {
                cards.add(new Card(i, k));
            }
        }

        Collections.shuffle(cards); //Shuffle after making deck

        //Distributing cards
        for(int i = 0; i < 26; i++)
        {
            deck1.add(cards.get(0));
            cards.remove(0);
            deck2.add(cards.get(0));
            cards.remove(0);
        }

        //Playing the game
        while(!(deck1.size() == 0 || deck2.size() == 0))
        {
            Card card1 = deck1.get(0);
            Card card2 = deck2.get(0);

            if(card1.getType() > card2.getType()) //deck1 wins
            {
                System.out.println("Deck1 won!");
                System.out.println("Card1: " + card1.getType());
                System.out.println("Card2: " + card2.getType());

                deck1.remove(0);
                deck2.remove(0);
                deck1.add(card1);
                deck1.add(card2);
            }
            else if(card1.getType() == card2.getType())
            {
                System.out.println("War!");
                war(1);
            }
            else //deck2 wins
            {
                System.out.println("Deck2 won!");
                System.out.println("Card1: " + card1.getType());
                System.out.println("Card2: " + card2.getType());

                deck1.remove(0);
                deck2.remove(0);
                deck2.add(card2);
                deck2.add(card1);
            }
        }
    }


    private static ArrayList<Card> warCards1 = new ArrayList<>();
    private static ArrayList<Card> warCards2 = new ArrayList<>();

    private static void war(int warIndex)
    {
        int checking = (warIndex *4) + 1;
        if(!warCards1.isEmpty())
            warCards1.clear();
        if(!warCards2.isEmpty())
            warCards2.clear();

        //add cards that will be given up
        for(int i = 0; i < checking; i++)
        {
            if(deck1.get(i) != null)
                warCards1.add(deck1.get(i));
            if(deck2.get(i) != null)
                warCards2.add(deck2.get(i));
        }

        if(!(deck1.size() < 5 || deck2.size() < 5)) //if they have enough cards to do regular war
        {
            if(deck1.get(checking).getType() > deck2.get(checking).getType()) //deck1 wins
            {
                for(int i = 0; i < checking; i++)
                {
                    deck1.remove(0);
                    deck2.remove(0);
                }

                deck1.addAll(warCards1);
                deck1.addAll(warCards2);
                warCards1.clear();
                warCards2.clear();
            } else if(deck1.get(checking).getType() == deck1.get(checking).getType())
            {
                war(warIndex++);
            } else //deck2 wins
            {
                for(int i = 0; i < checking; i++)
                {
                    deck1.remove(0);
                    deck2.remove(0);
                }

                deck2.addAll(warCards1);
                deck2.addAll(warCards2);
                warCards1.clear();
                warCards2.clear();
            }
        } else if(deck1.size() < 5) // if deck1 is too small
        {
            if(deck1.get(deck1.size() - 1).getType() > deck2.get(checking).getType())
            {
                for(int i = 0; i < checking; i++)
                {
                    deck2.remove(0);
                }

                deck1.clear();
                deck1.addAll(warCards1);
                deck1.addAll(warCards2);
                warCards1.clear();
                warCards2.clear();
            } else if (deck1.get(deck1.size() - 1).getType() == deck2.get(checking).getType())
            {
                System.out.println("Deck 1 is out of cards!");
                deck1.clear();
            } else
            {
                System.out.println("Deck 2 wins!");
                deck1.clear();
            }
        } else // deck2 is too small
        {
            if(deck2.get(deck2.size() - 1).getType() > deck1.get(checking).getType())
            {
                for(int i = 0; i < checking; i++)
                {
                    deck1.remove(0);
                }

                deck2.clear();
                deck2.addAll(warCards1);
                deck2.addAll(warCards2);
                warCards1.clear();
                warCards2.clear();
            } else if (deck1.get(deck1.size() - 1).getType() == deck2.get(checking).getType())
            {
                System.out.println("Deck 2 is out of cards!");
                deck2.clear();
            } else
            {
                System.out.println("Deck 1 wins!");
                deck2.clear();
            }
        }
    }
}
