import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        ArrayList<Character> temp = new ArrayList<>();
        String answer = "";

        // 모두 소문자로 변환
        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (c >= 'A' && c <= 'Z') { // 대문자인 경우
                temp.add((char) (c + 32)); // 소문자로 변환하여 추가
            } else {
                temp.add(c); // 소문자가 아니면 그대로 추가
            }
        }

        // ArrayList를 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (char c : temp) {
            sb.append(c);
        }
        answer = sb.toString();

        // 정렬
        char[] charArray = answer.toCharArray();
        Arrays.sort(charArray);
        answer = new String(charArray);

        return answer;
    }
}
