import java.util.Stack; //Utilized the java utility of stack
//The Stack class represents a last-in-first-out (LIFO) stack of objects.


  //      The stack of cards left after cards are dealt to players

public class Pile {

        //The stack that stores the Card objects.
        private Stack<Card> pile = new Stack<Card>();
        
        //Initializes an empty pile default constructor
        public Pile() {
                
        }
        
        //Places initial cards into pile
        public Pile(Card[] cards) {
                for(int c = 0; c < cards.length; c++) {
                        pile.push(cards[c]);
                }
        }
        
        //Randomizes order of the cards 
        public void shuffle() {
                //Places all the cards into an array and shuffles the array/
                Card[] cards = new Card[pile.size()];
                pile.copyInto(cards);
                Deck.shuffleDeck(cards);
                
                //Empties the Pile, then refills it with the shuffled cards
                pile.removeAllElements();
                for(int c = 0; c < cards.length; c++) {
                        pile.push(cards[c]);
                }
                
        } 
        
        //Cards left in pile of cards
        public int getCardCount() {
                return pile.size();
        }
        
        //When doing GoFish this takes the top card
        public Card takeTopCard() {
                return (pile.isEmpty() ? null : pile.pop());
        }
        
       //Places a card onto the top pile
        public void putDownACard(Card card) {
                pile.push(card); //Stack method
        }
        
        //Returns a face up representation of card at top
        public String TopCardString() {
                return (pile.isEmpty() ? null : pile.peek().toString()); //Stack method
        }
        
        //Integer representation of card on top
        public int TopCardInt() {
                return (pile.isEmpty() ? -1 : pile.peek().getFace() + pile.peek().getSuit());
        }
        
}
