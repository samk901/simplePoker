import java.util.HashMap;

public class Utility {

    private final HashMap<String, Integer> valueHash = new HashMap<>() {{
        put("Two", 2);
        put("Three", 3);
        put("Four", 4);
        put("Five", 5);
        put("Six", 6);
        put("Seven", 7);
        put("Eight", 8);
        put("Nine", 9);
        put("Ten", 10);
        put("Jack", 11);
        put("Queen", 12);
        put("King", 13);
        put("Ace", 14);
    }};

    public Utility() {
    }

    public HashMap<String, Integer> getValueHash() {
        return this.valueHash;
    }

}
