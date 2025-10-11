import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        // 최대 30까지의 팩토리얼을 필요로 함.
        // 그럼 그냥 저장해두자!
        List<BigInteger> dp = new ArrayList<>();
        dp.add(BigInteger.ZERO);
        dp.add(BigInteger.ONE);
        dp.add(BigInteger.TWO);

        for (int i = 3; i < 31; i++) {
            BigInteger nextValue = dp.get(i - 1).multiply(BigInteger.valueOf(i));
            dp.add(nextValue);
        }
        // dp 값 생성 끝.

        for (int cnt = 0; cnt < testCase; cnt++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int m = input[1];
            int n = input[0];

            if (m == 0 || n == 0) {
                System.out.println(0);
                break;
            }

            int mMinusN = m - n;
            if (mMinusN == 0)
                mMinusN = 1;

            BigInteger child = dp.get(m);
            child = child.divide(dp.get(mMinusN));

            child = child.divide(dp.get(n));

            System.out.println(child);
        }
    }
}