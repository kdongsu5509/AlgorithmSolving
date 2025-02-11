import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        sc.close();

        int N = A.length();

        StringBuilder andResult = new StringBuilder();
        StringBuilder orResult = new StringBuilder();
        StringBuilder xorResult = new StringBuilder();
        StringBuilder notAResult = new StringBuilder();
        StringBuilder notBResult = new StringBuilder();

        for (int i = 0; i < N; i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);

            andResult.append((a == '1' && b == '1') ? '1' : '0');
            orResult.append((a == '1' || b == '1') ? '1' : '0');
            xorResult.append((a != b) ? '1' : '0');
            notAResult.append((a == '1') ? '0' : '1');
            notBResult.append((b == '1') ? '0' : '1');
        }

        System.out.println(andResult);
        System.out.println(orResult);
        System.out.println(xorResult);
        System.out.println(notAResult);
        System.out.println(notBResult);
    }
}
