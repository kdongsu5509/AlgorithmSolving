class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int left = 0;
        int right = n - 1;
        int up = 0;
        int down = n - 1;
        int total = 1;
        
        while (total <= n * n) {
            // 오른쪽으로 이동
            for (int i = left; i <= right && total <= n * n; i++) {
                answer[up][i] = total++;
            }
            up++;
            
            // 아래로 이동
            for (int i = up; i <= down && total <= n * n; i++) {
                answer[i][right] = total++;
            }
            right--;
            
            // 왼쪽으로 이동
            for (int i = right; i >= left && total <= n * n; i--) {
                answer[down][i] = total++;
            }
            down--;
            
            // 위로 이동
            for (int i = down; i >= up && total <= n * n; i--) {
                answer[i][left] = total++;
            }
            left++;
        }
        
        return answer;
    }
}
