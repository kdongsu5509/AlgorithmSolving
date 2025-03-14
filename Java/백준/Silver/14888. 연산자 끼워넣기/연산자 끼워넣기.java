import java.io.*;
import java.util.*;

public class Main {

    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] operatorInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<String> operators = new ArrayList<>();
        String[] opSymbols = { "+", "-", "*", "/" };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < operatorInput[i]; j++) {
                operators.add(opSymbols[i]);
            }
        }

        permute(numbers, operators, new ArrayList<>(), new boolean[operators.size()]);

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    private static void permute(int[] numbers, List<String> operators, List<String> currentOps, boolean[] visited) {
        if (currentOps.size() == operators.size()) {
            calculate(numbers, currentOps);
            return;
        }

        for (int i = 0; i < operators.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                currentOps.add(operators.get(i));
                permute(numbers, operators, currentOps, visited);
                currentOps.remove(currentOps.size() - 1);
                visited[i] = false;
            }
        }
    }

    private static void calculate(int[] numbers, List<String> ops) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            switch (ops.get(i - 1)) {
                case "+":
                    result += numbers[i];
                    break;
                case "-":
                    result -= numbers[i];
                    break;
                case "*":
                    result *= numbers[i];
                    break;
                case "/":
                    result /= numbers[i];
                    break;
            }
        }

        maxVal = Math.max(maxVal, result);
        minVal = Math.min(minVal, result);
    }
}