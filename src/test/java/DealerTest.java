import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Card card;
    private Deck deck;
    private Dealer dealer;
    private Player player;
    private ArrayList<Player> players;



    @Before
    public void before(){
        card = new Card(SuitType.DIAMONDS, FaceValueType.EIGHT);
        deck = new Deck();
        deck.createAndShuffleDeck();
        player = new Player("Steve");
        players = new ArrayList<Player>();
        players.add(player);
        dealer = new Dealer(deck);

    }

    @Test
    public void dealer_starts_with_52_cards(){
        assertEquals(52, dealer.getDeck().getCards().size());
    }

    @Test
    public void has_51_cards_after_dealing_1_card(){
        dealer.dealACard();
        assertEquals(51, dealer.getDeck().getCards().size());
    }

    @Test
    public void has_48_cards_after_dealing_to_player_and_self(){
        dealer.dealCards(players);
        assertEquals(48, dealer.getDeck().getCards().size());
        assertEquals(2, dealer.cardCount());
    }

    @Test
    public void starts_with_empty_hand(){
        assertEquals(0, dealer.cardCount());
    }

    @Test
    public void can_get_hand_value(){
        dealer.takeACard(card);
        dealer.takeACard(card);
        assertEquals(16, dealer.getHandValue());
    }



}
