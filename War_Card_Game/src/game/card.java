package game;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gibby
 */
public class card {
    
 
private int suit;
private int value;

private String[] cardSuit = {"Spades", "Diamonds", "Hearts", "Clubs"};
private String[] cardValue = { "King", "Queen", "Jack", "10", "9", "8", "7", "6", "5", "4", "3", "2", "Ace"};

//constructor
public card(int cSuit, int cValue) {
    suit = cSuit;
    value = cValue;
}

public int getvalue()
{
    int v = value;
    return v;
}

//Formats how the cards are printed
public String toString() {
    String cardInfo = cardValue[value] + " of " + cardSuit[suit];

    return cardInfo;
}

public String getImage() {
    
    String path = "/images/" + cardValue[value] + cardSuit[suit] + ".png";
    return path;
    
}

    
}
