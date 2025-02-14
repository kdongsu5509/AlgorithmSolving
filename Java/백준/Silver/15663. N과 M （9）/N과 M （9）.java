import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    static List<Integer> permutation = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 숫자를 사전순으로 정렬
        Arrays.sort(numbers);

        // 중복 순열 생성 시작
        backtrack(0);

        // 결과 출력
        System.out.println(sb);
    }

    static void backtrack(int depth) {
        if (depth == M) {
            for (int num : permutation) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        int lastUsed = -1;
        for (int i = 0; i < N; i++) {
            // 방문하지 않았고, 직전에 사용한 숫자가 아니면 선택
            if (!visited[i] && numbers[i] != lastUsed) {
                visited[i] = true;
                permutation.add(numbers[i]);
                lastUsed = numbers[i];
                
                backtrack(depth + 1);

                // 백트래킹
                visited[i] = false;
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
