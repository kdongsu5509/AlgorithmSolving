import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            String temp = br.readLine();
            int finalIdx = temp.length() - 1;

            StringBuilder sb = new StringBuilder();
            sb.append(temp.charAt(0));
            sb.append(temp.charAt(finalIdx));
            System.out.println(sb);
        }
    }
}
