import java.io.*;

public class Main {
    static int MAX_VALUE = Integer.MIN_VALUE;
    static int N;
    static String exp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        exp = br.readLine();

        // 백트래킹 시작
        dfs(0, Integer.parseInt(exp.substring(0, 1)));

        // 최대값 출력
        System.out.println(MAX_VALUE);
    }

    // 현재 위치 index에서 result 값으로 시작하는 DFS 탐색
    private static void dfs(int index, int result) {
        // 연산이 끝났을 때 최대값 갱신
        if (index >= N - 1) {
            MAX_VALUE = Math.max(MAX_VALUE, result);
            return;
        }

        // 1. 괄호 없이 현재 연산 수행
        char operator = exp.charAt(index + 1);
        int nextNum = exp.charAt(index + 2) - '0';
        int newResult = calculate(result, nextNum, operator);
        dfs(index + 2, newResult);

        // 2. 괄호를 추가하여 다음 숫자와 연산 먼저 수행
        if (index + 4 < N) {
            char nextOperator = exp.charAt(index + 3);
            int nextNextNum = exp.charAt(index + 4) - '0';
            int bracketValue = calculate(nextNum, nextNextNum, nextOperator);
            int newResultWithBracket = calculate(result, bracketValue, operator);
            dfs(index + 4, newResultWithBracket);
        }
    }

    // 연산 수행 함수
    private static int calculate(int a, int b, char op) {
        if (op == '+')
            return a + b;
        if (op == '-')
            return a - b;
        return a * b;
    }
}
