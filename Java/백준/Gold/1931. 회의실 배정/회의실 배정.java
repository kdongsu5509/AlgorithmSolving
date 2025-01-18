import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 종료 시간을 기준으로 정렬, 종료 시간이 같다면 시작 시간을 기준으로 정렬
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int count = 0;
        int lastEndTime = 0;

        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= lastEndTime) {
                count++;
                lastEndTime = meetings[i][1];
            }
        }

        System.out.println(count);
    }
}
