import java.io.*;
import java.util.*;

public class Main {
    static int[] col = { -1, 1, 0, 0 };
    static int[] row = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int y = input[0];
        int x = input[1];

        int[][] matrix = new int[y][x];
        boolean[][][] visited = new boolean[y][x][2];

        for (int i = 0; i < y; i++) {
            matrix[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int result = BFS(matrix, visited, y, x);
        System.out.println(result);
    }

    private static int BFS(int[][] matrix, boolean[][][] visited, int y, int x) {
        Deque<QueueE> queue = new ArrayDeque<>();
        visited[0][0][0] = true;
        queue.offer(new QueueE(0, 0, 1, false));

        while (!queue.isEmpty()) {
            QueueE temp = queue.poll();
            int cx = temp.x;
            int cy = temp.y;
            int distance = temp.distance;
            boolean broken = temp.broken;

            if (cx == x - 1 && cy == y - 1) {
                return distance;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + row[i];
                int ny = cy + col[i];
                if (nx >= 0 && nx < x && ny >= 0 && ny < y) {
                    if (matrix[ny][nx] == 0 && !visited[ny][nx][broken ? 1 : 0]) {
                        visited[ny][nx][broken ? 1 : 0] = true;
                        queue.offer(new QueueE(ny, nx, distance + 1, broken));
                    } else if (matrix[ny][nx] == 1 && !broken && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        queue.offer(new QueueE(ny, nx, distance + 1, true));
                    }
                }
            }
        }

        return -1;
    }
}

class QueueE {
    public int y;
    public int x;
    public int distance;
    public boolean broken;

    QueueE(int y, int x, int distance, boolean broken) {
        this.y = y;
        this.x = x;
        this.distance = distance;
        this.broken = broken;
    }
}
