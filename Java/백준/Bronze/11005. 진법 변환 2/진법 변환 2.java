import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] input = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");

        int number = Integer.parseInt(input[0]);
        int to = Integer.parseInt(input[1]);

        List<Integer> storage = new ArrayList<>();
        while (number > 0) {
            storage.add(number % to);
            number /= to;
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : storage) {
            if (integer > 9) {
                char temp = (char) (integer + 55);
                // System.out.println("temp : " + temp + "| number : " + (integer + 50));
                sb.append(temp);
            } else {
                sb.append(integer);
            }
        }

        System.out.println(sb.reverse());
    }
}
