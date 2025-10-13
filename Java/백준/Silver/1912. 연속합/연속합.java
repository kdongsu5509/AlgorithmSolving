import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int arraySize = Integer.parseInt(br.readLine());

        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = dp(arraySize, array);
        System.out.println(result);
    }

    private static int dp(int size, int[] array) {

        int returnValue = Integer.MIN_VALUE;

        int previousSum = 0;
        for (int i = 0; i < size; i++) {
            previousSum = Math.max(previousSum + array[i], array[i]);
            returnValue = Math.max(previousSum, returnValue);
        }

        return returnValue;
    }
}
