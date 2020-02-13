import java.util.ArrayList;

public class Player {
    private Card card;

    public Player(){
        this.card = null;
    }

    public void takeACard(Card card){
        this.card = card;
    }

    public Card giveBackCard(){
        Card cardycard = this.card;
        this.card = null;
        return cardycard;
    }

    public Card getCard() {
        return this.card;
    }

    public int getCardValue(){
        return this.card.getFaceValue();
    }
}
