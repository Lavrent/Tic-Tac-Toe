import java.util.Scanner;

public class Player {
    Scanner in = new Scanner(System.in);
    private int col_pos;
    private int row_pos;

    public void setRow_Pos(int size) {
        System.out.println("Type where do you want to put the mark(row)");
        this.row_pos = Integer.parseInt(InputHandler.correctInput());
        if (row_pos >= size || row_pos < 0) {
            System.out.println("row position is out of bounds, please try again");
           this.setCol_Pos(size);
        }
    }

    public void setCol_Pos(int size) {
        System.out.println("Type where do you want to put the mark(col)");
        this.col_pos = Integer.parseInt(InputHandler.correctInput());
        if (col_pos >= size || col_pos < 0) {
            System.out.println("col position is out of bounds, please try again");
           this.setCol_Pos(size);
        }
    }

    public int getRow_Pos() {
        return row_pos;
    }

    public int getCol_Pos() {
        return col_pos;
    }
}

