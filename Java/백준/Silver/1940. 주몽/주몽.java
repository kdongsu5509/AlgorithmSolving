import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arraySize = Integer.parseInt(br.readLine().trim());
        int targetNum = Integer.parseInt(br.readLine().trim());

        int[] ingredients = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.parallelSort(ingredients);

        int left = 0;
        int right = arraySize - 1;
        int totalPossilbeCombination = 0;
        while(left < right) {
            int sum = ingredients[left] + ingredients[right];

            if(sum == targetNum) {
                ++totalPossilbeCombination;
            }

            if(sum < targetNum) {
                ++left;
            } else {
                --right;
            }
        }

        System.out.println(totalPossilbeCombination);
    }    
}
