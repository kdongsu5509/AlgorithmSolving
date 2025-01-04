import java.io.*;

public class Main {
    private static int[][] sdoku = new int[9][9];
    private static boolean[][] rows = new boolean[9][10]; // 행 체크
    private static boolean[][] cols = new boolean[9][10]; // 열 체크
    private static boolean[][] boxes = new boolean[9][10]; // 3x3 박스 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                sdoku[i][j] = Integer.parseInt(line[j]);
                if (sdoku[i][j] != 0) {
                    int num = sdoku[i][j];
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[getBoxIndex(i, j)][num] = true;
                }
            }
        }

        // 스도쿠 해결
        if (solve(0, 0)) {
            printSdoku();
        } else {
            System.out.println("No solution exists");
        }
    }

    private static boolean solve(int row, int col) {
        // 모든 칸을 다 채운 경우
        if (row == 9) return true;

        // 다음 칸 계산
        int nextRow = (col == 8) ? row + 1 : row;
        int nextCol = (col == 8) ? 0 : col + 1;

        // 이미 채워진 칸은 건너뜀
        if (sdoku[row][col] != 0) {
            return solve(nextRow, nextCol);
        }

        // 빈 칸에 대해 가능한 숫자 시도
        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                // 숫자 배치
                placeNumber(row, col, num);

                // 다음 칸 시도
                if (solve(nextRow, nextCol)) {
                    return true;
                }

                // 백트래킹
                removeNumber(row, col, num);
            }
        }

        return false;
    }

    private static boolean isValid(int row, int col, int num) {
        int boxIdx = getBoxIndex(row, col);
        return !rows[row][num] && !cols[col][num] && !boxes[boxIdx][num];
    }

    private static void placeNumber(int row, int col, int num) {
        sdoku[row][col] = num;
        rows[row][num] = true;
        cols[col][num] = true;
        boxes[getBoxIndex(row, col)][num] = true;
    }

    private static void removeNumber(int row, int col, int num) {
        sdoku[row][col] = 0;
        rows[row][num] = false;
        cols[col][num] = false;
        boxes[getBoxIndex(row, col)][num] = false;
    }

    private static int getBoxIndex(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }

    private static void printSdoku() {
        for (int[] row : sdoku) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}