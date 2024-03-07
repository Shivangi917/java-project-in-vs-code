package game;

import java.util.Scanner;
import player.Player;
import board.Board;

public class Game {
    Player [] players;
    Board board;
    int turn;
    int noOfMoves;
    boolean gameOver;
    String zero;
    String cross;

    public Game(Player [] players, Board board) {
        this.players = players;
        this.board = board;
        this.turn = 0;
        this.noOfMoves = 0;
        this.gameOver = false;
        StringBuilder z = new StringBuilder();
        StringBuilder c = new StringBuilder();

        int size = this.board.size;
        for(int i = 0; i < size; i++) {
            z.append('O');
            c.append('X');
        }

        this.zero = z.toString();
        this.cross = c.toString();
    }

    public void printBoardConfig() {
        int size = this.board.size;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                System.out.print(board.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void play() {
        print();
        int size = this.board.size;
        while(!gameOver) {
            //System.out.print(noOfMoves + " " + checkCombinations());
            noOfMoves++;
            int idx = getIndex();

            int row = idx / size; 
            int col = idx % size;

            board.matrix[row][col] = players[turn].getPlayerSymbol();
            if(noOfMoves == size * size) {
                System.out.println("Game Draw");
            }
            if(noOfMoves >= 2 * size - 1 && checkCombinations() == true) {
                gameOver = true;
                print();
                System.out.println("Winner is: " + players[turn].getPlayerName());
                return;
            }

            turn = (turn + 1) % 2;
            print();
        }
    }
    public void print() {
        printBoardConfig();
    }

    public int getIndex() {
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.print("Player: " + players[turn].getPlayerName() + "\nEnter position: ");
            int pos = scn.nextInt();
    
            int size = this.board.size;
            int row = pos / size;
            int col = pos % size;
    
            if (row >= size || col >= size) {
                System.out.println("Invalid position");
                continue;
            }
    
            if (board.matrix[row][col] != '#') {
                System.out.println("Position already occupied");
                continue;
            }
    
            scn.close();
            return pos;
        }
    }
    

    public boolean checkCombinations() {
        int size = this.board.size;
        for(int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < size; j++) {
                sb.append(board.matrix[i][j]);
            }
            //System.out.print(zero + " " + cross);
            String pattern = sb.toString();

            if(pattern.equals(zero) || pattern.equals(cross)) {
                return true;
            }
        }

        for(int i = 0; i < size; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < size; j++) {
                sb.append(board.matrix[j][i]);
            }

            String pattern = sb.toString();

            if(pattern.equals(zero) || pattern.equals(cross)) {
                return true;
            }
        }

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder(); 
        while(i < size) {
            sb.append(board.matrix[i][j]);
            i++;
            j++;
        }
        String pattern = sb.toString();

        if(pattern.equals(zero) || pattern.equals(cross)) {
            return true;
        }

        i = 0;
        j = size - 1;
        StringBuilder sb1 = new StringBuilder();        
        while(i < size) {
            sb1.append(board.matrix[i][j]);
            
            i++;
            j--;
        }
        pattern = sb1.toString();

        if(pattern.equals(zero) || pattern.equals(cross)) {
            return true;
        }

        return false;
    }
}
