import java.util.ArrayList;

class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        //행 vs 열
        //추가.
        int row = arr.length;
        int col = arr[0].length;
        if(row == col){
            answer = arr;
        }
        else if(row > col){
            answer = addCol(arr, row, col);
        }
        else if(row < col){
            answer = addRow(arr, row, col);
        }
        
        return answer;
    }
    private int[][] addRow(int[][] arr, int row, int col){
        //row을 추가해야함. -> 가로 길이, 세로 길이.
        int[][] re = new int[col][col];
        
        int addTime = col - row;
        int[] newRow = new int[col];
        for(int i = 0 ; i < col ; i++){
            newRow[i] = 0;
        }
        //기존
        for(int x = 0 ; x < row ; x++){
            re[x] = arr[x];
        }
        //신규.
        for(int y = row ; y < addTime ; y++){
            re[y] = newRow;
        }
        
        return re;
        
    }
     private int[][] addCol(int[][] arr, int row, int col){
        //col을 추가해야함. -> 가로 길이, 세로 길이.
        //기존 row를 가져온 다음 -> 0을 추가해야함.
        int[][] re = new int[row][row];
        
        for(int a = 0 ; a < row ; a++){
            int[] t = arr[a];
            int[] part = new int[row];
            //행에 기존 내용 추가.
            for(int i = 0 ; i < col ; i++){
                part[i] = t[i];
            }
            //행에 새로운 내용 추가.
            for(int j = col ; j < row ; j++){
                part[j] = 0;
            }
            
            re[a] = part;
        }
        
        return re;
        
    }
    
}