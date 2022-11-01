import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeckTest {

    public Deck testDeck;

    @BeforeEach
    public void setup() {
        testDeck = new Deck();
    }

    @Test
    public void testEmptyDeck() {
        Deck testDeck = new Deck();
        Assertions.assertEquals(0, testDeck.getNumberOfCardsRemaining());
    }

    @Test
    public void testFilledDeck() {
        testDeck.fillDeck();
        Assertions.assertEquals(52, testDeck.getNumberOfCardsRemaining());
    }

    @Test
    @SneakyThrows
    public void testShuffledDeck() {
        Deck unshuffledDeck = new Deck();
        unshuffledDeck.fillDeck();

        Deck shuffledDeck = new Deck();
        shuffledDeck.fillDeck();
        shuffledDeck.shuffleDeck();

        Assertions.assertNotEquals(unshuffledDeck, shuffledDeck);
    }

    @Test
    @SneakyThrows
    public void dealThrowsDeckException() {
        Assertions.assertThrows(DeckException.class, () -> testDeck.deal());
    }

    @Test
    @SneakyThrows
    public void testDealSingleCard() {
        testDeck.deal();
    }

    @Test
    public void testDealMultipleCards() {

    }

    @Test
    public void testDealAllCards() {

    }
}