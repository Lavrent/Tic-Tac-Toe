import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Input the size of the board");
        int num_size = Integer.parseInt(InputHandler.correctInput());
        System.out.println("Input the winning condition(how many marks in a row)");
        int num_cond = Integer.parseInt(InputHandler.correctInput());
        while (num_cond<1 || num_cond>num_size)
        {
            System.out.println("winning condition must be postive or in range of board size");
            num_cond = Integer.parseInt(InputHandler.correctInput());
        }
        Board board = new Board(num_size,num_cond);
        board.play();
    }
}

