import java.io.*;
import java.util.*;

//BJ_250204_2606
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computerCnt = Integer.parseInt(br.readLine());
        int linkedComputerCnt = Integer.parseInt(br.readLine());

        // 1번 컴퓨터가 컴퓨터 바이러스에 걸렸을 때 같이 걸리는 피해자의 수 출력
        // 어떠한 탐색 알고리즘 무관.
        Graph graph = new Graph(computerCnt);

        for (int i = 0; i < linkedComputerCnt; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.insertEgde(temp[0] - 1, temp[1] - 1);
        }

        graph.BFS(0);

        int effectedCnt = 0;
        for (int i = 1; i < computerCnt; i++) {
            if (graph.visited[i]) {
                effectedCnt += 1;
            }
        }

        System.out.println(effectedCnt);
    }
}

class Graph {

    int nodeCnt;
    List<List<Integer>> graph;
    public boolean[] visited;

    public Graph(int v) {
        nodeCnt = v;
        visited = new boolean[v];
        graph = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new LinkedList<>());
        }
    }

    public void insertEgde(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }

    public void BFS(int startPoint) {
        Deque<Integer> queue = new ArrayDeque<>();

        visited[startPoint] = true;
        queue.add(startPoint);

        while (queue.size() != 0) {
            startPoint = queue.poll();
            // 모든 인접 정점을 가져와서 방문하지 않았다면 방문 처리하고 큐에 삽입
            Iterator<Integer> i = graph.get(startPoint).listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
