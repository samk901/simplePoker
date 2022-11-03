import java.util.HashMap;

public class Utility {

    private final HashMap<String, Integer> SINGLE_CARD_VALUE_HASH = new HashMap<>() {{
        put("TWO", 2);
        put("THREE", 3);
        put("FOUR", 4);
        put("FIVE", 5);
        put("SIX", 6);
        put("SEVEN", 7);
        put("EIGHT", 8);
        put("NINE", 9);
        put("TEN", 10);
        put("JACK", 11);
        put("QUEEN", 12);
        put("KING", 13);
        put("ACE", 14);
    }};

    private final HashMap<String, Integer> HAND_RANKING_VALUE_HASH = new HashMap<>() {{
        put("HIGH_CARD", 1);
        put("TWO_PAIR", 2);
        put("TRIPLES", 3);
        put("STRAIGHT", 4);
        put("FLUSH", 5);
        put("FULL_HOUSE", 6);
        put("FOUR_OF_A_KIND", 7);
        put("STRAIGHT_FLUSH", 8);
        put("ROYAL_FLUSH", 9);
    }};

    public Utility() {
    }

    public HashMap<String, Integer> getSingleCardValueHash() {
        return this.SINGLE_CARD_VALUE_HASH;
    }

    public HashMap<String, Integer> getHandRankingValueHash() {
        return this.HAND_RANKING_VALUE_HASH;
    }

}
