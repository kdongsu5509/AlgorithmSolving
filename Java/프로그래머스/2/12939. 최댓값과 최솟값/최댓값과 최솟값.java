import java.util.*;

class Solution {
    static int INTMAX;
    static int INTMIN;
    public String solution(String s) {
        INTMAX = Integer.MIN_VALUE;
        INTMIN = Integer.MAX_VALUE;
        
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).forEach(numbers::add);
        for(int x : numbers){
            if(x > INTMAX) {
                INTMAX = x;
            }
            
            if(x < INTMIN) {
                INTMIN = x;
            }
        }
        String answer = INTMIN + " " + INTMAX;
        return answer;
    }
}