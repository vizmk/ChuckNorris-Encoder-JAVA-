import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();

        System.out.println("Input String:");
        String text = scanner.nextLine();

        String[] result = logic.tabellar(text);

        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}
