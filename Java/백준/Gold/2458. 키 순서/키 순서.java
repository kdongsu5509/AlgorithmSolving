import java.util.*;
import java.io.*;

public class Main {
    static int memberCnt;
    static int comparisonCnt;

    static List<List<Integer>> normal;
    static List<List<Integer>> revered;

    static int finalCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        memberCnt = input[0];
        comparisonCnt = input[1];

        // dfs 초기화
        normal = new ArrayList<>();
        revered = new ArrayList<>();

        for (int i = 0; i < memberCnt; i++) {
            normal.add(new ArrayList<>());
            revered.add(new ArrayList<>());
        }

        // 비교 정보 입력
        for (int i = 0; i < comparisonCnt; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = temp[0] - 1; // 1부터 시작 제거
            int b = temp[1] - 1; // 위와 동일

            normal.get(a).add(b);
            revered.get(b).add(a);
        }

        // 각 멤버 당 normal, reversed에 대해 dfs 수행
        for (int i = 0; i < memberCnt; i++) {
            int normalCnt = prevDfs(true, i) - 1;
            int reversedCnt = prevDfs(false, i) - 1;

            if (normalCnt + reversedCnt == memberCnt - 1)
                finalCnt += 1;

        }

        System.out.println(finalCnt);
    }

    static int prevDfs(boolean isNormal, int start) {
        boolean[] visited = new boolean[memberCnt];

        dfs(isNormal, visited, start);

        int returnVal = 0;
        for (boolean temp : visited) {
            if (temp)
                returnVal += 1;
        }
        return returnVal;
    }

    static void dfs(boolean isNormal, boolean[] visited, int start) {
        if (isNormal) {
            visited[start] = true;
            for (int element : normal.get(start)) {
                if (!visited[element]) {
                    dfs(isNormal, visited, element);
                }
            }
        } else {
            visited[start] = true;
            for (int element : revered.get(start)) {
                if (!visited[element]) {
                    dfs(isNormal, visited, element);
                }
            }
        }

    }
}