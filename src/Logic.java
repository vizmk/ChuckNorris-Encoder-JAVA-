public class Logic {


    public String encode(String text) {

        if (text == null || text.isEmpty()) {
            return "";
        }


        StringBuilder bitsBuilder = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int ascii = c;

            String bin = Integer.toBinaryString(ascii);

            // Padding a 7 bit
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
            char bit = bits.charAt(i);

            if (bit == currentBit) {
                count++;
            } else {
                if (out.length() > 0) {
                    out.append(" ");
                }

                out.append(buildBlock(currentBit, count));

                currentBit = bit;
                count = 1;
            }
        }

        // Aggiunta dell’ultimo gruppo
        if (out.length() > 0) {
            out.append(" ");
        }
        out.append(buildBlock(currentBit, count));

        return out.toString();
    }


    private String buildBlock(char bit, int count) {

        StringBuilder block = new StringBuilder();

        // Prefisso
        if (bit == '1') {
            block.append("0");
        } else {
            block.append("00");
        }

        block.append(" ");

        // Sequenza di zeri
        for (int i = 0; i < count; i++) {
            block.append("0");
        }

        return block.toString();
    }
}
