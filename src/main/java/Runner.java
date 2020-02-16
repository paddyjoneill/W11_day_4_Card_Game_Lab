import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {
    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.createAndShuffleDeck();
        Dealer dealer = new Dealer(deck);
        Game game = new Game(dealer);

        Player.createPlayers(game);

        game.deal(game.getPlayers());

        for (Player player : game.getPlayers()) {
            player.hitOrStick(dealer);
        }

        dealer.hitOrStick();

        for (Player player : game.getPlayers()) {
            String result = game.decideResult(player);
            System.out.println(result);
        }

    }
}
