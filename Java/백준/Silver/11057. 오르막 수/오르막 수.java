import java.util.*;
import java.io.*;

public class Main {

    private static long previousSum = 0;
    private static long curenntSum = 0;
    private static int MOD = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();

        long[][] dp = new long[size + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
            previousSum += 1;
        }

        if (size == 1) {
            System.out.println(10);
            return;
        }

        for (int a = 2; a <= size; a++) {
            curenntSum = 0;
            for (int b = 0; b < 10; b++) {
                for (int c = 0; c <= b; c++) {
                    dp[a][b] = (dp[a][b] + dp[a - 1][c]) % MOD;
                }
            }
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[size][i]) % MOD;
        }

        System.out.println(result);
    }
}
