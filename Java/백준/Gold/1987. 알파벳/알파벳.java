import java.util.*;

public class Main {
    static int R, C;
    static char[][] board;
    static boolean[] visited = new boolean[26];  // 알파벳 'A'~'Z'까지 방문 여부 체크
    static int maxCount = 1;  // 최대 칸 수

    // 방향 설정 (상, 하, 좌, 우)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        board = new char[R][C];

        // 보드 입력 받기
        for (int i = 0; i < R; i++) {
            board[i] = sc.next().toCharArray();
        }

        // (0, 0)에서 시작, 첫 번째 알파벳 방문 처리
        visited[board[0][0] - 'A'] = true;
        
        // DFS 탐색 시작
        dfs(0, 0, 1);

        System.out.println(maxCount);
    }

    static void dfs(int r, int c, int count) {
        // 최대 칸 수 갱신
        maxCount = Math.max(maxCount, count);

        // 4방향으로 이동
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 보드 밖으로 벗어나지 않도록 체크
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

            // 방문한 적 없는 알파벳이면 탐색
            if (!visited[board[nr][nc] - 'A']) {
                visited[board[nr][nc] - 'A'] = true;
                dfs(nr, nc, count + 1);  // 다음 위치로 이동하면서 칸 수 증가
                visited[board[nr][nc] - 'A'] = false;  // 백트래킹
            }
        }
    }
}
