public class Card {

    private SuitType suit;
    private FaceValueType faceValue;

    public Card(SuitType suit, FaceValueType faceValue){
        this.suit = suit;
        this.faceValue = faceValue;
    }

    public SuitType getSuit() {
        return this.suit;
    }

    public int getFaceValue() {
        return this.faceValue.getCardValue();
    }
}
