import board.Board;
import player.Player;
import game.Game;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        Board b = new Board(3, '#');
        b.printBoardConfig();

        Player p1 = new Player();
        p1.setPlayerDetails("Luna", 'X');

        Player p2 = new Player();
        p2.setPlayerDetails("Kalix", 'O');
        
        p1.getPlayerDetails();

        Game g = new Game(new Player[] {p1, p2}, b);
        g.play();
    }

}
