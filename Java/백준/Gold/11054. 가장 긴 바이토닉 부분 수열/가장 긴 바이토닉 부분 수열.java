import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int size;
    static int[] lisDp;
    static int[] ldsDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        lisDp = new int[size]; // 최장 증가 수열
        ldsDp = new int[size]; // 최장 감소 수열

        // 최장 증가 수열 구하기
        for (int i = 0; i < size; i++) {
            // 우선 lis[i]는 최소 1을 가짐
            lisDp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) { // 증가해야만 됨.
                    lisDp[i] = Math.max(lisDp[i], lisDp[j] + 1);
                }
            }
        }

        // 최장 감소 수열 구하기
        for (int i = size - 1; i >= 0; i--) {
            ldsDp[i] = 1;
            for (int j = size - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    ldsDp[i] = Math.max(ldsDp[i], ldsDp[j] + 1);
                }
            }
        }

        // 둘이 합해서 최대가 되는 값 구하기
        int maxLen = 0;
        for (int i = 0; i < size; i++) {
            maxLen = Math.max(maxLen, lisDp[i] + ldsDp[i] - 1);
        }

        System.out.println(maxLen);
    }
}
