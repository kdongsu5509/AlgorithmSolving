import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int subinPos = Integer.parseInt(input[0]);
        int findPos = Integer.parseInt(input[1]);

        int totalTime = 0;

        // 수직선 상에서의 BFS.
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[100002];

        // visited 가 필수일까...? 나는 아니라고 봄. 중복될 수도 있잖아 시발아.
        queue.add(new int[] { subinPos, 0 });
        visited[subinPos] = true;
        while (!queue.isEmpty()) {
            int[] curPosArr = queue.poll();
            int curPos = curPosArr[0];
            totalTime = curPosArr[1];
            visited[curPos] = true;

            if (curPos == findPos)
                break;

            int go = curPos + 1;
            int back = curPos - 1;
            int jump = curPos * 2;
            if (istGut(go) && !visited[go])
                queue.add(new int[] { go, totalTime + 1 });
            if (istGut(back) && !visited[back])
                queue.add(new int[] { back, totalTime + 1 });
            if (istGut(jump) && !visited[jump])
                queue.add(new int[] { jump, totalTime + 1 });
        }

        System.out.println(totalTime);
    }

    private static boolean istGut(int candidate) {
        return (candidate < 100001 && candidate > -1);
    }
}
