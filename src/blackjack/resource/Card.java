package blackjack.resource;

import blackjack.utils.Rank;
import blackjack.utils.Suit;

public class Card implements Comparable<Card>{

     private Suit suit;
     private Rank rank;

    /**
     *
     * @param suit  The Suit of the card to be created
     * @param rank  The Rank of the card to be created
     */
    public Card(Suit suit, Rank rank){
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Copy constructor
     * @param card the card being copied
     */
    public Card(Card card){
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    /**
     *
     * @return  The numerical value of the Card
     */
    public int getValue(){
        return rank.getRankValue();
    }

    /**
     *
     * @return The suit of the Card.
     */
    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public String toString(){
        return ("["+rank+" of "+ suit + "] ("+this.getValue()+")");

    }

    @Override
    public int compareTo(Card c) {
        //if this card is greater than the other card
        if(this.getValue() > c.getValue()){
            return 1;
        }
        else if(this.getValue() < c.getValue()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
