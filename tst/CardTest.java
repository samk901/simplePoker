import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardTest {

    private Deck deck;
    private Card aceOfHearts;
    private Card aceOfClubs;
    private Card twoOfSpades;
    private Card nineOfSpades;

    @BeforeEach
    public void setup() {
        this.deck = new Deck();
        deck.shuffleDeck();
        this.aceOfHearts = new Card(CardShape.HEARTS, CardValue.ACE);
        this.aceOfClubs = new Card(CardShape.CLUBS, CardValue.ACE);
        this.twoOfSpades = new Card(CardShape.SPADES, CardValue.TWO);
        this.nineOfSpades = new Card(CardShape.SPADES, CardValue.NINE);
    }

    @Test
    public void testEquality() {
        Assertions.assertEquals("equal", this.aceOfHearts.isMyCardBetter(aceOfClubs));
        Assertions.assertEquals("better", this.aceOfClubs.isMyCardBetter(twoOfSpades));
        Assertions.assertEquals("better", this.aceOfClubs.isMyCardBetter(nineOfSpades));
        Assertions.assertEquals("worse", this.twoOfSpades.isMyCardBetter(nineOfSpades));
        Assertions.assertEquals("worse", this.twoOfSpades.isMyCardBetter(aceOfClubs));
    }

    @Test
    public void testPrintingFormat() {
        Assertions.assertEquals("ACE HEARTS", this.aceOfHearts.toString());
        Assertions.assertEquals("ACE CLUBS", this.aceOfClubs.toString());
        Assertions.assertEquals("TWO SPADES", this.twoOfSpades.toString());
        Assertions.assertEquals("NINE SPADES", this.nineOfSpades.toString());
    }


}