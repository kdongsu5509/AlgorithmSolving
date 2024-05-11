using System;
using System.Collections.Generic;

public class Solution {
    public int[] solution(int n) {
        List<int> temp = new List<int>();
        for(int x = 0 ; x <= n ; x++){
            if(x % 2 != 0){
                temp.Add(x);
            }
        }
        return temp.ToArray();
    }
}
