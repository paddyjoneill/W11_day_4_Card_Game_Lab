public class Runner {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.populateDeck();
        deck.shuffleDeck();
        System.out.println(deck.getCards().get(0).getSuit());
        System.out.println(deck.getCards().get(0).getFaceValue());
        System.out.println(deck.getCards().get(1).getSuit());
        System.out.println(deck.getCards().get(1).getFaceValue());

    }
}
