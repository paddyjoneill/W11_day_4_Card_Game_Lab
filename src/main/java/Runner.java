public class Runner {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.populateDeck();
        deck.shuffleDeck();

        Player player1 = new Player();
        Player player2 = new Player();

        player1.takeACard(deck.dealCard());
        player2.takeACard(deck.dealCard());

        System.out.println(player1.getCardValue());
        System.out.println(player2.getCardValue());

        if (player1.getCardValue() > player2.getCardValue()){
            System.out.println("player 1 wins");
        }
        else if (player1.getCardValue() == player2.getCardValue()){
            System.out.println("draw");
        }
        else {
            System.out.println("player 2 wins");
        }

//        System.out.println(deck.getCards().get(0).getSuit());
//        System.out.println(deck.getCards().get(0).getFaceValue());
//        System.out.println(deck.getCards().get(1).getSuit());
//        System.out.println(deck.getCards().get(1).getFaceValue());

    }
}
