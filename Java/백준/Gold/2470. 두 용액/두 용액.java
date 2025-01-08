import java.io.*;
import java.util.*;

//BJ_250108_2470
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        // 1. 입력과 동시에 정렬 -> 시간 복잡도 : 500,000
        int[] arrays = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.parallelSort(arrays);

        int right = cnt - 1;
        int left = 0;

        int min = Integer.MAX_VALUE;
        int absMin = Math.abs(min);

        List<Integer> store = new ArrayList<>();

        while (left < right) {
            // 새로운 값의 합 연산
            int addResult = arrays[left] + arrays[right];

            // 이전 기록 갱신 여부 확인
            int absAddResult = Math.abs(addResult);
            if (absMin > absAddResult) {
                min = addResult;
                absMin = absAddResult;
                store.clear();
                store.add(arrays[left]);
                store.add(arrays[right]);
            }

            if (addResult == 0) {
                break;
            } else if (addResult < 0) {
                ++left;
            } else {
                --right;
            }
        }

        System.out.println(store.get(0) + " " + store.get(1));

    }
}
