import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();

        // Lettura input
        System.out.println("Input string:");
        String text = scanner.nextLine();

        // Codifica con Chuck Norris Unary Code
        String encoded = logic.encode(text);

        // Output finale
        System.out.println("The result:");
        System.out.println(encoded);
    }
}


