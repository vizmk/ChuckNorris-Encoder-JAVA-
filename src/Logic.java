public class Logic {

    public String[] tabellar(String text) {
        String[] spaced = new String[text.length()];

        for (int i = 0; i < text.length(); i++) {
            spaced[i] = String.valueOf(text.charAt(i));
        }

        return spaced;
    }
}