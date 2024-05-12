using System;

public class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        foreach(int temp in numbers){
            answer += temp;
        }
        return answer / numbers.Length;
    }
}