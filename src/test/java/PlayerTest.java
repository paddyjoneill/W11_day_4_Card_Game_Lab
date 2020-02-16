import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Player player;
    private Card card;

    @Before
    public void before(){
        player = new Player("Paddy");
        card = new Card(SuitType.HEARTS, FaceValueType.THREE);
    }

    @Test
    public void starts_with_no_cards(){
        assertEquals(0 , player.cardCount());
    }

    @Test
    public void can_take_a_card(){
        player.takeACard(card);
        assertEquals(1, player.cardCount());
    }

    @Test
    public void can_give_back_card(){
        player.takeACard(card);
        assertEquals(1, player.getHand().size());
        player.emptyHand();
        assertEquals(0, player.getHand().size());
    }

//    @Test
//    public void can_get_card_value_back(){
//        player.takeACard(card);
//        assertEquals(3, player.getCardValue());
//    }
}
