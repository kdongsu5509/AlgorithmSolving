import java.io.*;
import java.util.*;

public class Main {
    static int[] knightRowMove = new int[] { 1, 2, 1, 2, -1, -2, -1, -2 };
    static int[] knightColMove = new int[] { 2, 1, -2, -1, -2, -1, 2, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseCnt; i++) {
            int sideSize = Integer.parseInt(br.readLine());
            int[] now = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int localMinMoveCnt = BFS(now, target, sideSize);
            bw.append(localMinMoveCnt + "\n");
        }

        bw.flush();
    }

    private static int BFS(int[] now, int[] target, int sideSize) {
        boolean[][] visited = new boolean[sideSize][sideSize];
        LinkedList<QueueE> queue = new LinkedList<>();

        int movementCnt = 0;
        // 1. 최초의 친구를 넣는다.
        visited[now[0]][now[1]] = true;
        QueueE first = new QueueE(now[0], now[1], movementCnt);
        queue.add(first);

        // 2. 실질적인 bfs 코드
        while (!queue.isEmpty()) {
            QueueE cur = queue.poll();
            int curX = cur.x;
            int curY = cur.y;
            movementCnt = cur.dist;

            if (curX == target[0] && curY == target[1])
                break;

            for (int idx = 0; idx < 8; idx++) {
                int tx = curX + knightRowMove[idx];
                int ty = curY + knightColMove[idx];

                if (0 <= tx && tx < sideSize && 0 <= ty && ty < sideSize && !visited[tx][ty]) {
                    queue.add(new QueueE(tx, ty, cur.dist + 1));
                    visited[tx][ty] = true;
                }
            }
        }

        return movementCnt;
    }
}

class QueueE {
    public int x;
    public int y;
    public int dist;

    public QueueE(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
