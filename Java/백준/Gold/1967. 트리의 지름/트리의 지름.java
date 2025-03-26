import java.io.*;
import java.util.*;

public class Main {
    static int nodeCnt;
    static List<List<int[]>> tree = new ArrayList<>();
    static int MAX_DIST = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nodeCnt = Integer.parseInt(br.readLine());

        // tree 정보 초기화
        for (int i = 0; i < nodeCnt; i++) {
            tree.add(new ArrayList<>());
        }

        // tree 정보 입력
        for (int i = 0; i < nodeCnt - 1; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = input[0] - 1; // 0부터 시작하게 변경
            int b = input[1] - 1;
            int c = input[2];

            tree.get(a).add(new int[] { b, c });
            tree.get(b).add(new int[] { a, c });
        }

        // 각 Node별 DFS 수행
        for (int i = 0; i < nodeCnt; i++) {
            boolean[] visited = new boolean[nodeCnt];
            int maxDistCandidate = dfs(i, visited, 0);

            MAX_DIST = Math.max(MAX_DIST, maxDistCandidate);
        }

        System.out.println(MAX_DIST);
    }

    static int dfs(int idx, boolean[] visited, int distSoFar) {
        visited[idx] = true;
        int maxDist = distSoFar;

        for (int[] node : tree.get(idx)) {
            int next = node[0];
            int weight = node[1];

            if (!visited[next]) {
                maxDist = Math.max(maxDist, dfs(next, visited, distSoFar + weight));
            }
        }

        return maxDist;
    }
}