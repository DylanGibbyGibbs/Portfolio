package guessing;

import java.util.Collections;
import java.util.ArrayList;


public class deck 
{
    // Hint for creating an arraylist of cards:
ArrayList<card> deck = new ArrayList<card>();


public void initializedeck()
{
    for(int i = 0; i<4; i++)
    {
        
        for(int j = 0; j<13; j++)
        {
            card mycard = new card(i,j);
            deck.add(mycard);
        }
    }
}

public void printallcards()
{
    for(int i =0; i<deck.size(); i++)
    {
        System.out.println(deck.get(i));
    }
}


//Return Two decks for the players here
public ArrayList<card> splitdeckone()
{
    ArrayList<card> firsthalf = new ArrayList<card>();
    for(int i = 0; i<26; i++)
    {
    firsthalf.add(deck.get(i));
    } 
//  System.out.println(firsthalf);  
  return firsthalf;  
}

public ArrayList<card> splitdecktwo()
{
      ArrayList<card> secondhalf = new ArrayList<card>();
    for(int i = 26; i<52; i++)
    {
    secondhalf.add(deck.get(i));
    } 
  //System.out.println(secondhalf);  
  return secondhalf;  
}


public void countcards()
{
    System.out.println(this.deck.size());
}

public void shuffle()
{
 Collections.shuffle(this.deck); 
}

public card getTopCard()
{
    return deck.remove(0);
}

}
