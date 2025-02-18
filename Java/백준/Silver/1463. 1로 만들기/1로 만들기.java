import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        // DP 배열 초기화 (ArrayList 대신 Array 사용)
        int[] dp = new int[x + 1];
        dp[1] = 0; // 1은 0번 연산으로 1이 됨

        for (int idx = 2; idx <= x; idx++) {
            // 기본적으로 -1 연산
            dp[idx] = dp[idx - 1] + 1;

            // 2로 나눌 수 있을 때 최소 연산 횟수 갱신
            if (idx % 2 == 0) {
                dp[idx] = Math.min(dp[idx], dp[idx / 2] + 1);
            }

            // 3으로 나눌 수 있을 때 최소 연산 횟수 갱신
            if (idx % 3 == 0) {
                dp[idx] = Math.min(dp[idx], dp[idx / 3] + 1);
            }
        }

        System.out.println(dp[x]);  // 결과 출력
    }
}
