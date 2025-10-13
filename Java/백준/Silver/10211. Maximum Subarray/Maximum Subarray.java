import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            int arraySize = Integer.parseInt(br.readLine());
            int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int maximunSubarrayResult = divideAndConquer(0, arraySize - 1, array);
            System.out.println(maximunSubarrayResult);
        }
    }

    private static int divideAndConquer(int left, int right, int[] array) {
        if (left == right) {
            return array[left];
        }

        int mid = (left + right) / 2;

        // 1. 왼쪽 부분 배열의 최대 합
        int leftResult = divideAndConquer(left, mid, array);

        // 2. 오른쪽 부분 배열의 최대 합
        int rightResult = divideAndConquer(mid + 1, right, array);

        // 3. 가운데를 가로지르는 최대 합
        int leftMaxValue = Integer.MIN_VALUE;
        int totalSum = 0;
        for (int i = mid; i >= left; i--) { // 역방향으로 이동하며 합계 계산
            totalSum += array[i];
            leftMaxValue = Math.max(leftMaxValue, totalSum);
        }

        int rightMaxValue = Integer.MIN_VALUE;
        totalSum = 0;
        for (int i = mid + 1; i <= right; i++) { // 정방향으로 이동하며 합계 계산
            totalSum += array[i];
            rightMaxValue = Math.max(rightMaxValue, totalSum);
        }
        int crossSum = leftMaxValue + rightMaxValue;

        // 4. 세 가지 경우 중 가장 큰 값 반환
        return Math.max(Math.max(leftResult, rightResult), crossSum);
    }
}
