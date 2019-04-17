import java.util.Scanner;

public class Board {
    private int size;
    private String[][] board;
    Player x_player = new Player();
    Player o_player = new Player();
    Player currentPlayer = new Player();
    private int player1_steps = 0;
    private int player2_steps = 0;


    public Board(int size) {
        this.size = size;
        board = new String[size][size];
        initializeBoard(); // in order to not have a nullPointerException
    }

    public void play() {

        System.out.println("X's turn");
        currentPlayer = x_player;
        makeMove("X");
        player1_steps++;
        while (!isFinished()) {
            changeplayer();
        }
        checkForResult();
        System.out.println("Number of steps for player1 - " + player1_steps);
        System.out.println("Number of steps for player2 - " + player2_steps);
    }

    private void checkForResult() {
        if (wins("X")) {
            System.out.println("x_player wins");
        } else if (wins("O")) {
            System.out.println("O_player wins");
        } else if (isTie())
            System.out.println("It's a tie");
    }

    public void changeplayer() {
        if (currentPlayer.equals(x_player)) {
            currentPlayer = o_player;
            System.out.println("O's turn");
            makeMove("O");
            player2_steps++;

        } else if (currentPlayer.equals(o_player)) {
            currentPlayer = x_player;

            System.out.println("X's turn");
            makeMove("X");
            player1_steps++;
        }
    }

    public void makeMove(String mark) {  // mark is "X" or "O"
        currentPlayer.setRow_Pos();
        currentPlayer.setCol_Pos();
        if (currentPlayer.getRow_Pos() > size || currentPlayer.getRow_Pos()<0) {
            System.out.println("row position is out of bounds, please try again");
            makeMove(mark);
        }
        if (currentPlayer.getCol_Pos() > size || currentPlayer.getCol_Pos()<0) {
            System.out.println("col position is out of bounds, please try again");
            makeMove(mark);
        }
        if (board[currentPlayer.getRow_Pos()][currentPlayer.getCol_Pos()].trim().isEmpty())
            board[currentPlayer.getRow_Pos()][currentPlayer.getCol_Pos()] = mark;
        else {
            System.out.println("This cell is full");
            makeMove(mark); // we use recursion here in order to avoid rewriting already filled cell
        }
        printBoard();
    }

    public boolean wins(String mark) {
        int row_count, col_count, diagonal_count, reverse_diagonal_count;

        //row check
        for (int row = 0; row < size; row++) {
            col_count = 0;
            for (int col = 0; col < size; col++) {
                if (board[row][col].equals(mark))
                    col_count++;
            }
            if (col_count == size)
                return true;
        }

        //column check
        for (int col = 0; col < size; col++) {
            row_count = 0;
            for (int row = 0; row < size; row++) {
                if (board[row][col].equals(mark))
                    row_count++;
            }
            if (row_count == size)
                return true;
        }

        //diagonal check
        diagonal_count = 0;
        for (int row = 0; row < size; row++) {
            if (board[row][row].equals(mark))
                diagonal_count++;
        }
        if (diagonal_count == size)
            return true;

        //reverse diagonal_check
        reverse_diagonal_count = 0;
        for (int row = 0; row < size; row++) {
            if (board[row][size - 1 - row].equals(mark))
                reverse_diagonal_count++;
        }
        return reverse_diagonal_count == size;

    }

    public boolean isTie() {
        return !wins("X") && !wins("O") && isFull(board);

    }

    public boolean isFinished() {
        return wins("X") || wins("O") || isTie();

    }

    private boolean isFull(String[][] board) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].equals("O") || board[i][j].equals("X"))
                    count++;
            }
        }
        return count == size * size;

    }

    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = " ";
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < size + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("|");
        }

        for (int i = 0; i < size + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
