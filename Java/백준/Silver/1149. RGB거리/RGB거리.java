import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int houseCount = Integer.parseInt(br.readLine());

        int[][] dp = new int[houseCount][3];

        // 첫 번째 집의 비용으로 dp 테이블 초기화

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0][0] = Integer.parseInt(st.nextToken()); // 빨강
        dp[0][1] = Integer.parseInt(st.nextToken()); // 초록
        dp[0][2] = Integer.parseInt(st.nextToken()); // 파랑

        for (int i = 1; i < houseCount; i++) {
            int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int r = costs[0];
            int g = costs[1];
            int b = costs[2];

            // i번째 집을 빨강으로 칠하는 최소 비용
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r;
            // i번째 집을 초록으로 칠하는 최소 비용
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g;
            // i번째 집을 파랑으로 칠하는 최소 비용
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b;
        }

        // 마지막 집을 칠하는 세 가지 경우 중 최솟값 출력
        System.out.println(Math.min(dp[houseCount - 1][0], Math.min(dp[houseCount - 1][1], dp[houseCount - 1][2])));
    }
}