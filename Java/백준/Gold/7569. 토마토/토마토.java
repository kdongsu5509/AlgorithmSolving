import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int garo = input[0];
        int sero = input[1];
        int height = input[2];
        
        boolean[][][] visited = new boolean[height][sero][garo];
        List<List<int[]>> boxInfo = new ArrayList<>();
        Queue<Element> queue = new LinkedList<>();
        
        for (int h = 0; h < height; h++) {
            List<int[]> level = new ArrayList<>();
            for (int y = 0; y < sero; y++) {
                int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                level.add(row);
                for (int x = 0; x < garo; x++) {
                    if (row[x] == 1) {
                        queue.add(new Element(x, y, h, 0));
                        visited[h][y][x] = true;
                    }
                }
            }
            boxInfo.add(level);
        }
        
        int result = BFS(queue, boxInfo, visited, garo, sero, height);
        System.out.println(result);
    }
    
    private static int BFS(Queue<Element> queue, List<List<int[]>> boxInfo, boolean[][][] visited, int garo, int sero, int height) {
        int[] dx = {-1, 1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dh = {0, 0, 0, 0, -1, 1};
        
        int maxDays = 0;
        
        while (!queue.isEmpty()) {
            Element curr = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];
                int nh = curr.h + dh[i];
                
                if (nx >= 0 && nx < garo && ny >= 0 && ny < sero && nh >= 0 && nh < height && !visited[nh][ny][nx] && boxInfo.get(nh).get(ny)[nx] == 0) {
                    visited[nh][ny][nx] = true;
                    boxInfo.get(nh).get(ny)[nx] = 1;
                    queue.add(new Element(nx, ny, nh, curr.dist + 1));
                    maxDays = Math.max(maxDays, curr.dist + 1);
                }
            }
        }
        
        for (int h = 0; h < height; h++) {
            for (int y = 0; y < sero; y++) {
                for (int x = 0; x < garo; x++) {
                    if (boxInfo.get(h).get(y)[x] == 0) {
                        return -1;
                    }
                }
            }
        }
        
        return maxDays;
    }
}

class Element {
    public int x;
    public int y;
    public int h;
    public int dist;
    
    public Element(int x, int y, int h, int dist) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.dist = dist;
    }
}
