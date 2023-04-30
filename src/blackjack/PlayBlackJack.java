package blackjack;

import java.util.Scanner;

public class PlayBlackJack {

    public static void main(String[] args) {

        System.out.println("Welcome to BlackJack.");
        Scanner input = new Scanner(System.in);
        int count = 1;
        do {
        	System.out.println("Number of players: (maximum 3 players)");
        	count = input.nextInt();
        }while(count > 3 || count < 1);
        
        try {
        	new Game(count);
        }finally {
        	input.close();
        }
    }
}
