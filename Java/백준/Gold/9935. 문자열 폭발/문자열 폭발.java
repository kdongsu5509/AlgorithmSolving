import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String bomb = br.readLine();
        int bombLength = bomb.length();

        StringBuilder sb = new StringBuilder();

        for (char c : origin.toCharArray()) {
            sb.append(c);

            if (sb.length() >= bombLength) {
                boolean isBomb = true;

                for (int i = 0; i < bombLength; i++) {
                    if (sb.charAt(sb.length() - bombLength + i) != bomb.charAt(i)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    sb.setLength(sb.length() - bombLength);
                }
            }
        }

        if (sb.length() == 0)
            System.out.println("FRULA");
        else
            System.out.println(sb.toString());
    }
}
