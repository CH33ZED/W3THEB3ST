import java.util.Scanner;

//The Player class is the user input part of the game

public class Player {
        
        //The name of the human user "The Player".
        private String name;
        private Hand myHand;             //Players hand of cards
        private Pile myDraw;             //Pile from which player should draw new cards as needed.
        private Pile myPairs;         //Place to put matched cards (score)


        //One scanner shared by all human players seems kindve bad because other player can see whta cards you have.
        private static Scanner theScanner = new Scanner(System.in);
        private int falseInputs = 0; //If there is a false input
        
        
         //Creates a new Human Player
        public Player(String name, Hand myHand, Pile Draw, Pile Pairs) {
                //Sets up player name and card piles/hands
                this.name = name;
                this.myHand = myHand;
                myDraw = Draw;
                myPairs = Pairs;
                
                System.out.println("Welcome " + name);
        
                while(removePairs()); //This remove the pairs and is added to score

        }
        
        /*
        Finally we've gotten to the player turn
        This prints out which players turn it is and allows three options
        1) Check Hand
        2) Ask for a Card
        0) Quit Game
        */
        public int playerTurn() {
                
                System.out.println(name + "'s turn.");
                
                //Player's are not allowed to start the turn with empty hands
                //if it is at all possible to draw another card.
                if(myHand.getCardCount() == 0) {
                        drawACard();
                }
                
                //Force the user to enter a legal option for their turn.
                // Only way out is by asking opponent for a card.
                int choice = -1;
                while(true) {
                        showChoices();
                        //Player must pick from one of these choices
                        while(choice == -1) {
                                choice = getIntFromUser();
                        }
                        //check options.
                        switch(choice) {
                                case 1:
                                        showHand(); //Shows Hand of Cards currently
                                        break;
                                case 2:
                                        return askForCard(); //Allows user to input for Ask Card
                                case 0: //Using cases checks for a specific case and then allows you to assign something for that case 
                                        //Note: This exits the program completely
                                        System.out.println("Thank you for playing!");
                                        System.exit(0);
                        }//switch(choice)
                        choice = -1;
                }//while(true)          
        } //playerTurn()
        
         //
        public Card reaction(int cardFace) {
                //Make sure the hand isn't empty
                //If its empty, return null
                int[] cards = myHand.getHandInts();
                if(cards == null) {
                        return null;
                }
                //If it isn't, search hand for a card with the same face
                //value as the one requested.  If found, return it.
                for(int i = 0; i < cards.length; i++) {
                        if(cards[i] % 16 == cardFace) {
                                return myHand.playACard(i);
                        }
                }
                //No match, return null
                return null;
        } //reaction()
        
        //Searches a players hands for any duplicate cards and places them in the pair pile for scoring.

        private boolean removePairs() {
                //First check that we have cards in the hand. 
                //If we don't, draw a single card and return no match
                int[] cards = myHand.getHandInts();
                if(cards == null) {
                        drawACard();
                        return false;
                }
                //Iterates through the hand and checks for any two cards that match.
                for(int i = 0; i < cards.length; i++) {
                        for (int j = i+1; j < cards.length; j++) {
                                //If a matching pair is found, score them and return true.
                                if(cards[i] % 16== cards[j] % 16) { //Divides by 16 only would deivide by 16 because last hex decimal value
                                        System.out.println(name + " matched a pair of " + Card.getFaceString(cards[i] % 16));
                                        myPairs.putDownACard(myHand.playACard(j));
                                        myPairs.putDownACard(myHand.playACard(i));
                                        //If there are not cards left in the players hand, draw a single card.
                                        if(myHand.getCardCount() == 0) {
                                                drawACard();
                                        }
                                        return true;
                                } 
                        }
                }
                
                //No match found.
                //If the hand is empty, draw a new card.
                if(myHand.getCardCount() == 0) {
                        drawACard();
                }
                
                return false;
        }//removePairs()
        
        

         //User Choices
        private void showChoices() {
                System.out.println("1. Your Virtual hand of cards");
                System.out.println("2. Ask your opponent for a card");
                System.out.println("0. Get me the hell out of here!!");
        }
        
        //Allows user to ask for a specific card
        private int askForCard() {
                falseInputs=0;
                showHand();
                System.out.println("Choose a card to ask for. 1-13.");
                //Enter an infinite loop until the user enters a face card value that matches one of the cards in their hand.
                //Too many false inputs means reprint their choices 
                while(true) {
                        //Get an int
                        int choice = getIntFromUser();
                        if(myHand.checkForFace(choice)) {
                                //return the selected face value
                                return choice;
                        } else {
                                //remind user of cards in their hand.
                                System.out.println("You thieving cheater, you must have the card in your hand!");
                                falseInputs++;
                                if(falseInputs == 3) {
                                        showHand();
                                        System.out.println("Choose a card to ask for. Type numbers from 1-13.");
                                        falseInputs = 0;
                                }
                        }
                } 
        } 
        
        //Cards currently in users hand
        private void showHand() {
                System.out.println("---------------");
                String[] cardNames = myHand.getHandStrings();
                //Iterates through the cards and prints.
                if(cardNames == null) {
                        System.out.println("No Cards");
                } else {
                        for(int c = 0; c < cardNames.length; c++) {
                                System.out.println(cardNames[c]);
                        }
                }
                System.out.println("---------------");
        } 
        
        //Returns username player 1 or Player 2
        public String getName() {
                return name;
        }
        
        //
        public void drawACard() {
                myHand.receiveACard(myDraw.takeTopCard());
                removePairs();
        }

        //Player receives a card and places in hand
        public void receiveACard(Card card) {
                myHand.receiveACard(card);
                removePairs();
        }

        //Returns if user has cards
        public boolean hasCards() {
                return myHand.getCardCount() == 0 ? false : true;
        }
        
        //Pretty self explanatory, gets the integer you asked for from user
        private int getIntFromUser() {
                int value = -1;
                String input = theScanner.next();
                //Check if it's an int, if so return
                //the value, otherwise return -1
                try {
                        value = Integer.parseInt(input);
                        theScanner.nextLine();
                } catch(NumberFormatException e) {//If user enters card they dont have
                        falseInputs++;
                        if(falseInputs == 3) {
                                showChoices();
                                falseInputs = 0;
                        }
                }
                return value;
        }
} 
