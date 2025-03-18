import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[][] map;
    static int shortestCD = Integer.MAX_VALUE;
    static List<int[]> ChickenHouseInfo;
    static List<int[]> houseInfo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = input[0];
        m = input[1];
        map = new int[n][n];
        ChickenHouseInfo = new ArrayList<>();
        houseInfo = new ArrayList<>();

        int ChickenHouseCurrentCount = 0;

        // 현재 지도 입력 및 치킨집 위치 파악.
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int x = 0; x < n; x++) {
                if (map[i][x] == 2) {
                    ChickenHouseInfo.add(new int[] { i, x });
                    ChickenHouseCurrentCount += 1;
                } else if (map[i][x] == 1) {
                    houseInfo.add(new int[] { i, x });
                }
            }
        }

        if (ChickenHouseCurrentCount == m) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                temp.add(i);
            }
            shortestCD = getCD(temp);
        } else {
            ArrayList<Integer> empty = new ArrayList<>();
            calculate(empty, 0);
        }
        System.out.println(shortestCD);
    }

    static void calculate(List<Integer> selection, int start) {
        if (selection.size() == m) {
            shortestCD = Math.min(shortestCD, getCD(selection));
            return;
        }

        for (int i = start; i < ChickenHouseInfo.size(); i++) {
            selection.add(i);
            calculate(selection, i + 1); // 다음 인덱스로 이동
            selection.remove(selection.size() - 1); // 백트래킹
        }
    }

    static int getCD(List<Integer> selection) {
        int[] localCD = new int[houseInfo.size()];
        Arrays.fill(localCD, Integer.MAX_VALUE);

        // 닭집 선택
        for (int x : selection) {
            int[] chickenHouse = ChickenHouseInfo.get(x);
            int cx = chickenHouse[0];
            int cy = chickenHouse[1];
            for (int k = 0; k < houseInfo.size(); k++) {
                int[] house = houseInfo.get(k);
                int hx = house[0];
                int hy = house[1];
                int cd = Math.abs(cx - hx) + Math.abs(cy - hy);
                localCD[k] = Math.min(localCD[k], cd);
            }
        }

        return Arrays.stream(localCD).sum();

    }
}