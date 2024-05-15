using System;

public class Solution {
    public string solution(string my_string, int n) {
        
        string answer = "";
        
        for(int i = 0 ; i < my_string.Length ; i++){
            for(int x = 0; x < n ; x++){
                answer += my_string[i];
            }
        }
        return answer;
    }
}