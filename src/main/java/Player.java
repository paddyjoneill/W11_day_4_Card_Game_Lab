import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Player {
    private ArrayList<Card> hand;
    private String name;
    private Scanner scanner = new Scanner(System.in);
    private boolean bust;
    private boolean stick;

    public Player(String name){
        this.hand = new ArrayList<Card>();
        this.name = name;
        this.bust = false;
        this.stick = false;
    }

    public void takeACard(Card card){
        this.hand.add(card);
    }

    public int cardCount(){
        return this.hand.size();
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }

    public void emptyHand() {
        this.hand.clear();
    }

    public int getHandValue() {
        int handValue = 0;
        for (Card card : hand){
            handValue += card.getFaceValue();
        }
        return handValue;
    }

    public void hitOrStick(Dealer dealer){
        if (!this.bust && !this.stick) {
            for (Card card : hand) {
                String yourCards = String.format("You have the %s of %s", card.getFaceValue(), card.getSuit());
                System.out.println(yourCards);
            }
            String cardTotal = String.format("You currently have %s", this.getHandValue());
            System.out.println(cardTotal);
            System.out.println("Do you want to (h)it or (s)tick?");
            String input = scanner.next();
            System.out.println(input);
            if (input.equals("h")) {
                Card dealtCard = dealer.dealACard();
                this.takeACard(dealtCard);
                String newCard = String.format("You have been dealt the %s of %s", dealtCard.getFaceValue(), dealtCard.getSuit());
                System.out.println(newCard);
                if (this.getHandValue()>21){
                    this.bust = true;
                    System.out.println("You have gone bust");
                }
                hitOrStick(dealer);

            } else if (input.equals("s")) {
                System.out.println("You have stuck");
            } else {
                System.out.println("Please enter h or s for hit or stick");
                this.hitOrStick(dealer);
            }
        }
    }

    public static void createPlayers(Game game){
        Scanner scanner  = new Scanner(System.in);

        System.out.println("How many players?");
        String input = scanner.next();
        int players = parseInt(input);

        for(int i = 0; i < players; i++){
            String prompt = String.format("Player %s, enter your name: ", (i + 1));
            System.out.println(prompt);
            String playerName = scanner.next();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }
    }

    public boolean isBust() {
        return bust;
    }
}
