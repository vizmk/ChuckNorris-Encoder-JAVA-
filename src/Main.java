import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();

        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            String op = scanner.nextLine().trim();

            switch (op) {
                case "encode":
                    System.out.println("Input string:");
                    String plain = scanner.nextLine();
                    String encoded = logic.encode(plain);

                    System.out.println("Encoded string:");
                    System.out.println(encoded);
                    break;

                case "decode":
                    System.out.println("Input encoded string:");
                    String encodedInput = scanner.nextLine();

                    // Se non valido, stampa il messaggio richiesto che contiene "not valid"
                    if (!logic.isValidEncoded(encodedInput)) {
                        System.out.println("Encoded string is not valid.");
                        break;
                    }

                    String decoded = logic.decode(encodedInput);
                    System.out.println("Decoded string:");
                    System.out.println(decoded);
                    break;

                case "exit":
                    System.out.println("Bye!");
                    return;

                default:
                    System.out.println("There is no '" + op + "' operation");
                    break;
            }
        }
    }
}
