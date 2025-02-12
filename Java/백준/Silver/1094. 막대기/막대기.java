import java.util.*;
import java.io.*;

//BJ_250212_1094
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int goal = sc.nextInt();

        // 막대 조각들을 저장할 자료 구조 stack
        Stack<Double> stack = new Stack<>();
        stack.push(64.0); // 초기 길이 64cm 막대

        // 목표 길이를 만들기 위한 최소 막대 개수 계산
        makeGoal(stack, goal, 64);
        System.out.println(stack.size());
    }

    // 목표 길이를 만들기 위한 최소 막대 개수를 구하는 함수
    private static void makeGoal(Stack<Double> stack, int goal, double totalLen) {
        // 종료 조건 -> 스택 내부 쪼가리들로 만들 수 있으면 재귀적 탐색 종료.
        if (sum(stack) == goal) {
            return;
        } else {
            double shortestPart = stack.pop();
            double toMoreSmall = shortestPart / 2;
            if (totalLen - toMoreSmall >= goal) { // 위에서 자른 막대의 절반 중 하나를 버리고 남아있는 막대의 길이의 합이 x보다 커거나 같은 경우
                stack.push(toMoreSmall);
                makeGoal(stack, goal, totalLen - toMoreSmall);
            } else {
                stack.push(toMoreSmall);
                stack.push(toMoreSmall);
                makeGoal(stack, goal, totalLen);
            }
        }
    }

    // stack에 있는 모든 막대의 길이를 합산하는 함수
    private static double sum(Stack<Double> stack) {
        double total = 0;
        for (double length : stack) {
            total += length;
        }
        return total;
    }
}