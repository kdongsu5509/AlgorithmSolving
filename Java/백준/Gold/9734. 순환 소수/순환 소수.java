import java.util.Scanner;

public class Main {

    /**
     * 유클리드 호제법을 이용한 최대공약수(GCD) 계산
     */
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * 분자와 분모를 최대공약수로 나누어 기약분수를 문자열로 반환
     */
    public static String simplifyFraction(long numerator, long denominator) {
        if (numerator == 0) {
            return "0 / 1";
        }

        long g = gcd(numerator, denominator);

        // 최종 분모가 양수가 되도록 부호를 처리
        long sign = 1;
        if (denominator < 0) {
            sign = -1;
        }

        long finalNumerator = numerator / g * sign;
        long finalDenominator = denominator / g * sign;

        return finalNumerator + " / " + finalDenominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력이 여러 줄로 들어오므로, EOF(End Of File)까지 반복
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty() || line.isBlank()) {
                break;
            }

            int dotIndex = line.indexOf('.');

            // 괄호 '('와 ')' 위치 찾기
            int openParenIndex = line.indexOf('(');
            int closeParenIndex = line.indexOf(')');

            String nonRepeatingPart = ""; // 순환하지 않는 소수부
            String repeatingPart = ""; // 순환 마디

            // 순환마디가 없는 경우 (유한소수)
            if (openParenIndex == -1) {
                if (dotIndex != -1) {
                    nonRepeatingPart = line.substring(dotIndex + 1);
                }

                // 유한소수 처리: X.Y -> XY / 10^|Y|
                long numerator = 0;
                long denominator = 1;

                // 정수부와 소수부를 합친 전체 숫자 계산
                try {
                    numerator = Long.parseLong(line.replace(".", ""));
                } catch (NumberFormatException e) {
                    // 입력이 너무 길거나 이상할 경우의 처리 (문제 조건상 최대 9개 숫자이므로 Long 범위 내)
                    // 여기서는 문제 조건에 따라 단순 처리
                }

                // 분모 계산 (10^|Y|)
                for (int i = 0; i < nonRepeatingPart.length(); i++) {
                    denominator *= 10;
                }

                System.out.println(line + " = " + simplifyFraction(numerator, denominator));
                continue;
            }

            // 순환소수 처리 (X.Y(Z) 형태)

            // 1.1. 정수부 X 추출 (문제 조건상 분수로 바꿀 때만 필요)
            String integerPartStr = line.substring(0, dotIndex);
            long integerPart = Long.parseLong(integerPartStr);

            // 1.2. 순환하지 않는 소수부 Y 추출
            if (dotIndex + 1 < openParenIndex) {
                nonRepeatingPart = line.substring(dotIndex + 1, openParenIndex);
            }

            // 1.3. 순환 마디 Z 추출
            repeatingPart = line.substring(openParenIndex + 1, closeParenIndex);

            // 2. 분모 (Denominator) 계산

            // 2.1. 9의 개수 (순환마디 길이)
            long denominator = 0;
            for (int i = 0; i < repeatingPart.length(); i++) {
                denominator = denominator * 10 + 9;
            }

            // 2.2. 0의 개수 (순환하지 않는 소수부 길이)
            for (int i = 0; i < nonRepeatingPart.length(); i++) {
                denominator *= 10;
            }

            // 3. 분자 (Numerator) 계산

            // 3.1. 소수점 아래 전체 숫자 (YZ)
            String wholeDecimalStr = nonRepeatingPart + repeatingPart;
            long wholeDecimal = 0;
            if (!wholeDecimalStr.isEmpty()) {
                wholeDecimal = Long.parseLong(wholeDecimalStr);
            }

            // 3.2. 순환하지 않는 부분 (Y)
            long nonRepeatingNum = 0;
            if (!nonRepeatingPart.isEmpty()) {
                nonRepeatingNum = Long.parseLong(nonRepeatingPart);
            }

            // 3.3. 소수부의 분자 (fractionalNumerator)
            long fractionalNumerator = wholeDecimal - nonRepeatingNum;

            // 3.4. 최종 분자 (정수부 포함)
            // Final Numerator = IntegerPart * Denominator + FractionalNumerator
            long finalNumerator = integerPart * denominator + fractionalNumerator;

            // 4. 약분 및 출력
            System.out.println(line + " = " + simplifyFraction(finalNumerator, denominator));
        }
        scanner.close();
    }
}