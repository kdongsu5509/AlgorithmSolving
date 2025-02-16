import java.io.*;
import java.util.*;

public class Main {
    static int[] words;
    static int maxWordCnt = 0;
    static int baseMask = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int wordCnt = input[0];
        int k = input[1];

        if (k < 5) { // a,c,i,t,n 5개를 가르치지 않으면 anta, tica를 읽지 못함.
            System.out.println(0);
            return;
        }

        words = new int[wordCnt];
        
        // 필수 알파벳(a, c, t, i, n)을 비트마스크에 미리 포함
        baseMask |= (1 << ('a' - 'a'));
        baseMask |= (1 << ('c' - 'a'));
        baseMask |= (1 << ('t' - 'a'));
        baseMask |= (1 << ('i' - 'a'));
        baseMask |= (1 << ('n' - 'a'));

        for (int i = 0; i < wordCnt; i++) {
            String temp = br.readLine();
            temp = temp.substring(0, temp.length() - 4).substring(4); // "anta"와 "tica" 제거
            words[i] = getBitmask(temp);
        }

        // 남은 k-5개의 글자를 백트래킹으로 선택
        teachChar(k - 5, baseMask, 0);
        System.out.println(maxWordCnt);
    }

    // 해당 문자열을 비트마스크로 변환
    private static int getBitmask(String temp) {
        int bitmask = 0;
        for (int i = 0; i < temp.length(); i++) {
            bitmask |= (1 << (temp.charAt(i) - 'a'));
        }
        return bitmask;
    }

    private static void teachChar(int leftCnt, int mask, int start) {
        if (leftCnt == 0) {
            maxWordCnt = Math.max(maxWordCnt, compareToWordSet(mask));
            return;
        }

        for (int i = start; i < 26; i++) {
            // 이미 배운 글자는 스킵
            if ((mask & (1 << i)) != 0) continue;

            // 새 글자 추가하고 재귀 호출
            teachChar(leftCnt - 1, mask | (1 << i), i + 1);
        }
    }

    private static int compareToWordSet(int mask) {
        int cnt = 0;
        for (int wordMask : words) {
            // wordMask가 mask에 포함된 경우만 읽을 수 있음
            if ((wordMask & mask) == wordMask) cnt++;
        }
        return cnt;
    }
}