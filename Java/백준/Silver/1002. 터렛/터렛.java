import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과 출력을 위한 StringBuilder 사용 (성능 개선)

        try {
            int testCaseCount = Integer.parseInt(br.readLine());

            for (int i = 0; i < testCaseCount; i++) {
                // StringTokenizer를 사용하여 파싱하면 성능에 더 유리합니다.
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int r1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());

                sb.append(getContactPointCount(x1, y1, r1, x2, y2, r2)).append('\n');
            }
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 두 원의 접점(교점) 개수를 계산하는 메서드
     */
    public static int getContactPointCount(int x1, int y1, int r1, int x2, int y2, int r2) {
        // 1. 두 중심 사이의 거리의 제곱 (d^2)
        // Math.pow 대신 곱셈을 사용하면 int 타입으로도 정확한 계산이 가능하며 빠릅니다.
        int dx = x1 - x2;
        int dy = y1 - y2;
        int distanceSq = dx * dx + dy * dy;

        // 2. 두 반지름의 합의 제곱 ((r1 + r2)^2)
        // 두 원이 외접할 때의 조건
        int radiusSumSq = (r1 + r2) * (r1 + r2);

        // 3. 두 반지름의 차의 제곱 (절댓값 |r1 - r2|의 제곱)
        // 두 원이 내접할 때의 조건
        int radiusDiffSq = (r1 - r2) * (r1 - r2);

        // case 1: 두 원의 중심이 같고, 반지름도 같을 때 (두 원이 완전히 일치)
        if (distanceSq == 0 && r1 == r2) {
            return -1; // 무한대
        }

        // case 2: 외부에 있으면서 만나지 않을 때 (d > r1 + r2)
        // distanceSq > radiusSumSq
        else if (distanceSq > radiusSumSq) {
            return 0;
        }

        // case 3: 한 원이 다른 원 안에 완전히 포함될 때 (d < |r1 - r2|)
        // distanceSq < radiusDiffSq
        // 이 때 distanceSq는 0이 아니어야 합니다 (case 1과 분리).
        else if (distanceSq < radiusDiffSq) {
            return 0;
        }

        // case 4: 외접할 때 (d = r1 + r2)
        // distanceSq == radiusSumSq
        else if (distanceSq == radiusSumSq) {
            return 1;
        }

        // case 5: 내접할 때 (d = |r1 - r2|)
        // distanceSq == radiusDiffSq
        else if (distanceSq == radiusDiffSq) {
            return 1;
        }

        // case 6: 두 점에서 만날 때 (|r1 - r2| < d < r1 + r2)
        // radiusDiffSq < distanceSq < radiusSumSq
        else {
            return 2;
        }
    }
}