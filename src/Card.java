import java.util.HashMap;

public class Card {

    private final CardShape shape;
    private final CardValue value;
    private final HashMap<String, Integer> valueHash = new Utility().getSingleCardValueHash();

    public Card(CardShape shape, CardValue value) {
        this.shape = shape;
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value.toString() + " " + this.shape.toString();
    }

    public String isMyCardBetter(Card otherCard) {
        if (this.value == otherCard.value) {
            return "equal";
        } else if (valueHash.get(this.value.toString()) > valueHash.get(otherCard.value.toString())) {
            return "better";
        } else {
            return "worse";
        }
    }

    public CardShape getCardShape() {
        return this.shape;
    }

    public CardValue getCardValue() {
        return this.value;
    }


}
