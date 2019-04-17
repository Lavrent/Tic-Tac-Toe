import java.util.Scanner;

public class Play {
    public static void main(String[] args) {
        System.out.println("Input board size");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        Board board = new Board(size);
        board.play();
    }
}
