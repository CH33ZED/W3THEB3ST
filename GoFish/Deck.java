public class Deck {
        
        
        /*
          Face values of the cards in the default deck.
         */
        public static final int[] Faces = {
                Card.ACE,       
                Card.TWO,       
                Card.THREE, 
                Card.FOUR,      
                Card.FIVE,      
                Card.SIX, 
                Card.SEVEN, 
                Card.EIGHT, 
                Card.NINE,
                Card.TEN,       
                Card.JACK,      
                Card.QUEEN, 
                Card.KING 
        };

        // Suits of Cards
        public static final int[] Suits = {
                Card.HEARTS,
                Card.DIAMONDS,
                Card.CLUBS,
                Card.SPADES
        };
        
        static Card[] generateDeck() {
                return generateDeck(0);
        }
        
        // Was going to have Jokers but then decided not to however this does generate the deck
        static Card[] generateDeck(int numJokers) {
                
                //Create the array, fill it with every possible combination of
                //suit and face.
                Card[] deck = new Card[Faces.length * Suits.length];
                for(int suit = 0; suit < Suits.length; suit++) {
                        for(int face = 0; face < Faces.length; face++) {
                                deck[suit * Faces.length + face] = new Card(Faces[face], Suits[suit]);
                        }
                }
                
                return deck;
        } 
        
        //This randomizes the Deck - I made this
        static void shuffleDeck(Card[] cards) {
                for(int c = cards.length - 1; c > 0; c-- ) {
                        int r = (int)(Math.random() * (c + 1));
                        Card temp = cards[c];
                        cards[c] = cards[r];
                        cards[r] = temp;
                }
        }
        
}

