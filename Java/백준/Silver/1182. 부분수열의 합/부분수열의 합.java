import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력 받기
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int S = Integer.parseInt(firstLine[1]);

        int[] sequence = Arrays.stream(br.readLine().split(" "))
                               .mapToInt(Integer::parseInt)
                               .toArray();

        int count = 0;

        // 부분수열 탐색 (반복문으로 직접 구현)
        List<Integer> sums = new ArrayList<>();
        sums.add(0); // 초기값: 공집합의 합

        for (int num : sequence) {
            int size = sums.size();
            for (int i = 0; i < size; i++) {
                sums.add(sums.get(i) + num);
            }
        }

        // 원하는 합 찾기
        for (int sum : sums) {
            if (sum == S) {
                count++;
            }
        }

        // 공집합 제외
        if (S == 0) count--;

        System.out.println(count);
    }
}
