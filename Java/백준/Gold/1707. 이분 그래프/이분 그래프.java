import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCaseCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseCnt; i++) {
            boolean result = checkTheCase(br);
            bw.append(result ? "YES\n" : "NO\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean checkTheCase(BufferedReader br) throws IOException {
        String[] input = br.readLine().split(" ");
        int vertex = Integer.parseInt(input[0]);
        int edges = Integer.parseInt(input[1]);

        List<List<Integer>> adj = new ArrayList<>();
        int[] colors = new int[vertex];

        for (int i = 0; i < vertex; i++) {
            adj.add(new ArrayList<>());
            colors[i] = -1;
        }

        for (int x = 0; x < edges; x++) {
            input = br.readLine().split(" ");
            int ein = Integer.parseInt(input[0]) - 1;
            int zwei = Integer.parseInt(input[1]) - 1;
            adj.get(ein).add(zwei);
            adj.get(zwei).add(ein);
        }

        for (int i = 0; i < vertex; i++) {
            if (colors[i] == -1) {
                if (!isBipartite(adj, colors, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBipartite(List<List<Integer>> adj, int[] colors, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : adj.get(current)) {
                if (colors[neighbor] == -1) {
                    colors[neighbor] = 1 - colors[current];
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[current]) {
                    return false;
                }
            }
        }
        return true;
    }
}
