import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> remainingCards;
    private List<Card> burnPile;
    private boolean shuffled;

    public Deck() {
        this.remainingCards = new ArrayList<Card>();
        this.burnPile = new ArrayList<Card>();
        this.shuffled = false;
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
    }

    protected void shuffleDeck() {
        Collections.shuffle(this.remainingCards);
    }

    public Card deal() throws DeckException {

        if (this.remainingCards.size() == 0) {
            throw new DeckException("Deck is empty");
        }

        Card card = this.remainingCards.get(0);
        this.remainingCards.remove(0);
        return card;
    }

    public void burn() throws DeckException {
        if (this.remainingCards.size() == 0) {
            throw new DeckException("Deck is empty");
        }

        Card card = this.remainingCards.get(0);
        this.burnPile.add(card);
        this.remainingCards.remove(0);
    }

    public List<Card> getRemainingCards() {
        return this.remainingCards;
    }

}
