import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityCnt = Integer.parseInt(br.readLine().trim());
        long[] loadLength = Arrays.stream(br.readLine().split(" ")).mapToLong(Integer::parseInt).toArray();
        long[] oilMoney = Arrays.stream(br.readLine().split(" ")).mapToLong(Integer::parseInt).toArray();

        long nowPrice = Integer.MAX_VALUE;
        long prevPrice = Integer.MAX_VALUE;

        int nowCursor = 0;
        int prevCursor = 0;

        BigInteger totalPrice = BigInteger.valueOf(0L);

        for (int i = 0; i < cityCnt - 1; i++) {
            nowCursor = i;
            nowPrice = oilMoney[i];

            if (nowPrice < prevPrice) {
                totalPrice = totalPrice.add(BigInteger.valueOf(nowPrice * loadLength[i]));
                prevCursor = nowCursor;
                prevPrice = nowPrice;
            } else {
                totalPrice = totalPrice.add(BigInteger.valueOf(prevPrice * loadLength[i]));
            }
        }
        System.out.println(totalPrice);
    }
}