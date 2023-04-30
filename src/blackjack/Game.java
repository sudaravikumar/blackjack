package blackjack;

import java.util.ArrayList;
import java.util.List;

import blackjack.actor.Dealer;
import blackjack.actor.Player;
import blackjack.resource.Deck;

public class Game {

    private Deck deck, discarded;

    private Dealer dealer;
    private List<Player> players = new ArrayList<>();
    private int noOfPlayers = 1;


    /**
     * Constructor for Game, creates our variables and starts the Game
     */
    public Game(int noOfPlayers){

    	this.noOfPlayers = noOfPlayers;
        //Create a new deck with 52 cards
        deck = new Deck(true);
        //Create a new empty deck
        discarded = new Deck();

        //Create the People
        dealer = new Dealer();
        
        for(int i=0; i < this.noOfPlayers; i++)
        	players.add(new Player(i+1));

        //Shuffle the deck and start the first round
        deck.shuffle();
        playGame();
    }



    private void playGame(){

        //Check to make sure the deck has at least 4 cards left
        if(deck.cardsLeft() < 4){
            deck.reloadDeckFromDiscard(discarded);
        }

        //Give the dealer two cards
        dealer.getHand().takeCardFromDeck(deck);
        dealer.getHand().takeCardFromDeck(deck);

        //Give the player two cards
        for(Player player : players) {
        	player.getHand().takeCardFromDeck(deck);
        	player.getHand().takeCardFromDeck(deck);
        }

        //Show the dealers hand with one card face down
        dealer.printFirstHand();

        //Show the player's hand
        for(Player player : players)
        	player.printHand();

        //Check if dealer has BlackJack to start
        if(dealer.hasBlackjack()){
            //Show the dealer has BlackJack
            dealer.printHand();

            //Check if the player also has BlackJack
            for(Player player : players) {
	            if(player.hasBlackjack()){
	                System.out.println(player.getName()+ "and dealer have 21. Both wins.");
	                return;
	            }
	            else{
	                System.out.println("Dealer has BlackJack. Dealer wins.");
	                dealer.printHand();
	                return;
	            }
            }
        }

        for(Player player : players)
	        if(player.hasBlackjack()){
	            System.out.println(player.getName()+ " have Blackjack! wins!");
	            return;
	        }

        //Let the player decide what to do next
        for(Player player : players) {
        	player.makeDecision(deck, discarded);

	        //Check if they busted
	        if(player.getHand().calculatedValue() > 21){
	            System.out.println(player.getName()+" have gone over 21.");
	            player.setBusted(true);
	        }
        }

        //Now it's the dealer's turn
        dealer.printHand();
        while(dealer.getHand().calculatedValue()<17){
            dealer.hit(deck, discarded);
        }

        //Check who wins
        List<Player> maxCountPlayers = getMaxValuePlayer();
        int maxCount = maxCountPlayers.size()>0 ? maxCountPlayers.stream().findFirst().get().getHand().calculatedValue() : 0;
        if(dealer.getHand().calculatedValue()>21){
            System.out.println("Dealer busts");
            if(maxCountPlayers.size() <= 0)
            	System.out.println("All players bust");
            else
            	for(Player player : players)
            		if(!player.hasBusted())
            			System.out.println(player.getName()+" wins.");
    	        	
        }
        else if(maxCountPlayers.size() <= 0 || dealer.getHand().calculatedValue() > maxCount){
            System.out.println("Dealer wins.");
        }
        else if(maxCount > dealer.getHand().calculatedValue()){
        	for(Player player : maxCountPlayers)
        		System.out.println(player.getName()+" wins.");
        }
        else{
            System.out.println("Dealer wins for equal score with player");
        }
    }

    private List<Player> getMaxValuePlayer() {
    	List<Player> maxCountPlayers = new ArrayList<>();
    	int maxCount = 0;
    	for(Player player : players) {
    		int count = player.getHand().calculatedValue();
    		if(count <= 21) {
    			if(count > maxCount) {
	    			maxCount = count;
	    			maxCountPlayers = new ArrayList<>();
	    			maxCountPlayers.add(player);
    			} else if(count == maxCount) {
    				maxCountPlayers.add(player);
    			}
    		}
    	}
    	
    	return maxCountPlayers;
    }

}
