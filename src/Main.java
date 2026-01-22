import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Logic logic = new Logic();

        System.out.println("Input String:");
        String text = scanner.nextLine();

        System.out.println("the Result:");
        String[] result = logic.tabellar(text);
        for (String s : result) {
            char c = s.charAt(0);
            int ascii = c;

            String bin = Integer.toBinaryString(ascii);

            while (bin.length() < 7) {
                bin = "0" + bin;
            }

            System.out.println(s + " = " + bin);
        }

    }
}




