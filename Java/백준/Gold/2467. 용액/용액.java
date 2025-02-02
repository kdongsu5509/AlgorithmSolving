import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());

        List<Long> numbers = new ArrayList<>();

        Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).forEach(numbers::add);

        int left = 0;
        int right = numbers.size() - 1;

        List<Long> candidatesNumbers = new ArrayList<>();
        Long candiatesSum = Long.MAX_VALUE;
        while (left < right) {
            long tempL = numbers.get(left);
            long tempR = numbers.get(right);
            long temp = tempL + tempR;

            if (temp == 0) {
                addTocandidatesNumbers(candidatesNumbers, tempL, tempR);
                break;
            } else if (temp < 0) {
                left++;
            } else {
                right--;
            }

            if (Math.abs(temp) <= Math.abs(candiatesSum)) {
                candiatesSum = temp;
                addTocandidatesNumbers(candidatesNumbers, tempL, tempR);
            }

        }

        // Collections.sort(candidatesNumbers);
        bw.append(candidatesNumbers.get(0) + " " + candidatesNumbers.get(1));
        bw.flush();
    }

    private static void addTocandidatesNumbers(List<Long> candidatesNumbers, Long tempL, Long tempR) {
        candidatesNumbers.clear();
        candidatesNumbers.add(tempL);
        candidatesNumbers.add(tempR);
    }
}
