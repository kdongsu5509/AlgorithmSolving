import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] userInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int dishCnt = userInput[0];
        int menuCnt = userInput[1];
        int k = userInput[2];
        int couponNum = userInput[3];

        int maxCnt = 0;

        List<Integer> dishes = new ArrayList<>();
        Map<Integer, Integer> localDishes = new HashMap<>();

        // 접시 정보 입력 받기
        for (int i = 0; i < dishCnt; i++) {
            dishes.add(Integer.parseInt(br.readLine()));
        }

        // 초기 슬라이딩 윈도우 설정
        for (int i = 0; i < k; i++) {
            localDishes.put(dishes.get(i), localDishes.getOrDefault(dishes.get(i), 0) + 1);
        }

        maxCnt = localDishes.size();
        int tail = 0;
        int head = k;

        // 슬라이딩 윈도우 시작
        for (; tail < dishCnt; tail++) {
            // 윈도우의 끝을 초과하지 않도록 head를 조정
            head %= dishCnt;

            // tail 요소 제거
            int tempTailKey = dishes.get(tail);
            localDishes.put(tempTailKey, localDishes.get(tempTailKey) - 1);
            if (localDishes.get(tempTailKey) == 0) {
                localDishes.remove(tempTailKey);
            }

            // head 요소 추가
            int tempHeadKey = dishes.get(head);
            localDishes.put(tempHeadKey, localDishes.getOrDefault(tempHeadKey, 0) + 1);

            // 최대 값 갱신
            if (localDishes.containsKey(couponNum)) {
                maxCnt = Math.max(maxCnt, localDishes.size());
            } else {
                maxCnt = Math.max(maxCnt, localDishes.size() + 1);
            }

            head++;
        }

        System.out.println(maxCnt);
    }
}
