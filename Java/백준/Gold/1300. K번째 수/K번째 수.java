import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int left = 1, right = k;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = countLessEqual(n, mid);

            if (count >= k) { 
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static int countLessEqual(int n, int x) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += Math.min(x / i, n);
        }
        return count;
    }
}
