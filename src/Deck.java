import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> remainingCards;
    private boolean shuffled;
    private boolean complete;

    public Deck() {
        this.remainingCards = new ArrayList<Card>();
        this.shuffled = false;
        this.complete = false;
    }

    public int getNumberOfCardsRemaining() {
        return this.remainingCards.size();
    }
    protected void fillDeck() {
        for (CardShape shape: CardShape.values()) {
            for (CardValue value: CardValue.values()) {
                Card card = new Card(shape, value);
                this.remainingCards.add(card);
            }
        }
        this.complete = true;
    }

    protected void shuffleDeck() {
        Collections.shuffle(this.remainingCards);
    }

    public Card deal() {
        Card card = this.remainingCards.get(0);
        this.remainingCards.remove(0);
        return card;
    }


}
