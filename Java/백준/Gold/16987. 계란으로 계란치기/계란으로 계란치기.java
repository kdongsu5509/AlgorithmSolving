import java.util.*;
import java.io.*;

public class Main {
    static int maxBrokedEggCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 계란 개수 입력
        int eggCount = Integer.parseInt(br.readLine().trim());

        // 계란 정보 저장 리스트
        List<Egg> eggs = new ArrayList<>();

        // 계란 정보 입력받기
        for (int i = 0; i < eggCount; i++) {
            String[] temp = br.readLine().split(" ");
            int tempDurability = Integer.parseInt(temp[0]);
            int tempWeight = Integer.parseInt(temp[1]);
            eggs.add(new Egg(tempWeight, tempDurability));
        }

        // 재귀 호출로 최대 깨진 계란 수 찾기
        findMaxBrokenEggs(eggs, 0);

        // 결과 출력
        System.out.println(maxBrokedEggCount);
    }

    // 재귀를 이용해 최대 깨진 계란 수 찾기
    static void findMaxBrokenEggs(List<Egg> eggs, int index) {
        // 모든 계란을 한 번씩 들었으면 종료
        if (index == eggs.size()) {
            int brokenCount = 0;
            for (Egg egg : eggs) {
                if (egg.durability <= 0) {
                    brokenCount++;
                }
            }
            maxBrokedEggCount = Math.max(maxBrokedEggCount, brokenCount);
            return;
        }

        // 현재 계란이 이미 깨진 경우 다음 계란으로
        if (eggs.get(index).durability <= 0) {
            findMaxBrokenEggs(eggs, index + 1);
            return;
        }

        boolean anyHit = false;

        // 다른 계란과 부딪히기
        for (int i = 0; i < eggs.size(); i++) {
            if (i != index && eggs.get(i).durability > 0) {
                // 두 계란 부딪히기
                eggs.get(index).durability -= eggs.get(i).weight;
                eggs.get(i).durability -= eggs.get(index).weight;

                // 재귀 호출
                findMaxBrokenEggs(eggs, index + 1);
                anyHit = true;

                // 상태 복구
                eggs.get(index).durability += eggs.get(i).weight;
                eggs.get(i).durability += eggs.get(index).weight;
            }
        }

        // 아무것도 부딪히지 않은 경우 다음으로 진행
        if (!anyHit) {
            findMaxBrokenEggs(eggs, index + 1);
        }
    }
}

// Egg 클래스 정의
class Egg {
    int weight;      // 계란의 무게
    int durability;  // 계란의 내구도

    // 생성자
    public Egg(int weight, int durability) {
        this.weight = weight;
        this.durability = durability;
    }
}
