import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        int num_size=InputHandler.getSize();
        int num_cond= InputHandler.getCondition(num_size);
        Board board = new Board(num_size,num_cond);
        board.play();
    }

}

