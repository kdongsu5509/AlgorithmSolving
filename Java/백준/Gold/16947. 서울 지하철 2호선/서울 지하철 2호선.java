import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    static List<List<Integer>> mapInfo;
    static boolean[] visited;
    static boolean[] onCycle;
    static int[] dist;
    static boolean foundCycle = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(br.readLine());

        mapInfo = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            mapInfo.add(new ArrayList<>());
        }

        for (int i = 0; i < cnt; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1; // 0-based index
            int b = Integer.parseInt(input[1]) - 1;

            mapInfo.get(a).add(b);
            mapInfo.get(b).add(a);
        }

        visited = new boolean[cnt];
        onCycle = new boolean[cnt];
        dist = new int[cnt];

        // 사이클 찾기
        findCycle(0, -1);

        // 거리 계산
        bfs();

        // 출력
        for (int d : dist) {
            System.out.print(d + " ");
        }
    }

    // DFS로 사이클 찾기
    static boolean findCycle(int now, int parent) {
        visited[now] = true;

        for (int next : mapInfo.get(now)) {
            if (next == parent) continue;

            if (!visited[next]) {
                if (findCycle(next, now)) {
                    if (!foundCycle) onCycle[now] = true;
                    if (now == cycleStart) foundCycle = true; // 사이클 시작점까지 왔으면 종료
                    return !foundCycle;
                }
            } else if (!foundCycle) {
                onCycle[next] = true;
                onCycle[now] = true;
                cycleStart = next;
                return true;
            }
        }

        return false;
    }

    static int cycleStart;

    // BFS로 거리 측정
    static void bfs() {
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < cnt; i++) {
            if (onCycle[i]) {
                dist[i] = 0;
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : mapInfo.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
