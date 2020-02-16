import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    private Card card1;
    private Card card2;
    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Game game;

    @Before
    public void before() {
        deck = new Deck();
        deck.createAndShuffleDeck();
        player = new Player("Paddy");
        dealer = new Dealer(deck);
        game = new Game(dealer);
        card1 = new Card(SuitType.HEARTS, FaceValueType.SEVEN);
        card2 = new Card(SuitType.DIAMONDS, FaceValueType.EIGHT);
    }

    @Test
    public void game_starts_with_dealer_and_no_players(){
        assertEquals(dealer, game.getDealer());
        assertEquals(0, game.getPlayers().size());
    }

    @Test
    public void can_add_player_to_the_game(){
        game.addPlayer(player);
        assertEquals(1, game.getPlayers().size());
    }

    @Test
    public void can_deal_cards_to_players_and_dealer(){
        game.addPlayer(player);
        game.deal(game.getPlayers());
        assertEquals(2, player.cardCount());
        assertEquals(2, dealer.cardCount());
        assertEquals(48, deck.cardCount());
    }

    @Test
    public void players_and_dealer_can_return_cards(){
        game.addPlayer(player);
        game.deal(game.getPlayers());
        deck.returnCards(dealer.getHand());
        dealer.emptyHand();
        deck.returnCards(player.getHand());
        player.emptyHand();
        assertEquals(52, deck.cardCount());
        assertEquals(0, player.cardCount());
        assertEquals(0, dealer.cardCount());
    }

    @Test
    public void can_get_player_and_dealer_hand_values(){
        game.addPlayer(player);
        dealer.takeACard(card1);
        dealer.takeACard(card2);
        player.takeACard(card1);
        player.takeACard(card2);
        assertEquals(15, dealer.getHandValue());
        assertEquals(15, player.getHandValue());
    }

    @Test
    public void can_get_result_between_player_and_dealer(){
        game.addPlayer(player);
        dealer.takeACard(card1);
        dealer.takeACard(card2);
        player.takeACard(card2);
        player.takeACard(card2);
        assertEquals("player", game.decideResult(player));
        player.emptyHand();
        player.takeACard(card1);
        player.takeACard(card1);
        assertEquals("dealer", game.decideResult(player));
        player.emptyHand();
        player.takeACard(card1);
        player.takeACard(card2);
        assertEquals("draw", game.decideResult(player));
    }




}
