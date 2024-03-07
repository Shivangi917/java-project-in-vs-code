package player;

public class Player {
    private String name;
    private char symbol;
    public void setPlayerDetails (String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return name;
    }
    public char getPlayerSymbol() {
        return symbol;
    }

    public void getPlayerDetails() {
        System.out.println("Player name: " + this.name);
        System.out.println("Player symbol: " + this.symbol);
    }
}
