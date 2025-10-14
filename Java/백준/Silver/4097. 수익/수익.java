import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        while (true) {
            int sizeInput = sc.nextInt();

            if (sizeInput == 0)
                break;

            int[] tempArr = new int[sizeInput];

            for (int i = 0; i < sizeInput; i++) {
                tempArr[i] = sc.nextInt();
            }

            System.out.println(findMaxSum(sizeInput, tempArr));
        }
    }

    private static int findMaxSum(int size, int[] arr) {

        int previousSum = 0;
        int returnValue = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            previousSum = Math.max(previousSum + arr[i], arr[i]);
            returnValue = Math.max(previousSum, returnValue);
        }

        return returnValue;
    }
}
