import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    Scanner in = new Scanner(System.in);
    private int col_pos;
    private int row_pos;

    public void setRow_Pos() {
        System.out.println("Type where do you want to put the mark(row,col)");
        this.row_pos =in.nextInt();
    }

    public void setCol_Pos() {
        this.col_pos = in.nextInt();
    }

    public int getRow_Pos() {
        return this.row_pos;
    }

    public int getCol_Pos() {
        return this.col_pos;
    }
}

