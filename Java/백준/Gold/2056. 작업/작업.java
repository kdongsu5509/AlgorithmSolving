import java.io.*;
import java.util.*;

public class Main {
    static int taskCnt;
    static List<List<Integer>> taskInfo = new ArrayList<>();
    static int[] taskTime;
    // static boolean[] isDone;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        taskCnt = Integer.parseInt(br.readLine());

        // 1. 각종 static 값 초기화
        for (int i = 0; i < taskCnt; i++) {
            taskInfo.add(new ArrayList<>());
        }

        taskTime = new int[taskCnt];
        // isDone = new boolean[taskCnt];
        dp = new int[taskCnt];

        // 2. 작업들의 정보 입력받아 저장.
        for (int i = 0; i < taskCnt; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int time = input[0];
            int prevTaskCnt = input[1];

            taskTime[i] = time;

            List<Integer> taskInfoElement = taskInfo.get(i);
            for (int x = 0; x < prevTaskCnt; x++) {
                taskInfoElement.add(input[2 + x] - 1); // 작업 우선 순위 시작을 1 -> 0으로 전환
            }
        }

        // 3. dp를 이용하여 최단 시간 계산
        dp[0] = taskTime[0];
        // isDone[0] = true;
        for (int i = 1; i < taskCnt; i++) {
            // 2순위 작업부터 파악. -> 1순위는 되었다고 가정

            // a. 작업 I의 선행 작업들 가져오기
            List<Integer> myPrevTask = taskInfo.get(i);
            // b. 해당 작업들 중 가장 마지막에 끝난 작업의 종료 시간 가져오기
            int endingTime = 0;
            for (int prevTaskTime : myPrevTask) {
                endingTime = Math.max(endingTime, dp[prevTaskTime]);
            }
            // c. 순차 작업 vs 병렬 작업 비교.
            // int sequenceTime = dp[i - 1] + taskTime[i];
            int concurrentTime = endingTime + taskTime[i];

            // dp[i] = Math.min(sequenceTime, concurrentTime);
            dp[i] = concurrentTime;
            // isDone[i] = true;
            // debuggingPrint(i, endingTime);
        }

        // dp 순회하면서 최대값을 찾아 출력
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    // static void debuggingPrint(int nodeIdx, int endingTime) {
    //     System.out.println("the node number : " + nodeIdx + "  ending time : " + endingTime);
    //     System.out.println("====dp array======");
    //     for (int x = 0; x < taskCnt; x++) {
    //         System.out.print(dp[x] + "  ");
    //     }
    //     System.out.println();
    // }
}