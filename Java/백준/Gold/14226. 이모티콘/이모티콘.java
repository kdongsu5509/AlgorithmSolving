import java.util.*;

class Main {
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        visited = new boolean[2000 + 1][2000 + 1];

        int min = bfs(input);
        System.out.println(min);
    }

    static int bfs(int target) {
        Deque<int[]> queue = new LinkedList<>();
        visited[1][0] = true;
        queue.add(new int[] { 1, 0, 0 });

        while (queue.size() != 0) {
            int[] cur = queue.poll();
            int show = cur[0];
            int board = cur[1];
            int time = cur[2];

            if (show == target)
                return time;

            if (!visited[show][show]) {
                visited[show][show] = true;
                queue.add(new int[] { show, show, time + 1 });
            }

            // 2. 붙여넣기
            if (board > 0 && show + board <= 2000 && !visited[show + board][board]) {
                visited[show + board][board] = true;
                queue.add(new int[] { show + board, board, time + 1 });
            }

            // 3. 삭제
            if (show > 0 && !visited[show - 1][board]) {
                visited[show - 1][board] = true;
                queue.add(new int[] { show - 1, board, time + 1 });
            }

        }

        return -1;
    }

}