import java.util.ArrayList;

public class Player {

    private String playerName;
    private int chipTotal;
    private ArrayList<Card> playerHand;
    private boolean hasChips;

    public Player(String name, int chipTotal) {
        this.playerName = name;
        this.chipTotal = chipTotal;
        this.playerHand = new ArrayList<>();
        this.hasChips = true;
    }

    public void addCardToHand(Card card) throws HandException {
        if (this.playerHand.size() == 2) {
            throw new HandException("Hand is full");
        } else {
            this.playerHand.add(card);
        }
    }

    public void resetPlayerHand() {
        this.playerHand.clear();
    }

    public ArrayList<Card> getPlayerHand() {
        return this.playerHand;
    }

    public int getPlayerChipTotal() {
        return this.chipTotal;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public boolean getPlayerHasChips() {
        return this.hasChips;
    }

    public void addChips(int chips) {
        this.chipTotal += chips;
    }

    public void subtractChips(int chips) {
        int chipTotal = this.chipTotal - chips;
        if (chipTotal <= 0) {
            System.out.println("Player " + this.playerName + " has lost all of their chips.");
            this.hasChips = false;
            this.chipTotal = 0;
        } else {
            this.chipTotal = chipTotal;
        }
    }
}
