import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] results = new int[10001]; // 0으로 가득찬 정수 배열

        //D(n)를 계산해서 정수 배열에 넣음.
        for(int i=1 ; i < 10001 ; i++) {
            int functionDResult = calculateFunctionD(i);
            if(functionDResult < 10001){
                results[functionDResult]++;
            }
        }

        // 0이면 -> 무조건 출력
        for(int i = 1; i < 10001 ; i++) {
            if(results[i] == 0){
                System.out.println(i);
            }
        }
        // System.out.println(calculateFunctionD(33));
    }

    private static int calculateFunctionD (int x) {
        //길이를 구한다.
        Integer temp = x;
        String tempString = temp.toString();
        int paramLength = tempString.length();

        //길이에 맞게 D(n)를 계산하다
        int theResultOfD = x;

        for (int i = 0; i < paramLength; i++) {
            theResultOfD += Integer.parseInt(String.valueOf(tempString.charAt(i)));
        }

        //결과를 반환한다.
        return theResultOfD;
    }
}