class Solution {
    public String solution(String rny_string) {
        StringBuilder sb = new StringBuilder();
        char[] temp = rny_string.toCharArray();
        int length = temp.length;
        for(int i = 0; i < length ; i++){
            if(temp[i] == 'm'){
                sb.append('r');
                sb.append('n');
            }
            else{
                sb.append(temp[i]);
            }
        }
        String answer = new String(sb);
        return answer;
    }
}