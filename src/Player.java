import java.util.Scanner;

public class Player {
    Scanner in = new Scanner(System.in);
    private int col_pos;
    private int row_pos;

    public void setRow_Pos() {
        System.out.println("Type where do you want to put the mark(row)");
        this.row_pos = Integer.parseInt(InputHandler.correctInput());
    }

    public void setCol_Pos() {
        System.out.println("Type where do you want to put the mark(col)");
        this.col_pos = Integer.parseInt(InputHandler.correctInput());
    }

    public int getRow_Pos() {
        return row_pos;
    }

    public int getCol_Pos() {
        return col_pos;
    }
}

