import java.util.*;

class Solution {
    static int n;
    static int[][] computers;
    static boolean[] visited;
    static int visitedCnt;
    static int networkCnt;
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        
        visited = new boolean[n];
        visitedCnt = 0;
        networkCnt = 0;
        
        for(int i = 0 ; i < n ; i++) {
            if(!visited[i]) {
                dfs(i);
                networkCnt++;
            }
        }
        
        return networkCnt;
    }
    
    //네트워크 개수를 반환해야 한다.
    private void dfs(int idx) {
        visited[idx] = true;
        visitedCnt += 1;
        
        for (int i = 0; i < n; i++) {
            if (idx != i && computers[idx][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
    
    
}