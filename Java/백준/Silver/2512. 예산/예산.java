import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int provinceCnt = Integer.parseInt(br.readLine());
        List<Integer> budgets = new ArrayList<>();
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(budgets::add);
        int fixedBudgetsSum = Integer.parseInt(br.readLine());

        int budgetsTotal = sum(budgets, Integer.MAX_VALUE);
        Collections.sort(budgets);
        if (budgetsTotal <= fixedBudgetsSum) {
            // 예산 총합이 요청된 예산보다 작다면, 최대 요청 예산을 그대로 출력.
            System.out.println(budgets.get(budgets.size() - 1));
        } else {
            // 이진 탐색을 통해 최적의 상한선을 찾는다.
            int budgetCutLine = getMaxCutLine(budgets, fixedBudgetsSum);
            System.out.println(budgetCutLine);
        }
    }

    private static int getMaxCutLine(List<Integer> budgets, int total) {
        int left = 0;
        int right = Collections.max(budgets); // 가장 큰 예산 신청 금액을 상한으로 설정
        int candidateOfAnswer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int tempSum = sum(budgets, mid);

            if (tempSum <= total) {
                candidateOfAnswer = mid; // 가능한 정답 후보 저장
                left = mid + 1; // 더 큰 값도 확인
            } else {
                right = mid - 1; // 초과했으므로 더 작은 값 탐색
            }
        }
        return candidateOfAnswer;
    }

    private static int sum(List<Integer> budgets, int cutLine) {
        int total = 0;
        for (Integer budget : budgets) {
            total += Math.min(budget, cutLine);
        }
        return total;
    }
}
