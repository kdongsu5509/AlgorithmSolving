using System;

public class Solution {
    public int solution(int price) {
        float answer = price >= 500000 ? price * 0.8f : price >= 300000 ? price * 0.9f : price >= 100000 ? price * 0.95f : price;
        return (int)answer;
    }
}