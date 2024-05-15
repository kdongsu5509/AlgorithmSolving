using System;

public class Solution {
    public int[] solution(int[] num_list) {
        int even = 0, odd = 0;
        foreach(int x in num_list){
            if (x % 2 == 0) // Check if x is even
                even++;
            else
                odd++;
        }
        int[] answer = new int[] {even, odd};
        return answer;
    }
}
