import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 요구 사항 : 집의 수, 단지별 정렬.
        int sideSize = Integer.parseInt(br.readLine());

        // 지도 정보 입력.
        List<int[]> map = new LinkedList<>();
        for (int i = 0; i < sideSize; i++) {
            map.add(Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray());
        }

        int setNum = 1;

        boolean[][] visited = new boolean[sideSize][sideSize];

        List<Integer> totalHouseCntInfo = new LinkedList<>();

        for (int y = 0; y < sideSize; y++) {
            for (int x = 0; x < sideSize; x++) {
                if (map.get(y)[x] == 1 && !visited[y][x]) {
                    int localHouseNum = BFS(map, visited, y, x, sideSize);
                    totalHouseCntInfo.add(localHouseNum);
                    setNum += 1;
                }
            }
        }

        Collections.sort(totalHouseCntInfo);

        // 출력
        System.out.println(totalHouseCntInfo.size());
        for (int temp : totalHouseCntInfo) {
            System.out.println(temp);
        }
    }

    // BFS에 참가한 멤버들의 횟수를 반환해야함 -> 이것이 단지 내 집의 수!
    private static int BFS(List<int[]> map, boolean[][] visited, int y, int x, int size) {
        int[] colMove = new int[] { 1, -1, 0, 0 }; // 상하좌우
        int[] rowMove = new int[] { 0, 0, -1, 1 };

        int localHouseCnt = 0;
        LinkedList<int[]> queue = new LinkedList<>();

        // 아래 3Line은 Set
        visited[y][x] = true;
        queue.add(new int[] { y, x });
        localHouseCnt++;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int idx = 0; idx < 4; idx++) {
                int ny = cy + colMove[idx];
                int nx = cx + rowMove[idx];

                if (0 <= nx && nx < size && 0 <= ny && ny < size && !visited[ny][nx] && map.get(ny)[nx] == 1) {
                    visited[ny][nx] = true;
                    queue.add(new int[] { ny, nx });
                    localHouseCnt++;
                }
            }
        }

        return localHouseCnt;
    }
}
