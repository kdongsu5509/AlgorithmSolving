import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalCup = Integer.parseInt(br.readLine());

        int[] cupsInfos = new int[totalCup + 1];

        for (int i = 1; i <= totalCup; i++) {
            cupsInfos[i] = Integer.parseInt(br.readLine());
        }

        if (totalCup == 1) {
            System.out.println(cupsInfos[totalCup]);
            return;
        }

        int[] dp = new int[totalCup + 1];
        dp[0] = 0;
        dp[1] = cupsInfos[1];
        dp[2] = dp[1] + cupsInfos[2];

        for (int idx = 3; idx <= totalCup; idx++) {
            int nowCupVolume = cupsInfos[idx];
            int ein = dp[idx - 3] + cupsInfos[idx - 1] + nowCupVolume;
            int zwei = dp[idx - 2] + nowCupVolume;
            int drei = dp[idx - 1];

            dp[idx] = Math.max(Math.max(ein, zwei), drei);
        }

        System.out.println(dp[totalCup]);
    }
}