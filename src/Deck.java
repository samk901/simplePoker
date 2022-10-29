import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> remainingCards;
    private boolean shuffled;
    private boolean complete;

    public Deck() {
        this.remainingCards = new ArrayList<Card>();
        this.shuffled = false;
        this.complete = true;
    }
}
