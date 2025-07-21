import java.io.*;
import java.util.*;

class Main {
    static List<Deque<Integer>> wheels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        wheels = new ArrayList<>();

        // 톱니 정보 입력
        for (int i = 0; i < 4; i++) {
            Deque<Integer> wheel = new LinkedList<>();
            String input = br.readLine();
            for (char c : input.toCharArray()) {
                wheel.add(c - '0');
            }
            wheels.add(wheel);
        }

        int k = Integer.parseInt(br.readLine());
        for (int y = 0; y < k; y++) {
            String[] line = br.readLine().split(" ");
            int num = Integer.parseInt(line[0]) - 1; // 인덱스 보정
            int dir = Integer.parseInt(line[1]);
            turnWheels(num, dir);
        }

        System.out.println(getScore());
    }

    private static void turnWheels(int idx, int dir) {
        int[] dirs = new int[4];
        dirs[idx] = dir;

        // 왼쪽 방향 확인
        for (int i = idx; i > 0; i--) {
            int left = wheels.get(i - 1).toArray(new Integer[0])[2];
            int right = wheels.get(i).toArray(new Integer[0])[6];
            if (left != right) {
                dirs[i - 1] = -dirs[i];
            } else break;
        }

        // 오른쪽 방향 확인
        for (int i = idx; i < 3; i++) {
            int left = wheels.get(i).toArray(new Integer[0])[2];
            int right = wheels.get(i + 1).toArray(new Integer[0])[6];
            if (left != right) {
                dirs[i + 1] = -dirs[i];
            } else break;
        }

        // 회전 수행
        for (int i = 0; i < 4; i++) {
            if (dirs[i] == 1) rotateClockwise(wheels.get(i));
            else if (dirs[i] == -1) rotateCounterClockwise(wheels.get(i));
        }
    }

    private static void rotateClockwise(Deque<Integer> dq) {
        dq.addFirst(dq.pollLast());
    }

    private static void rotateCounterClockwise(Deque<Integer> dq) {
        dq.addLast(dq.pollFirst());
    }

    private static int getScore() {
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (wheels.get(i).peekFirst() == 1) {
                score += (1 << i); // 2^i
            }
        }
        return score;
    }
}
