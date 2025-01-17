import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력된 강의 수
        int cnt = Integer.parseInt(br.readLine());

        // 강의 정보를 저장할 우선순위 큐 (시작 시간 오름차순, 시작 시간이 같으면 종료 시간 오름차순)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        // 강의 정보를 입력받아 큐에 삽입
        for (int i = 0; i < cnt; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            pq.add(temp);
        }

        // 현재 강의실의 종료 시간을 관리할 우선순위 큐
        PriorityQueue<Integer> roomEndTimes = new PriorityQueue<>();

        // 강의 정보를 하나씩 처리
        while (!pq.isEmpty()) {
            int[] lecture = pq.poll();
            int start = lecture[0];
            int end = lecture[1];

            // 현재 강의실 중 가장 빠른 종료 시간이 새로운 강의 시작 시간보다 빠르면 강의실 재사용
            if (!roomEndTimes.isEmpty() && roomEndTimes.peek() <= start) {
                roomEndTimes.poll();
            }

            // 새로운 강의실 종료 시간 추가
            roomEndTimes.add(end);
        }

        // 필요한 강의실 개수 출력
        System.out.println(roomEndTimes.size());
    }
}
