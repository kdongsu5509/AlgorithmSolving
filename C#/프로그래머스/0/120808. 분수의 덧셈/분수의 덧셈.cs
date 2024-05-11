using System;

public class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        
        // 두 분수를 더한 분자
        int numerator = numer1 * denom2 + numer2 * denom1;
        // 두 분수를 더한 분모
        int denominator = denom1 * denom2;

        // 최대공약수 구하기
        int divisor = gcd(numerator, denominator);

        // 기약 분수로 만들기
        numerator /= divisor;
        denominator /= divisor;

        // 결과 배열에 담아서 반환
        answer[0] = numerator;
        answer[1] = denominator;
        
        return answer;
    }
    
    // 최대공약수를 계산하는 메서드
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
