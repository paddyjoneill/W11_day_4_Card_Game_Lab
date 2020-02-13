import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void populateDeck() {
        SuitType suits[] = SuitType.values();
        FaceValueType faceValues[] = FaceValueType.values();
        for (SuitType suit : suits){
            for (FaceValueType faceValue : faceValues){
                Card card = new Card(suit, faceValue);
                this.cards.add(card);
            }
        }
    }
}
