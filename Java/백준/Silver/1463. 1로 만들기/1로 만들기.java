import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];

        dp[1] = 0; // 1은 0번의 연산으로 1이 됨

        for (int i = 2; i <= N; i++) {
            // 기본 연산: 1을 뺌
            dp[i] = dp[i - 1] + 1;
            
            // 2로 나누어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            
            // 3으로 나누어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
