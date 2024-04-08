import java.util.ArrayList;
import java.util.Arrays;


class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int temp : arr){
            if(temp % divisor == 0){
                al.add(temp);
            }
        }
        
        int[] answer = toArr(al);
        Arrays.sort(answer);
        return answer;
    }
    
    private int[] toArr(ArrayList<Integer> temp){
        int s = temp.size();
        int[] re = new int[s];
        for(int x = 0 ; x < s ; x++){
            re[x] = temp.get(x);
        }
        
        if(s == 0){
            int[] re2 = new int[1];
            re2[0] = -1;
            return re2;
        }
        return re;
    }
}