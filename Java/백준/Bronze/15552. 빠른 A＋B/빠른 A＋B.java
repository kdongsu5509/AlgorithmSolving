import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            int sum = (int)Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).sum();
            bw.append(sum + "\n");
        }

        bw.flush();
    }
}
