import java.util.Stack;
import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int comp : arr){
            if (stack.empty() || stack.peek() != comp){
                list.add(comp);
                stack.push(comp);
            }else{
                stack.push(comp);
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");

        int[] answer = toArr(list);
        return answer;
    }
    
    private int[] toArr(ArrayList<Integer> arr){
        int s = arr.size();
        int[] re = new int[s];
        for(int x = 0 ; x < s; x++){
            re[x] = arr.get(x);
        }
        return re;
    }
}