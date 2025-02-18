import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] stairs = new int[cnt + 1];
        int[] dp = new int[cnt + 1];

        stairs[0] = 0;
        dp[0] = 0;

        for (int i = 1; i <= cnt; i++) {
            stairs[i] = sc.nextInt();
        }

        dp[1] = stairs[1];
        if (cnt == 1) {
            System.out.println(dp[cnt]);
            return;
        }
        dp[2] = stairs[2] + dp[1];
        if (cnt == 2) {
            System.out.println(dp[cnt]);
            return;
        }

        for (int k = 3; k <= cnt; k++) {
            int oneMove = dp[k - 3] + stairs[k - 1] + stairs[k];
            int jumpMove = dp[k - 2] + stairs[k];
            dp[k] = Math.max(oneMove, jumpMove);
        }

        System.out.println(dp[cnt]);
    }
}
