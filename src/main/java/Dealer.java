
import java.util.ArrayList;

public class Dealer {

    private Deck deck;
    private ArrayList<Card> hand;
    private boolean bust;

    public Dealer(Deck deck) {
        this.deck = deck;
        this.hand = new ArrayList<Card>();
        this.bust = false;
    }

    public void dealCards(ArrayList<Player> players){
        for (int i=0; i<2; i++){
            hand.add(deck.dealCard());
            for(Player player : players){
                player.takeACard(deck.dealCard());
            }
        }

    }

    public Deck getDeck() {
        return deck;
    }

    public int cardCount() {
        return hand.size();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void emptyHand(){
        this.hand.clear();
    }

    public void takeACard(Card card){
        this.hand.add(card);
    }

    public int getHandValue() {
        int handValue = 0;
        for (Card card: hand){
            handValue += card.getFaceValue();
        }
        return handValue;
    }

    public Card dealACard() {
        return deck.dealCard();
    }

    public void hitOrStick() {
        if ( this.getHandValue() < 16 ){
            System.out.println("The dealer has less than 16 so has to hit");
            this.takeACard(this.dealACard());
            this.hitOrStick();
        } else if (this.getHandValue() > 21){
            System.out.println("The dealer has gone bust");
            this.bust = true;
        }
        else {
            System.out.println("The dealer has stuck");
        }
    }

    public boolean isBust() {
        return bust;
    }
}
