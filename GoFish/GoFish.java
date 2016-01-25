/*
A game of the fun card game go fish
Rules: Each player receives 7 cards from a standard 52 Card Deck
Each player gets points for each pair they have not book(4 cards)
A player does go again if they get a pair from another player 
but not if they get a pair from pile.
The player with the most pairs wins in the end
*/

public class GoFish {

        static String PlayerOne = "Dhruba"; //Pick who will be Dhruba
        static String PlayerTwo = "Ziyan"; //Pick who will be Ziyan

//Play a game of Gofish
public static void main(String[] args) {
 String playerOneName = PlayerOne;       //Initizalizes Player names in command line
        try {
              playerOneName = args[0];
                } catch (ArrayIndexOutOfBoundsException e){
                        
                }
                String playerTwoName = PlayerTwo;
                try {
                        playerTwoName = args[1];
                } catch (ArrayIndexOutOfBoundsException e){
                        
                }
                
                //Create decks and card piles for each player
                //Deals each player a hand of 7 cards
                Pile deck = new Pile(Deck.generateDeck());
                deck.shuffle();
                
                Pile PlayerOneDiscard = new Pile();
                Pile PlayerTwoDiscard = new Pile();

                Hand playerOneHand = new Hand();
                Hand playerTwoHand = new Hand();
                
                for(int i = 0; i < 7; i++) {
                        playerOneHand.receiveACard(deck.takeTopCard());
                        playerTwoHand.receiveACard(deck.takeTopCard());
                }

                Player playerOne = new Player(playerOneName, playerOneHand, deck, PlayerOneDiscard);
                Player playerTwo = new Player(playerTwoName, playerTwoHand, deck, PlayerTwoDiscard);
                

                // Cannot hand Player running out of cards in their hand before they run out of cards in the deck

                while(true) {
                        doTurn(playerOne, playerTwo);
                        if(deck.getCardCount() == 0 && !playerOne.hasCards() && !playerTwo.hasCards() ) {
                                break;
                        }
                        printGameInfo(deck, PlayerOneDiscard, PlayerTwoDiscard, playerOneHand, playerTwoHand);
                        doTurn(playerTwo, playerOne);
                        if(deck.getCardCount() == 0 && !playerOne.hasCards() && !playerTwo.hasCards() ) {
                                break;
                        }
                        printGameInfo(deck, PlayerOneDiscard, PlayerTwoDiscard, playerOneHand, playerTwoHand);
                }
                //Final score.
                System.out.println("Final Score: " + PlayerOneDiscard.getCardCount() / 2 + " to " + PlayerTwoDiscard.getCardCount() / 2);       
        }
        
        //Provides Score and amount of cards in deck and in hand every turn
        private static void printGameInfo(Pile deck, Pile PlayerOneDiscard, Pile PlayerTwoDiscard, Hand playerOneHand, Hand playerTwoHand) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Score: " + PlayerOneDiscard.getCardCount() / 2 + " to " + PlayerTwoDiscard.getCardCount() / 2);
                System.out.println("Cards in deck: " + deck.getCardCount());
                System.out.println("Cards in Hands: " + playerOneHand.getCardCount() + " and " + playerTwoHand.getCardCount());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        
        private static boolean doTurn(Player player, Player otherPlayer) {
                while(true) {
                        int ask = player.playerTurn();
                        System.out.println(player.getName() + ": " + otherPlayer.getName() + " do you have a " + Card.getFaceString(ask) + "?");
                        Card reaction = otherPlayer.reaction(ask);
                        if(reaction == null) {
                                System.out.println(otherPlayer.getName() + ": Go Fish!");
                                player.drawACard();
                                return false;
                        } else {
                                System.out.println(otherPlayer.getName() + ": Dang it! " + player.getName() + " I have one of those!");
                                player.receiveACard(reaction);
                                if(!player.hasCards()) {
                                        player.drawACard();
                                        return false;
                                }
                        }
                }
        }

}
// Received Dhruba's Brother help for some parts  Card, Deck and Pile.
// He had an initial Card Game program for Poker which had Card, Pile and Deck
//which I modified and then used as a basis for the game
//I modified those and created GoFish Player and Hand
