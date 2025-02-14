import java.io.*;
import java.util.*;

public class Main {
    static int minGap = Integer.MAX_VALUE;
    static List<int[]> map;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        findMinGap(0, 0, new boolean[n]);

        System.out.println(minGap);
    }

    private static void findMinGap(int idx, int pickedCnt, boolean[] picked) {
        if (pickedCnt == n / 2) {
            minGap = Math.min(minGap, calculateMinGap(picked));
            return;
        } else if (idx == n | minGap == 0) {
            return;
        } else {
            findMinGap(idx + 1, pickedCnt, deepCopy(picked)); // 안뽑는다.
            picked[idx] = true;
            findMinGap(idx + 1, pickedCnt + 1, deepCopy(picked)); // 뽑는다.
        }
    }

    private static int calculateMinGap(boolean[] picked) {
        List<Integer> teamA = new ArrayList<>();
        List<Integer> teamB = new ArrayList<>();

        // 팀 나누기
        for (int i = 0; i < n; i++) {
            if (picked[i]) {
                teamA.add(i);
            } else {
                teamB.add(i);
            }
        }

        // 능력치 계산을 위한 예시 (능력치 배열이 있다고 가정)
        int teamAScore = 0;
        int teamBScore = 0;

        // teamA 능력치 합 구하기
        for (int i = 0; i < teamA.size(); i++) {
            for (int j = i + 1; j < teamA.size(); j++) {
                // 능력치 배열로 팀간 능력치를 더함
                teamAScore += map.get(teamA.get(i))[teamA.get(j)];
                teamAScore += map.get(teamA.get(j))[teamA.get(i)];
            }
        }

        // teamB 능력치 합 구하기
        for (int i = 0; i < teamB.size(); i++) {
            for (int j = i + 1; j < teamB.size(); j++) {
                // 능력치 배열로 팀간 능력치를 더함
                teamBScore += map.get(teamB.get(i))[teamB.get(j)];
                teamBScore += map.get(teamB.get(j))[teamB.get(i)];
            }
        }

        // 두 팀 간의 능력치 차이 계산
        return Math.abs(teamAScore - teamBScore);
    }

    private static boolean[] deepCopy(boolean[] org) {
        boolean[] temp = new boolean[org.length];
        for (int i = 0; i < n; i++) {
            temp[i] = org[i];
        }

        return temp;
    }
}
