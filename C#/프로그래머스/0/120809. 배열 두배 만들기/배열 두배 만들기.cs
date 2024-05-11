using System;

public class Solution {
    public int[] solution(int[] numbers) {
        for(int x = 0 ; x < numbers.Length ; x++){
            numbers[x] *= 2;
        }
    return numbers;
    }
}