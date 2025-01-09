import java.io.*;
import java.util.*;

// BJ_250109_3273
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine().trim());
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.valueOf(br.readLine().trim());

        // 배열 정렬
        Arrays.sort(array);

        // pointer 선언
        int left = 0;
        int right = n - 1;

        int possibleCnt = 0;
        if (right == 0) {
            if (array[left] == target)
                possibleCnt += 1;

            System.out.println(possibleCnt);
            return;
        }

        while (left < right) {
            int sum = array[left] + array[right];

            if (sum > target) {
                right -= 1;
            } else {
                if (sum == target) {
                    possibleCnt += 1;
                }
                left += 1;
            }
        }

        System.out.println(possibleCnt);
    }
}