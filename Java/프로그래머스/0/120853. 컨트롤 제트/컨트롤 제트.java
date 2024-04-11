import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        String[] temp = s.split("\\s+");
        int answer = 0;
        int total = 0;
        for(String t : temp){
            if(t.equals("Z")){
                int it = stack.pop();
                total -= it;
            }else{
                int it2 = Integer.parseInt(t);
                total += it2;
                stack.push(it2);
            }
        }
        answer = total;
        return answer;
    }
}
