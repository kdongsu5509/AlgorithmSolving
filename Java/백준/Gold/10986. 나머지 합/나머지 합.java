import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 누적 합의 나머지를 카운트할 배열
        long[] count = new long[m];
        long sum = 0;
        long result = 0;

        // 누적 합 계산 및 나머지 카운트
        for (int i = 0; i < n; i++) {
            sum += array[i];
            int remainder = (int) (sum % m);

            // 음수 나머지를 양수로 변환
            if (remainder < 0) remainder += m;

            // 나머지가 0이면 바로 카운트
            if (remainder == 0) {
                result++;
            }

            // 이전에 같은 나머지가 나온 횟수를 결과에 추가
            result += count[remainder];

            // 현재 나머지 카운트 증가
            count[remainder]++;
        }

        System.out.println(result);
    }
}
