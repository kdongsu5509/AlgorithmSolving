import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lineCnt = Integer.parseInt(br.readLine());
        long totalLength = 0;

        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < lineCnt; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            intervals.add(new int[] { start, end });
        }

        // 시작점을 기준으로 정렬 (시작점이 같다면 끝점을 기준으로 정렬)
        intervals.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        // 병합 과정
        int start = intervals.get(0)[0];
        int end = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            int currentStart = intervals.get(i)[0];
            int currentEnd = intervals.get(i)[1];

            if (currentStart > end) { // 겹치지 않는 경우
                totalLength += (end - start);
                start = currentStart;
                end = currentEnd;
            } else { // 겹치는 경우
                end = Math.max(end, currentEnd);
            }
        }
        totalLength += (end - start);

        System.out.println(totalLength);
    }
}
