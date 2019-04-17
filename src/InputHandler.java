import java.util.Scanner;

public class InputHandler {
private  static Scanner in = new Scanner(System.in);
    public static String correctInput(){
        String input =in.nextLine();
        while (!input.matches("\\d+") || Integer.parseInt(input)<0) {
            System.out.println("input must be a number, try again");
            input = in.nextLine();

        }
        return input;
    }
}
