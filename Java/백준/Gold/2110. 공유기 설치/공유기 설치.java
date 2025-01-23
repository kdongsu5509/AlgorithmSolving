import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer> housePosition;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: 집의 개수와 설치할 공유기 수
        int[] houseAndIpTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = houseAndIpTime[0]; // 집의 개수
        int c = houseAndIpTime[1]; // 공유기 개수

        housePosition = new ArrayList<>();

        // 입력: 집의 위치
        for (int i = 0; i < n; i++) {
            housePosition.add(Integer.parseInt(br.readLine()));
        }

        // 집의 위치를 정렬
        Collections.sort(housePosition);

        // 이분 탐색 범위 설정
        int left = 1; // 최소 거리
        int right = housePosition.get(housePosition.size() - 1) - housePosition.get(0); // 최대 거리
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2; // 중간 거리값

            if (canInstall(mid, c)) {
                result = mid; // 설치가 가능하면 결과 갱신
                left = mid + 1; // 더 큰 거리 시도
            } else {
                right = mid - 1; // 더 작은 거리 시도
            }
        }

        // 출력: 가장 큰 최소 거리
        System.out.println(result);
    }

    // 공유기를 최소 거리 d로 설치할 수 있는지 확인하는 함수
    private static boolean canInstall(int distance, int c) {
        int count = 1; // 첫 번째 집에 설치
        int lastInstalled = housePosition.get(0);

        for (int i = 1; i < housePosition.size(); i++) {
            if (housePosition.get(i) - lastInstalled >= distance) {
                count++;
                lastInstalled = housePosition.get(i);
            }
        }

        return count >= c; // 설치된 공유기 개수가 c 이상인지 확인
    }
}