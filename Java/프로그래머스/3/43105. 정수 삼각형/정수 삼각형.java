class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;

        // 아래에서 위로 누적합 계산
        for (int i = n - 2; i >= 0; i--) { // 마지막 줄 바로 위부터 시작
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(
                    triangle[i + 1][j],
                    triangle[i + 1][j + 1]
                );
            }
        }

        // 꼭대기 값이 최댓값 경로의 합
        return triangle[0][0];
    }
}
