import java.util.*;

class Solution {
    public String solution(String p) {
        // 1. 빈 문자열인 경우 그대로 반환
        if (p.isEmpty()) {
            return "";
        }

        // 2. u, v로 분리
        int balance = 0;
        int index = 0;
        do {
            if (p.charAt(index) == '(') {
                balance++;
            } else {
                balance--;
            }
            index++;
        } while (balance != 0);

        String u = p.substring(0, index);
        String v = p.substring(index);

        // 3. u가 올바른 괄호 문자열인지 확인
        if (isCorrect(u)) {
            return u + solution(v);
        }

        // 4. 올바른 괄호 문자열로 변환
        StringBuilder result = new StringBuilder();
        result.append("(");
        result.append(solution(v));
        result.append(")");

        // u의 첫 번째와 마지막 문자를 제거하고 나머지 괄호 방향 뒤집기
        u = u.substring(1, u.length() - 1);
        result.append(reverseBrackets(u));

        return result.toString();
    }

    // 올바른 괄호 문자열인지 확인
    private boolean isCorrect(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    // 괄호 방향 뒤집기
    private String reverseBrackets(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            sb.append(ch == '(' ? ')' : '(');
        }
        return sb.toString();
    }
}
