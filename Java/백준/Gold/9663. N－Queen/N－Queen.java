import java.io.*;

public class Main {
    private static int possibleCaseNumber = 0; // 가능한 경우의 수
    private static int[] columns; // 각 행의 퀸이 놓인 열의 위치
    private static boolean[] leftDiagonal; // 좌상향 대각선
    private static boolean[] rightDiagonal; // 우상향 대각선
    private static boolean[] rows; // 열 검사

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // 배열 초기화
        columns = new int[n];
        rows = new boolean[n];
        leftDiagonal = new boolean[2 * n - 1]; // 좌상향 대각선 (row - col)
        rightDiagonal = new boolean[2 * n - 1]; // 우상향 대각선 (row + col)

        // 백트래킹 탐색 시작
        placeQueens(0, n);

        // 가능한 경우의 수 출력
        System.out.println(possibleCaseNumber);
    }

    private static void placeQueens(int row, int n) {
        if (row == n) { // 모든 퀸을 배치한 경우
            possibleCaseNumber++;
            return;
        }

        for (int col = 0; col < n; col++) {
            // 현재 위치가 유효한지 확인
            if (isSafe(row, col, n)) {
                // 현재 위치에 퀸 배치
                columns[row] = col;
                rows[col] = true;
                leftDiagonal[row - col + n - 1] = true;
                rightDiagonal[row + col] = true;

                // 다음 행으로 이동
                placeQueens(row + 1, n);

                // 퀸 제거 (백트래킹)
                rows[col] = false;
                leftDiagonal[row - col + n - 1] = false;
                rightDiagonal[row + col] = false;
            }
        }
    }

    private static boolean isSafe(int row, int col, int n) {
        // 열과 대각선에서 충돌 여부 확인
        return !rows[col] && !leftDiagonal[row - col + n - 1] && !rightDiagonal[row + col];
    }
}
