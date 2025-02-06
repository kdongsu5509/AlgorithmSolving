import java.io.*;
import java.util.*;

public class Main {
    // 이동할 8개 방향 정의 (상, 하, 좌, 우, 대각선 4방향)
    private static final int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
    private static final int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder

        while (true) {
            // 입력 받기 (지도의 너비와 높이)
            String[] input = br.readLine().split(" ");
            int w = Integer.parseInt(input[0]);
            int h = Integer.parseInt(input[1]);
            // 종료 조건 체크 (0, 0이 입력되면 종료)
            if (w == 0 && h == 0)
                break;

            // 지도 정보를 저장할 배열
            int[][] map = new int[h][w];
            // 방문 여부를 체크할 배열
            boolean[][] visited = new boolean[h][w];

            // 지도 정보 입력 받기
            for (int i = 0; i < h; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            // 섬의 개수를 카운트할 변수
            int islandCount = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 육지이고 방문하지 않았다면 BFS 시작
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(map, visited, i, j, w, h);
                        islandCount++; // 섬의 개수 증가
                    }
                }
            }

            // 계산된 섬의 개수를 저장
            sb.append(islandCount).append('\n');
        }
        // 결과 출력
        System.out.print(sb);
    }

    // BFS를 실행하는 메소드
    private static void bfs(int[][] map, boolean[][] visited, int x, int y, int w, int h) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < h && ny < w && map[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[] { nx, ny });
                    visited[nx][ny] = true;
                }
            }
        }
    }
}