import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int col = Integer.parseInt(size[0]); // 주의: 입력은 행렬의 전치로 주어지기 때문에
        int row = Integer.parseInt(size[1]); // 이를 감안하여 변수명을 변경할 수 있습니다.

        List<List<Integer>> matrix = new ArrayList<>();

        List<int[]> rotenTomatoPos = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            List<Integer> tempRow = new ArrayList<>();
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                int value = Integer.parseInt(temp[j]);
                tempRow.add(value);
                if (value == 1) {
                    rotenTomatoPos.add(new int[] { j, i }); // j가 열, i가 행
                }
            }
            matrix.add(tempRow);
        }

        if (isAllPerfect(matrix, row, col)) {
            System.out.println(0);
            return;
        }

        int days = BFS(matrix, row, col, rotenTomatoPos);
        System.out.println(days);
    }

    private static boolean isAllPerfect(List<List<Integer>> matrix, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix.get(i).get(j) == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int BFS(List<List<Integer>> matrix, int row, int col, List<int[]> start) {
        LinkedList<int[]> queue = new LinkedList<>();
        for (int[] pos : start) {
            queue.add(new int[] { pos[0], pos[1], 0 }); // x, y, day
        }

        int totalDays = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int day = current[2];
            totalDays = day;

            int[] dx = { 0, 0, -1, 1 };
            int[] dy = { -1, 1, 0, 0 };
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < col && ny >= 0 && ny < row && matrix.get(ny).get(nx) == 0) {
                    matrix.get(ny).set(nx, 1);
                    queue.add(new int[] { nx, ny, day + 1 });
                }
            }
        }

        // Check if all tomatoes are ripe
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix.get(i).get(j) == 0) {
                    return -1; // Not all tomatoes are ripe
                }
            }
        }

        return totalDays;
    }
}
