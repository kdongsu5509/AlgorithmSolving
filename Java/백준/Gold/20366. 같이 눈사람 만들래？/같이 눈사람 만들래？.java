import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;  // 눈의 개수
    static int snow[];  // 눈의 높이를 저장하는 배열
    static int min = Integer.MAX_VALUE;  // 최소 높이 차이를 저장하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        snow = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snow[i] = Integer.parseInt(st.nextToken());
        }

        // 눈의 높이 배열을 정렬
        Arrays.sort(snow);

        // 두 개의 Snowman을 생성하고 그 높이 차이를 계산하는 중첩된 반복문
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int snowMan1 = snow[i] + snow[j];
                int start = 0;
                int end = N - 1;

                // 투 포인터를 사용하여 두 개의 Snowman 높이를 비교하고 최소 높이 차이를 찾는 루프
                while (start < end) {
                    // 현재 포인터가 이미 사용된 눈의 인덱스와 일치하는 경우 다음 눈으로 이동
                    if (start == i || start == j) {
                        start++;
                        continue;
                    }
                    if (end == i || end == j) {
                        end--;
                        continue;
                    }

                    int snowMan2 = snow[start] + snow[end];
                    min = Math.min(min, Math.abs(snowMan1 - snowMan2));

                    // 높이 차이에 따라 포인터 이동
                    if (snowMan1 > snowMan2)
                        start++;
                    else if (snowMan1 < snowMan2)
                        end--;
                    else {
                        // 높이 차이가 0이면 더 이상의 계산이 필요 없으므로 0을 출력하고 종료
                        System.out.println(0);
                        return;
                    }
                }
            }
        }

        // 최소 높이 차이 출력
        System.out.println(min);
    }
}