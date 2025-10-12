import java.io.*;
import java.util.*;

public class Main {
    static int M, N; // M=세로, N=가로
    static boolean[][] map;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mapInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = mapInfo[0]; // M=세로
        N = mapInfo[1]; // N=가로
        int boxCnt = mapInfo[2];

        map = new boolean[M][N]; // 배열 선언: [세로][가로]

        for (int i = 0; i < boxCnt; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = input[0];
            int y1 = input[1];
            int x2 = input[2];
            int y2 = input[3];

            for (int yNow = y1; yNow < y2; yNow++) {
                for (int xNow = x1; xNow < x2; xNow++) {
                    map[yNow][xNow] = true;
                }
            }
        }

        List<Integer> leftBoxSize = new ArrayList<>();

        for (int yNow = 0; yNow < M; yNow++) {
            for (int xNow = 0; xNow < N; xNow++) {
                if (!map[yNow][xNow]) {
                    leftBoxSize.add(dfs(yNow, xNow));
                }
            }
        }

        Collections.sort(leftBoxSize);

        System.out.println(leftBoxSize.size());
        for (int size : leftBoxSize) {
            System.out.print(size + " ");
        }
    }

    public static int dfs(int y, int x) {
        map[y][x] = true;
        int area = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !map[ny][nx]) {
                area += dfs(ny, nx);
            }
        }
        return area;
    }
}