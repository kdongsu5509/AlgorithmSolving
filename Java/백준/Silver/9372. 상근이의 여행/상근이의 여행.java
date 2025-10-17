import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            int[] cityAndFlight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            assert (cityAndFlight.length == 2);

            int cityCount = cityAndFlight[0];
            int flightCount = cityAndFlight[1];

            // Graph 생성
            List<List<Integer>> graph = new ArrayList<>();
            for (int city = 0; city < cityCount; city++) {
                graph.add(new ArrayList<>());
            }

            int start = -1;
            int end = -1;

            // Graph 값 입력값 기준으로 초기화
            for (int flight = 0; flight < flightCount; flight++) {
                int[] flightInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                start = flightInfo[0] - 1;
                end = flightInfo[1] - 1;

                graph.get(start).add(end);
                graph.get(end).add(start);
            }

            // 최단 여행 경로 구하기.
            boolean[] visited = new boolean[cityCount];
            LinkedList<Integer> queue = new LinkedList<Integer>();
            int visitedCount = 0;

            // 최단 여행의 시작점은 그냥 기존에 사용한 start 와 end를 사용하자.
            visited[end] = true;
            queue.add(end); // 마지막 도시 end를 기준으로 탐색을 시작한다.

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int next : graph.get(now)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                        visitedCount++;
                    }
                }

            }
            System.out.println(visitedCount);
        }
    }
}
