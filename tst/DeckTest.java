import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeckTest {

    @Test
    public void testEmptyDeck() {
        Deck testDeck = new Deck();
        Assertions.assertEquals(0, testDeck.getNumberOfCardsRemaining());
    }

    @Test
    public void testFilledDeck() {
        Deck testDeck = new Deck();
        testDeck.fillDeck();
        Assertions.assertEquals(52, testDeck.getNumberOfCardsRemaining());
    }

    @Test
    public void testShuffledDeck() {
        Deck unshuffledDeck = new Deck();
        unshuffledDeck.fillDeck();

        Deck shuffledDeck = new Deck();
        shuffledDeck.fillDeck();
        shuffledDeck.shuffleDeck();

        Assertions.assertNotEquals(unshuffledDeck, shuffledDeck);
    }

    @Test
    public void testDealSingleCard() {

    }

    @Test
    public void testDealMultipleCards() {

    }

    @Test
    public void testDealAllCards() {

    }
}