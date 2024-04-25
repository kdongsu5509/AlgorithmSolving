import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        ArrayList<Integer> Lost = new ArrayList<>();
        for (int temp : lost) {
            Lost.add(temp);
        }
        ArrayList<Integer> Reserve = new ArrayList<>();
        for (int temp : reserve) {
            Reserve.add(temp);
        }
        

        // 여분의 체육복을 가진 학생이 도난당한 경우 제거
        for (int x : lost) {
            if (Reserve.contains(x)) {
                Reserve.remove(Integer.valueOf(x)); // Integer 객체로 변환하여 삭제
                Lost.remove(Integer.valueOf(x));
            }
        }

        // 여분의 체육복을 빌려줄 수 있는 경우 처리
        for (int x2 : lost) {
            if (Reserve.contains(x2 - 1)) {
                Reserve.remove(Integer.valueOf(x2 - 1)); // Integer 객체로 변환하여 삭제
                Lost.remove(Integer.valueOf(x2));
            } else if (Reserve.contains(x2 + 1)) {
                Reserve.remove(Integer.valueOf(x2 + 1)); // Integer 객체로 변환하여 삭제
                Lost.remove(Integer.valueOf(x2));
            }
        }

        int answer = n - Lost.size();
        return answer;
    }
}