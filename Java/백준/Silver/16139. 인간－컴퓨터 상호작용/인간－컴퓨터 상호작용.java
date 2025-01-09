import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine().trim();
        int totalQuestionCnt = Integer.parseInt(br.readLine().trim());

        // 알파벳별로 누적합 저장 (26개의 알파벳, 각 위치별 누적합)
        int[][] prefixSum = new int[26][S.length() + 1];

        // 문자열을 순회하면서 각 알파벳에 대해 누적합 계산
        for (int i = 0; i < S.length(); i++) {
            int currentChar = S.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                prefixSum[j][i + 1] = prefixSum[j][i]; // 이전 값 복사
            }
            prefixSum[currentChar][i + 1]++; // 현재 문자의 누적합 증가
        }

        // 질문 처리
        for (int i = 0; i < totalQuestionCnt; i++) {
            String[] query = br.readLine().split(" ");
            char targetChar = query[0].charAt(0);
            int start = Integer.parseInt(query[1]);
            int end = Integer.parseInt(query[2]) + 1; // inclusive

            // 해당 문자의 누적합 계산
            int result = prefixSum[targetChar - 'a'][end] - prefixSum[targetChar - 'a'][start];
            bw.write(result + "\n");
        }

        bw.flush();
    }
}
