import java.util.LinkedList;

public class Hand {
        
        //The list that contains your hand of cards.
        private LinkedList<Card> hand = new LinkedList<Card>();
        
        
        //Creates an empty hand of cards.
        
        public Hand() {
                
        }
        

        //Creates a hand of cards that contains  initial cards.

        public Hand(Card[] cards) {
                for(int c = 0; c < cards.length; c++) {
                        hand.add(cards[c]);
                }
        }
        
        //Number of Cards in hand
        public int getCardCount() {
                return hand.size();
        
        }
        
        //Choose a Specific card and play it
        public Card playACard(int card) {
                return (hand.size() < card ? null : hand.remove(card));
        }
        
        //Add a card from deck
        public void receiveACard(Card card) {
                if(card != null) {
                        hand.add(card);
                }
        }
        
        //Returns the readable format of each card format 
        public String[] getHandStrings() {
                //Check if there are any cards in the hand first.
                if(hand.size() == 0) {
                        return null;
                }
                //Iterate through cards and gets the String representation.
                String[] cardNames = new String[hand.size()];
                for(int c = 0; c < cardNames.length; c++) {
                        cardNames[c] = hand.get(c).toString();
                }
                return cardNames;
        }
        
        //Integer value of cards currently 
        public int[] getHandInts() {
                //Check if there are any cards in the hand first.
                if(hand.size() == 0) {
                        return null;
                }
                //Iterate through cards and calculate the integer representation.
                int[] cardInts = new int[hand.size()];
                for(int c = 0; c < cardInts.length; c++) {
                        Card card = hand.get(c);
                        cardInts[c] = card.getFace() + card.getSuit();
                }
                return cardInts;
        }
        
       
        public boolean checkForFace(int face) {
                for(int c = 0; c < hand.size(); c++) {
                        if(hand.get(c).getFace() == face) {
                                return true;
                        }
                }
                return false;
        } 
        
}
