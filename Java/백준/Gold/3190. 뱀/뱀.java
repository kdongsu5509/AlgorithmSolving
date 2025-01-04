import java.io.*;
import java.util.*;

public class Main {
    private static int gameSec = 0; // 총 생존 시간
    private static int direkt = 90; // 초기 방향 (오른쪽)
    private static int headRow = 1; // 초기 뱀 머리의 행
    private static int headCol = 1; // 초기 뱀 머리의 열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        int boardSize = Integer.parseInt(br.readLine().trim());
        int appleCnt = Integer.parseInt(br.readLine().trim());

        // 사과 정보를 Set<String>으로 저장
        Set<String> appleSet = new HashSet<>();
        for (int i = 0; i < appleCnt; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            appleSet.add(temp[0] + "," + temp[1]); // 1-based 좌표
        }

        int turningCnt = Integer.parseInt(br.readLine().trim());
        Map<Integer, String> turnInfo = new HashMap<>();
        for (int i = 0; i < turningCnt; i++) {
            String[] temp = br.readLine().split(" ");
            turnInfo.put(Integer.parseInt(temp[0]), temp[1]);
        }

        // 뱀 위치 저장
        Deque<String> snakePlace = new ArrayDeque<>();
        snakePlace.add("1,1");

        while (true) {
            int tempRow = headRow;
            int tempCol = headCol;

            // 이동
            switch (direkt) {
                case 0: tempRow -= 1; break;  // 위로 이동
                case 90: tempCol += 1; break; // 오른쪽 이동
                case 180: tempRow += 1; break; // 아래로 이동
                case 270: tempCol -= 1; break; // 왼쪽 이동
            }

            ++gameSec;

            // 벽 충돌 확인
            if (tempRow < 1 || tempCol < 1 || tempRow > boardSize || tempCol > boardSize) {
                System.out.println(gameSec);
                return;
            }

            // 자기 몸 충돌 확인
            String newBodyPlace = tempRow + "," + tempCol;
            if (snakePlace.contains(newBodyPlace)) {
                System.out.println(gameSec);
                return;
            }

            // 사과 확인
            if (!appleSet.contains(newBodyPlace)) {
                snakePlace.pollFirst(); // 꼬리 제거
            } else {
                appleSet.remove(newBodyPlace); // 사과를 먹음
            }
            snakePlace.addLast(newBodyPlace);

            // 방향 전환
            if (turnInfo.containsKey(gameSec)) {
                direkt = changeDirekt(direkt, turnInfo.get(gameSec));
            }

            // 머리 위치 업데이트
            headRow = tempRow;
            headCol = tempCol;
        }
    }

    private static int changeDirekt(int org, String newDir) {
        if (newDir.equals("L")) { // 왼쪽 90도 회전
            org -= 90;
            if (org < 0) org += 360;
        } else { // 오른쪽 90도 회전
            org += 90;
            if (org >= 360) org -= 360;
        }
        return org;
    }
}