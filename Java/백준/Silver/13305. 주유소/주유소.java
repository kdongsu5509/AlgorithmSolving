import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityCnt = Integer.parseInt(br.readLine().trim());
        int[] loadLength = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] oilMoney = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int nowPrice = Integer.MAX_VALUE;
        int prevPrice = Integer.MAX_VALUE;

        int nowCursor = 0;
        int prevCursor = 0;

        int totalPrice = 0;

        for (int i = 0; i < cityCnt - 1; i++) {
            nowCursor = i;
            nowPrice = oilMoney[i];

            if (nowPrice < prevPrice) {
                totalPrice += (nowPrice * loadLength[i]);
                prevCursor = nowCursor;
                prevPrice = nowPrice;
            } else {
                totalPrice += (prevPrice * loadLength[i]);
            }
        }

        System.out.println(totalPrice);

    }
}