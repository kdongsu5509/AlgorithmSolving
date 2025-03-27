import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");

        String num = input[0];
        int b = Integer.parseInt(input[1]);

        long storage = 0L;
        int len = num.length();

        for (int i = 0; i < len; i++) {
            char temp = num.charAt(i);
            int digit;

            if (Character.isDigit(temp)) {
                digit = temp - '0';
            } else {
                digit = temp - 'A' + 10;
            }

            storage += digit * Math.pow(b, len - 1 - i);
        }

        System.out.println(storage);
    }
}
