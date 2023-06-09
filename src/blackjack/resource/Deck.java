package blackjack.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import blackjack.utils.Rank;
import blackjack.utils.Suit;

public class Deck {

    private ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
    }

    public Deck(Deck c){
        Collections.copy(this.deck, c.getCards());
    }

    public Deck(boolean makeDeck){
        deck = new ArrayList<Card>();
        if(makeDeck){
            //Go through all the suits
            for(Suit suit : Suit.values()){
                //Go through all the ranks
                for(Rank rank : Rank.values()){
                    //add a new card containing each iterations suit and rank
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    public void addCard(Card card){
        deck.add(card);
    }

    public void addCards(ArrayList<Card> cards){
        deck.addAll(cards);
    }

    public String toString(){
        String output = "";

        for(Card card: deck){
            output += card;
            output += "\n";
        }
        return output;
    }

    public void shuffle(){
        Collections.shuffle(deck, new Random());
    }

    public Card takeCard(){

            //Take a copy of the first card from the deck
            Card cardToTake = new Card(deck.get(0));
            //Remove the card from the deck
            deck.remove(0);
            //Give the card back
            return cardToTake;

    }

    public boolean hasCards(){
        if (deck.size()>0){
            return true;
        }
        else{
            return false;
        }
    }

    public int cardsLeft(){
        return deck.size();
    }

    public ArrayList<Card> getCards() {
        return deck;
    }

    public void emptyDeck(){
        deck.clear();
    }

    public void reloadDeckFromDiscard(Deck discard){
        this.addCards(discard.getCards());
        this.shuffle();
        discard.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
    }

}
