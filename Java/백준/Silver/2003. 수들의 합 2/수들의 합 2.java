import java.util.*;
import java.io.*;

//BJ_250107_2003
public class Main {
    static int possibleCaseNumber = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arrays = new ArrayList<>();
        arrays.add(0);
        int[] nUndM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size = nUndM[0];
        int target = nUndM[1];

        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(e->arrays.add(e));

        int left = 0;
        int right = 0;

        int sum = 0; // 나 이전까지의 결과를 담고 있는 사람임!

        while(true) {
            //만약 sum이 목표보다 작으면 -> 오른쪽을 움직인다.
            if(sum < target) {
                ++right;
                sum+=arrays.get(right);
                isEqual(target, sum);

            } else if(sum > target) { //만약 sum이 목표보다 크면 -> 왼쪽을 움직인다.
                ++left;
                sum-=arrays.get(left);
                isEqual(target, sum);
            } else {
                ++right;
                sum+=arrays.get(right);
            }


            //종료 조건 -> rangseSum이 목표보다 작고 // right == size 이면 종료해라!
            if(right >= size) {
                while(sum > target) {
                    ++left;
                    sum -= arrays.get(left);

                    if(sum == target) {
                        possibleCaseNumber += 1;
                    }

                    if(left >= size) {
                        break;
                    }
                }
                break;
            }
        }

        System.out.println(possibleCaseNumber);
    }

    private static void isEqual(int a, int b) {
        if(a == b) possibleCaseNumber++;
    }
}