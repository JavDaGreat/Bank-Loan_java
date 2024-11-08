import java.util.Scanner;

public class Console {
    public static double readInput(String prompt, double min, double max) {
        Scanner input = new Scanner(System.in);
        double value;

        while (true) {
            System.out.print(prompt);
            value = input.nextFloat();
            if (value >= min && value <= max) {
                break;
            }
            System.out.println("Please enter a value between " + min + " and " + max + ".");
        }
        return value;

    }

}
