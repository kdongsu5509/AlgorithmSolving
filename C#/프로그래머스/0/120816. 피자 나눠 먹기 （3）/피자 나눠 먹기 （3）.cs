using System;

public class Solution {
    public int solution(int slice, int n) {
        int p = slice;
        while(true){
            if((double)p / n >= 1){
                return p / slice;
            }
            else{
                p += slice;
            }
        }
    }
}