using System;

public class Solution {
    public int solution(int n) {
        int p = 6;
        while(true){
            if(p % n == 0)
            {
                return p / 6;
            }
            else
            {
                p+=6;
                Console.WriteLine(p);
            }
        }
    }
}