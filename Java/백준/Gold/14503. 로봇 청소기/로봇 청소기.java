import java.io.*;
import java.util.*;

class Main {
    static int[] dx = { -1, 0, 1, 0 }; // 북, 동, 남, 서
    static int[] dy = { 0, 1, 0, -1 }; // 북, 동, 남, 서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 방 크기 입력 받기
        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]); // 세로 크기
        int M = Integer.parseInt(size[1]); // 가로 크기

        // 로봇 청소기 위치 및 방향 입력 받기
        String[] robotInfo = br.readLine().split(" ");
        int r = Integer.parseInt(robotInfo[0]);
        int c = Integer.parseInt(robotInfo[1]);
        int d = Integer.parseInt(robotInfo[2]);

        // 방의 상태 입력 받기
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(cleanRoom(map, r, c, d));
    }

    static int cleanRoom(int[][] map, int x, int y, int d) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        int count = 0;
        int turns = 0; // 회전 횟수 체크

        while (true) {
            if (!visited[x][y]) {
                visited[x][y] = true; // 현재 위치 청소
                count++;
            }

            int nextD = (d + 3) % 4; // 왼쪽 방향
            int nextX = x + dx[nextD];
            int nextY = y + dy[nextD];

            if (!visited[nextX][nextY] && map[nextX][nextY] == 0) {
                // 다음 위치로 이동 가능하면 이동
                x = nextX;
                y = nextY;
                d = nextD;
                turns = 0; // 회전 횟수 초기화
            } else {
                if (turns < 4) {
                    // 회전만 실행
                    d = nextD;
                    turns++;
                } else {
                    // 4방향 모두 청소가 되어 있거나 벽인 경우
                    nextX = x - dx[d];
                    nextY = y - dy[d];
                    if (map[nextX][nextY] == 1) {
                        break; // 뒤가 벽이면 종료
                    } else {
                        // 뒤로 이동
                        x = nextX;
                        y = nextY;
                        turns = 0;
                    }
                }
            }
        }
        return count;
    }
}
