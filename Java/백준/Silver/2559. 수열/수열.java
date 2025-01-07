import java.io.*;
import java.util.*;


//BJ_250107_2559
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nUndK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); //n과 k를 입력받는 배열
        int[] daysTemperature = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 온도를 저장하는 배열.

        int days = nUndK[0];
        int range = nUndK[1];

        int maxDegree = 0; //최대 온도의 합 : 출력될 값.
        int rangeSum = 0; // 구간의 합

        int left = 0;
        int right = 0;

        //1. 0에서 range까지의 온도의 합을 구한다.
        for(int i = 0 ; i < range ; i++) {
            rangeSum += daysTemperature[i];
        }

        maxDegree = rangeSum;
        right = range; // 현재 rangeSum에는 (range - 1)까지만 포함되어 있음!!!

        //2. range와 right가 같아지기 전까지 left와 right를 하나씩 올리면서 최대 값을 구한다!
        while(right < days) {
            rangeSum -= daysTemperature[left];
            rangeSum += daysTemperature[right];

            if(rangeSum > maxDegree) {
                maxDegree = rangeSum;
            }

            left+=1;
            right+=1;
        }

        System.out.println(maxDegree);
    }
}