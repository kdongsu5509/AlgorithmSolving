import java.util.*;

public class Main {

    // 1, 2, 3 더하기의 결과를 담을 리스트
    private static List<Integer> dp = new ArrayList<>();
    // 계산할 숫자
    private static List<Integer> target = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        dp.add(1); // 0
        dp.add(2); // 1
        dp.add(4); // 2

        List<Integer> result = new ArrayList<>();

        int testCaseNumber = sc.nextInt();
        for (int i = 0; i < testCaseNumber; i++) {
            target.add(sc.nextInt());
        }

        // 입력 끝

        for (int temp : target) {
            if (temp > dp.size()) {
                for (int j = dp.size(); j < temp; j++) {
                    int ein = dp.get(j - 1);
                    int zwei = dp.get(j - 2);
                    int drei = dp.get(j - 3);
                    dp.add(ein + zwei + drei);
                }
            }
            result.add(dp.get(temp - 1));
        }

        for (int i = 0; i < testCaseNumber; i++) {
            int specificNumber = target.get(i);
            int calculatedNumber = dp.get(specificNumber - 1);
            System.out.println(calculatedNumber);
        }
    }
}
