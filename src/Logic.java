public class Logic {


    public String encode(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }


        StringBuilder bitsBuilder = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int ascii = text.charAt(i);
            String bin = Integer.toBinaryString(ascii);

            // padding a 7 bit
            while (bin.length() < 7) {
                bin = "0" + bin;
            }
            bitsBuilder.append(bin);
        }

        String bits = bitsBuilder.toString();


        StringBuilder out = new StringBuilder();
        char currentBit = bits.charAt(0);
        int count = 1;

        for (int i = 1; i < bits.length(); i++) {
            char b = bits.charAt(i);
            if (b == currentBit) {
                count++;
            } else {
                appendBlock(out, currentBit, count);
                currentBit = b;
                count = 1;
            }
        }

        // chiudo anche l'ultimo gruppo
        appendBlock(out, currentBit, count);

        return out.toString();
    }


    public String decode(String encoded) {
        if (encoded == null || encoded.trim().isEmpty()) {
            return "";
        }

        String[] parts = encoded.trim().split("\\s+");

        // Unary -> bit string (0/1)
        StringBuilder bits = new StringBuilder();
        for (int i = 0; i < parts.length; i += 2) {
            String prefix = parts[i];
            String zeros = parts[i + 1];

            char bitValue = "0".equals(prefix) ? '1' : '0'; // "0"->1, "00"->0

            for (int k = 0; k < zeros.length(); k++) {
                bits.append(bitValue);
            }
        }

        // Bit string -> testo (blocchi da 7)
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < bits.length(); i += 7) {
            String chunk = bits.substring(i, i + 7);
            int ascii = Integer.parseInt(chunk, 2);
            result.append((char) ascii);
        }

        return result.toString();
    }


    public boolean isValidEncoded(String encoded) {
        if (encoded == null) {
            return false;
        }

        String trimmed = encoded.trim();
        if (trimmed.isEmpty()) {
            return false;
        }

        // (1) solo '0' e spazi
        for (int i = 0; i < trimmed.length(); i++) {
            char ch = trimmed.charAt(i);
            if (ch != '0' && ch != ' ') {
                return false;
            }
        }

        String[] parts = trimmed.split("\\s+");

        // (2) numero blocchi pari
        if (parts.length % 2 != 0) {
            return false;
        }

        int totalBits = 0;

        for (int i = 0; i < parts.length; i += 2) {
            String prefix = parts[i];
            String zeros = parts[i + 1];

            // (3) prefissi validi
            if (!"0".equals(prefix) && !"00".equals(prefix)) {
                return false;
            }

            // (4) secondo blocco: solo zeri e non vuoto
            if (zeros.isEmpty()) {
                return false;
            }
            for (int k = 0; k < zeros.length(); k++) {
                if (zeros.charAt(k) != '0') {
                    return false;
                }
            }

            totalBits += zeros.length();
        }

        // (5) multiplo di 7
        return totalBits % 7 == 0;
    }

    // Aggiunge un blocco unary al risultato (gestendo correttamente gli spazi)
    private void appendBlock(StringBuilder out, char bit, int count) {
        if (out.length() > 0) {
            out.append(" ");
        }
        out.append(buildBlock(bit, count));
    }

    // Costruisce un singolo blocco unary per una sequenza di bit uguali
    private String buildBlock(char bit, int count) {
        String prefix = (bit == '1') ? "0" : "00";

        StringBuilder block = new StringBuilder();
        block.append(prefix).append(" ");

        for (int i = 0; i < count; i++) {
            block.append("0");
        }

        return block.toString();
    }
}