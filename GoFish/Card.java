public class Card {

        //Face or value of cards Are given hex values to represent in game values
        static final int ACE = 0x1;
        static final int TWO = 0x2;
        static final int THREE = 0x3;
        static final int FOUR = 0x4;
        static final int FIVE = 0x5;
        static final int SIX = 0x6;
        static final int SEVEN = 0x7;
        static final int EIGHT  = 0x8;
        static final int NINE = 0x9;
        static final int TEN = 0xA;
        static final int JACK = 0xB;
        static final int QUEEN = 0xC;
        static final int KING = 0xD;
        static final int ACE_HIGH = 0xE;
        
        //Suits
        static final int HEARTS = 0x10;
        static final int DIAMONDS = 0x20;
        static final int CLUBS = 0x30;
        static final int SPADES = 0x40;
        
        //Joker
        static final int JOKER = 0x0;
        
        //Returns a version of the card that gives the face value for it

        public static String getFaceString(int face) {
                //Return the common name for the card.
                switch(face) {
                        case ACE:
                        case ACE_HIGH:
                                return "Ace";
                        case JACK:
                                return "Jack";
                        case QUEEN:
                                return "Queen";
                        case KING:
                                return "King";
                        case JOKER:
                                return "Joker"; //Maybe for future purposes? I created it for giggles pretty much
                        default:
                                if(face > ACE && face < JACK) {
                                        return Integer.toString(face);
                                }
                                break;
                }
                //If the face card is > 13, == 0, or is a negative number.
                return "False";
        } 
        
        //Suits
        public static String getSuitString(int suit) {
                switch(suit) {
                        case HEARTS:
                                return "Hearts";
                        case DIAMONDS:
                                return "Diamonds";
                        case CLUBS:
                                return "Clubs";
                        case SPADES:
                                return "Spades";
                }
                //If suit is not a legal value.
                return "False";
        } 
        
        //Values for each individual card
        private int suit = -1;
        private int face = -1;
        private String cardString = null;
        
        
          //Creates a Card Object
         
        public Card(int face, int suit) {
                this.face = face;
                this.suit = suit;
        }
        
         //The suit of the card.
         
        public int getSuit() {
                return suit;
        }
        
         //Returns face of card
        public int getFace() {
                return face;
        }

        public String toString() {
                //This is possible because Cards are immutable.
                if(cardString == null ) {
                        cardString = getFaceString(getFace()) + " of " + getSuitString(getSuit());
                }
                return cardString;
        }
        
}
