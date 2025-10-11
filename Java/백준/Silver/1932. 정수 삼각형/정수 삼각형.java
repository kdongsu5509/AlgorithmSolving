import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalSize = Integer.parseInt(br.readLine());

        int[][] triangle = new int[totalSize][totalSize];

        // 삼각형 값 입력 받기
        for (int i = 0; i < totalSize; i++) {
            String[] rowStr = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(rowStr[j]);
            }
        }

        for (int i = totalSize - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        System.out.println(triangle[0][0]);
    }
}