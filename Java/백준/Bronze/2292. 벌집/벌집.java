import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 입력받은 숫자
        int count = 1; // 최소 방의 개수, 1부터 시작
        int range = 2; // 최소 범위, 중앙의 1을 제외하고 시작

        if (N == 1) {
            System.out.println(1); // 1은 중앙에 있으므로 바로 1 출력
        } else {
            while (range <= N) { // 입력받은 숫자에 도달할 때까지 반복
                range = range + (6 * count); // 다음 범위는 현재 범위 + 6 * 현재 계층의 방 수
                count++; // 방의 계층 증가
            }
            System.out.println(count); // 도달한 계층 출력
        }
        scanner.close();
    }
}
