import java.io.*;
import java.util.*;

public class Main {
    static int notdivide;
    static int normal;

    static int[] col = new int[] { 1, -1, 0, 0 }; // 상, 하, 좌, 우
    static int[] row = new int[] { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        String[][] matrix = new String[cnt][cnt];
        for (int y = 0; y < cnt; y++) {
            matrix[y] = br.readLine().split("");
        }

        boolean[][] normalV = new boolean[cnt][cnt];
        boolean[][] specialV = new boolean[cnt][cnt];
        // bfs - not 적록색약
        for (int i = 0; i < cnt; i++) {
            for (int z = 0; z < cnt; z++) {
                if (!normalV[i][z]) {
                    normalBFS(matrix, normalV, i, z, cnt);
                    normal++;
                }
            }
        }

        // bfs - 적록색약
        for (int i = 0; i < cnt; i++) {
            for (int z = 0; z < cnt; z++) {
                if (!specialV[i][z]) {
                    speicalBFS(matrix, specialV, i, z, cnt);
                    notdivide++;
                }
            }
        }
        System.out.println(normal + " " + notdivide);
    }

    private static void normalBFS(String[][] matrix, boolean[][] visited, int y, int x, int cnt) {
        String target = matrix[y][x];

        LinkedList<int[]> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.add(new int[] { y, x });
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + col[i];
                int nx = cx + row[i];
                if (0 <= ny && ny < cnt && 0 <= nx && nx < cnt && !visited[ny][nx] && matrix[ny][nx].equals(target)) {
                    visited[ny][nx] = true;
                    queue.add(new int[] { ny, nx });
                }
            }
        }

    }

    private static void speicalBFS(String[][] matrix, boolean[][] visited, int y, int x,
            int cnt) {
        String target = matrix[y][x];
        if (target.equals("R") | target.equals("G")) {
            String target1 = "R";
            String target2 = "G";

            LinkedList<int[]> queue = new LinkedList<>();
            visited[y][x] = true;
            queue.add(new int[] { y, x });
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int cy = cur[0];
                int cx = cur[1];

                for (int i = 0; i < 4; i++) {
                    int ny = cy + col[i];
                    int nx = cx + row[i];
                    if (0 <= ny && ny < cnt && 0 <= nx && nx < cnt && !visited[ny][nx]
                            && (matrix[ny][nx].equals(target1) | matrix[ny][nx].equals(target2))) {
                        visited[ny][nx] = true;
                        queue.add(new int[] { ny, nx });
                    }
                }
            }
        } else if (target.equals("B")) {
            normalBFS(matrix, visited, y, x, cnt);
        }
    }

}
