import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    private Player player;
    private Card card;

    @Before
    public void before(){
        player = new Player();
        card = new Card(SuitType.HEARTS, FaceValueType.THREE);
    }

    @Test
    public void starts_with_no_cards(){
        assertEquals(null, player.getCard());
    }

    @Test
    public void can_take_a_card(){
        player.takeACard(card);
        assertEquals(card, player.getCard());
    }

    @Test
    public void can_give_back_card(){
        player.takeACard(card);
        assertEquals(card, player.giveBackCard());
    }
}
