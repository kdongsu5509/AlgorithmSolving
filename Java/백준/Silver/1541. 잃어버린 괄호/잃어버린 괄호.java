import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String userInput = br.readLine();

        String[] groups = userInput.split("-");

        int result = 0;

        for (int i = 0; i < groups.length; i++) {
            int groupSum = 0;

            String[] numbers = groups[i].split("\\+");
            for (String num : numbers) {
                groupSum += Integer.parseInt(num);
            }

            if (i == 0) {
                result += groupSum;
            } else {
                result -= groupSum;
            }
        }

        System.out.println(result);
    }
}
