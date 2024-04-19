class Solution {
    public int solution(int[][] board, int k) {
        int answer = 0;
        int rowSize = board.length;
        int colSize = board[0].length;
        for(int i = 0 ; i< rowSize ; i++){
            for(int j = 0 ; j < colSize ; j++){
                if(i + j <= k){
                    answer += board[i][j];
                }
            }
        }
        return answer;
    }
}