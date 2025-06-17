import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCnt; i++) {
            int[] sizes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Set<Integer> setA = new HashSet<>(sizes[0]);
            Set<Integer> setB = new HashSet<>(sizes[1]);

            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(setA::add);
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(setB::add);

            String result = compareSets(setA, setB);
            System.out.println(result);
        }
    }

    private static String compareSets(Set<Integer> setA, Set<Integer> setB) {
        if (setA.equals(setB)) {
            return "=";
        } else if (setB.containsAll(setA)) {
            return "<";
        } else if (setA.containsAll(setB)) {
            return ">";
        } else {
            return "?";
        }
    }
}
