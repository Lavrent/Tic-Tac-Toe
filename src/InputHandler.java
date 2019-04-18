import java.util.Scanner;

public class InputHandler {
    private static Scanner in = new Scanner(System.in);

    public static String correctInput() {
        String input = in.nextLine();
        while (!input.matches("\\d+") || Integer.parseInt(input) < 0 || input.trim().contains(" ")) {
            System.out.println("input must be a one digit positive number and contain no spaces try again");
            input = in.nextLine();
        }

        return input;
    }
    public static int getCondition(int size) {
        System.out.println("Input the winning condition(how many marks in a row)");
        int num_cond = Integer.parseInt(InputHandler.correctInput());
        while (num_cond < 1 || num_cond >size ) {
            System.out.println("winning condition must be postive or in range of board size");
            num_cond = Integer.parseInt(InputHandler.correctInput());
        }
        return num_cond;
    }

    public static int getSize(){
        System.out.println("Input the size of the board");
        int num_size = Integer.parseInt(InputHandler.correctInput());
        return num_size;
    }
}
