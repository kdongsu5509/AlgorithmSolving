import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine()); // 로프의 개수
        List<Integer> ropes = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }

        // 내림차순 정렬 (무거운 중량부터 시도)
        ropes.sort(Collections.reverseOrder());

        int maxWeight = 0;

        for (int i = 0; i < cnt; i++) {
            // 현재 로프와 병렬로 사용할 로프 수: i + 1개
            int weight = ropes.get(i) * (i + 1);
            maxWeight = Math.max(maxWeight, weight);
        }

        System.out.println(maxWeight);
    }
}
