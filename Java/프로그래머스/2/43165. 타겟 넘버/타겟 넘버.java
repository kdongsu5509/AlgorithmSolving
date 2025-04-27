import java.util.*;

class Solution {
    static int[] numbers;
    static int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        int answer = dfs(0, 0);
        return answer;
    }
    
    private int dfs(int start, int nowSum) {
        // 종료 조건: 모든 숫자를 다 썼을 때
        if (start == numbers.length) {
            if (nowSum == target) {
                return 1; // 맞게 만들었으면 경우의 수 1 추가
            } else {
                return 0; // 아니면 0
            }
        }
        
        // 더하기
        int cnt1 = dfs(start + 1, nowSum + numbers[start]);
        
        // 빼기
        int cnt2 = dfs(start + 1, nowSum - numbers[start]);
        
        // 두 경우를 합치기
        return cnt1 + cnt2;
    }
}
