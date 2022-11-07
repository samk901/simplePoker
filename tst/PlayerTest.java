import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PlayerTest {

    public Player player = new Player("Sam", 1000);
    public Deck deck;
    private Card aceOfHearts;
    private Card aceOfClubs;
    private Card twoOfSpades;
    private Card nineOfSpades;

    @BeforeEach
    public void setup() {
        this.deck = new Deck();
        this.deck.shuffleDeck();
        this.aceOfHearts = new Card(CardShape.HEARTS, CardValue.ACE);
        this.aceOfClubs = new Card(CardShape.CLUBS, CardValue.ACE);
        this.twoOfSpades = new Card(CardShape.SPADES, CardValue.TWO);
        this.nineOfSpades = new Card(CardShape.SPADES, CardValue.NINE);
    }

    @Test
    public void getAttributes() {
        Assertions.assertEquals(this.player.getPlayerName(), "Sam");
    }

    @Test
    public void getChipTotal() {
        Assertions.assertEquals(1000, this.player.getPlayerChipTotal());
        this.player.addChips(1000);
        Assertions.assertEquals(2000, this.player.getPlayerChipTotal());
        this.player.subtractChips(1);
        Assertions.assertEquals(1999, this.player.getPlayerChipTotal());
        this.player.subtractChips(1999);
        Assertions.assertEquals(0, this.player.getPlayerChipTotal());
        Assertions.assertFalse(this.player.getPlayerHasChips());
    }

    @Test
    @SneakyThrows
    public void getPlayerHand() {
        Assertions.assertEquals(0, this.player.getPlayerHand().size());
        this.player.addCardToHand(this.aceOfClubs);
        Assertions.assertEquals(1, this.player.getPlayerHand().size());
        this.player.addCardToHand(this.aceOfHearts);
        Assertions.assertEquals(2, this.player.getPlayerHand().size());

        ArrayList<Card> currentHand = this.player.getPlayerHand();
        Assertions.assertEquals(this.aceOfClubs, currentHand.get(0));
        Assertions.assertEquals(this.aceOfHearts, currentHand.get(1));

    }

    @Test
    @SneakyThrows
    public void addToFullHandThrowsHandException() {
        this.player.addCardToHand(this.aceOfHearts);
        this.player.addCardToHand(this.twoOfSpades);
        Assertions.assertThrows(HandException.class, () -> this.player.addCardToHand(this.nineOfSpades));
    }

    @Test
    @SneakyThrows
    public void clearHand() {
        this.player.addCardToHand(this.aceOfHearts);
        this.player.addCardToHand(this.twoOfSpades);
        ArrayList<Card> currentHand = this.player.getPlayerHand();
        Assertions.assertEquals(2, currentHand.size());

        currentHand = this.player.getPlayerHand();
        this.player.resetPlayerHand();
        Assertions.assertEquals(0, currentHand.size());
    }

}
