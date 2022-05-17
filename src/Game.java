import java.util.Scanner;

public class Game {
    private Deck deck;

    private Dealer dealer;
    private Player player;
    private int wins;
    private int losses;
    private int pushes;
    private int round;
    Scanner input = new Scanner(System.in);
    

    public Game() {
        wins = 0;
        losses = 0;
        pushes = 0;
        round = 0;
        player = new Player();
        dealer = new Dealer();
        deck = new Deck();
        deck.shuffleDeck();
        boolean canPlayRound = true;
        do {
            round++;
            System.out.println(" ********************* Begin round " + round + " **************************************");
            canPlayRound = playRound();
            printScore();
            player.discardHand();
            dealer.discardHand();
        } while(canPlayRound);        
        
        System.out.println("******************** Game over.. Final Score");
        printScore();      
    }

    public void printScore() 
    {
        System.out.println("Wins " + wins + " Losses: " + losses + " Ties: " + pushes);
    }

    public void printBoard(boolean showDealerCard)
    {
        if(showDealerCard)
        {
            System.out.println("Player: " + player.getHand() + " Value : " + player.getHand().calculatedValue() 
        + " Dealer: " + dealer.getHand() + " Value: " + dealer.getHand().calculatedValue());
        }
        else
        {
            System.out.println("Player: " + player.getHand() + " Value : " + player.getHand().calculatedValue() 
        + " Dealer: " + dealer.getHand().getCard(0));
        }
        

    }

    private boolean playRound() {
        Card card = deck.takeCard();
        if(card == null) return false;   
        player.getHand().addCardToHand(card);

        card = deck.takeCard();
        if(card == null) return false;
        player.getHand().addCardToHand(card);

        card = deck.takeCard();
        if(card == null) return false;
        dealer.getHand().addCardToHand(card);

        card = deck.takeCard();
        if(card == null) return false;
        dealer.getHand().addCardToHand(card);

        printBoard(false);

        if(dealer.hasBlackJack() && !player.hasBlackJack())
        {
            System.out.println("Dealer has blackjack.. ");
            printBoard(true);
            losses++;
            return true;
        }
        else if(player.hasBlackJack() && !dealer.hasBlackJack())
        {
            System.out.println("Player wins with blackjack");
            printBoard(true);
            wins++;
            return true;
        }
        else if(player.hasBlackJack() && dealer.hasBlackJack())
        {
            System.out.println("Both player and dealer has blackjack. Its a push");
            printBoard(true);
            pushes++;
            return true;
        }

        int decision;
        do 
        {
            System.out.println("Player turn.. Enter 1 to hit 2 to stand");
            decision =Integer.valueOf(input.nextLine());
            if(decision == 1)
            {
                card = deck.takeCard();
                if(card == null) return false;
                player.getHand().addCardToHand(card);
                printBoard(false);
                if(player.getHand().hasBusted())
                {
                    System.out.println("Player looses");
                    printBoard(true);
                    losses++;
                    return true;
                }                
            }
        } while(decision != 2);   
        
        // Player has stayed.. dealer turn
        do {
            card = deck.takeCard();
            if(card == null) return false;
            dealer.getHand().addCardToHand(card);
            printBoard(true);
            if(dealer.getHand().hasBusted()) {
                System.out.println("Player Wins");
                wins++;
                return true;
            }
        } while(dealer.getHand().calculatedValue() <= 16);

        int dealerValue = dealer.getHand().calculatedValue();
        int playerValue = player.getHand().calculatedValue();
        if(dealerValue == playerValue)
        {
            System.out.println("Its a tie");
            pushes++;
            return true;
        }
        else if(dealerValue > playerValue)
        {
            System.out.println("Player looses");
            losses++;
            return true;
        }
        else
        {
            System.out.println("Player wins");
            wins++;
            return true;
        }
    }    
}
