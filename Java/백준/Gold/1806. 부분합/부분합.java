import java.util.*;
import java.io.*;

//BJ_250108_1806
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nUndm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> array = new ArrayList<>();
        array.add(0);
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(e -> array.add(e));

        int end = nUndm[0];
        int target = nUndm[1];

        int rangeSum = 0;
        int minLength = Integer.MAX_VALUE;

        int tail = 0;
        int head = 0;

        while (!(head == end & tail == end)) {
            if (head != end) {
                if (target > rangeSum) {
                    head += 1;
                    rangeSum += array.get(head);
                } else {
                    // 길이 비교
                    int localLenth = head - tail;
                    if (minLength > localLenth)
                        minLength = localLenth;
                    // tail 올리기
                    tail += 1;
                    rangeSum -= array.get(tail);
                }
            } else {
                if (target > rangeSum) {
                    tail = end; // 비교 가치 없다. 종료
                } else {
                    // 길이 비교
                    int localLenth = head - tail;
                    if (minLength > localLenth)
                        minLength = localLenth;
                    // tail 올리기
                    tail += 1;
                    rangeSum -= array.get(tail);
                }
            }
        }

        // 출력
        if (minLength == Integer.MAX_VALUE) {
            minLength = 0;
        }
        System.out.println(minLength);

    }
}
