import java.util.*;

class Solution {
    List<Character> operators;
    List<Long> operands;
    long max = 0;

    public long solution(String expression) {
        operators = new ArrayList<>();
        operands = new ArrayList<>();

        // 수식 파싱
        StringBuilder sb = new StringBuilder();
        for (char x : expression.toCharArray()) {
            if (x == '-' || x == '+' || x == '*') {
                operands.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operators.add(x);
            } else {
                sb.append(x);
            }
        }
        operands.add(Long.parseLong(sb.toString())); // 마지막 숫자

        // 사용된 연산자 종류 수집
        Set<Character> uniqueOps = new HashSet<>(operators);
        List<Character> opList = new ArrayList<>(uniqueOps);

        // 연산자 우선순위 순열 생성
        permute(opList, 0);

        return max;
    }

    // 연산자 우선순위 순열 만들기 (백트래킹)
    void permute(List<Character> opList, int depth) {
        if (depth == opList.size()) {
            calculate(opList);
            return;
        }

        for (int i = depth; i < opList.size(); i++) {
            Collections.swap(opList, i, depth);
            permute(opList, depth + 1);
            Collections.swap(opList, i, depth);
        }
    }

    // 수식 계산
    void calculate(List<Character> priority) {
        List<Long> tempOperands = new ArrayList<>(operands);
        List<Character> tempOperators = new ArrayList<>(operators);

        for (char op : priority) {
            for (int i = 0; i < tempOperators.size(); ) {
                if (tempOperators.get(i) == op) {
                    long res = operate(tempOperands.get(i), tempOperands.get(i + 1), op);
                    tempOperands.remove(i + 1);
                    tempOperands.set(i, res);
                    tempOperators.remove(i);
                } else {
                    i++;
                }
            }
        }

        max = Math.max(max, Math.abs(tempOperands.get(0)));
    }

    long operate(long a, long b, char op) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else return a * b;
    }
}
