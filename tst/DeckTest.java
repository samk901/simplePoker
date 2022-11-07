import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeckTest {

    private Deck testDeck;
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
        testDeck.fillDeck();
        Card card = testDeck.deal();
        Assertions.assertEquals(51, testDeck.getNumberOfCardsRemaining());
        Assertions.assertInstanceOf(Card.class, card);
    }

    @Test
    @SneakyThrows
    public void testDealMultipleCards() {
        testDeck.fillDeck();
        testDeck.shuffleDeck();
        Card card1 = testDeck.deal();
        Card card2 = testDeck.deal();
        Card card3 = testDeck.deal();
        Card card4 = testDeck.deal();
        Card card5 = testDeck.deal();

        Assertions.assertEquals(47, testDeck.getNumberOfCardsRemaining());
//        System.out.println("Card1 is " + card1.toString());
//        System.out.println("Card2 is " + card2.toString());
//        System.out.println("Card3 is " + card3.toString());
//        System.out.println("Card4 is " + card4.toString());
//        System.out.println("Card5 is " + card5.toString());
    }

    @Test
    @SneakyThrows
    public void testBurnCard() {
        testDeck.fillDeck();
        testDeck.burn();
        Assertions.assertEquals(51, this.testDeck.getNumberOfCardsRemaining());
        testDeck.burn();
        Assertions.assertEquals(50, this.testDeck.getNumberOfCardsRemaining());
    }

    @Test
    public void testBurnCardThrowsDeckException() {
        Assertions.assertThrows(DeckException.class, () -> testDeck.burn());
    }
}