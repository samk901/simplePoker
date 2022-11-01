
public class Main {

    public static void main(String[] args) throws DeckException {
        Deck deck = new Deck();

        try {
            deck.deal();
        } catch (DeckException e) {
            e.printStackTrace();
        }
    }
}
