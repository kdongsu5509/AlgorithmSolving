import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (char num : number.toCharArray()) {
            // 스택에 있는 숫자들이 현재 숫자보다 작고, 아직 제거할 수 있는 숫자가 남아 있다면 제거
            while (k > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                k--;
            }
            stack.push(num);
        }
        
        // 최종적으로 남은 숫자들 중에서 k개의 숫자를 제거하고 결과 반환
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stack.size() - k; i++) {
            result.append(stack.get(i));
        }
        
        return result.toString();  // 결과 반환
    }
}