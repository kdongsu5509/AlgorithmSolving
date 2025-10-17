import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wordCount = Integer.parseInt(br.readLine()); // 4

        Map<String, String> wordMap = new HashMap<>();

        for (int i = 0; i < wordCount; i++) {
            String component = br.readLine().strip();

            wordMap.put(buildKey(component), component);
        }

        Integer.parseInt(br.readLine()); // 4

        String[] insane = br.readLine().split(" ");

        StringBuilder perfectSenteceBuilder = new StringBuilder();

        for (String insaneWord : insane) {
            String correctWord = wordMap.get(buildKey(insaneWord));
            perfectSenteceBuilder.append(correctWord + " ");
        }

        System.out.println(perfectSenteceBuilder.toString());
    }

    private static String buildKey(String word) {
        int wordLength = word.length();

        // 길이가 0 또는 1인 단어는 중간 문자열이 없습니다.
        if (wordLength <= 2) {
            // 길이가 1이면 "1:A" 형태, 길이가 2이면 "2:AB" 형태
            return wordLength + ":" + word;
        }

        // 1. 중간 문자열 추출
        String middle = word.substring(1, wordLength - 1);

        // 2. 중간 문자열 정렬 (유일성 확보의 핵심)
        char[] middleChars = middle.toCharArray();
        Arrays.sort(middleChars);
        String sortedMiddle = new String(middleChars);

        // 3. 최종 Key 구성: 길이:첫글자 + 정렬된_중간글자 + 마지막글자
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(wordLength).append(":");
        keyBuilder.append(word.charAt(0));
        keyBuilder.append(sortedMiddle); // 정렬된 중간 부분
        keyBuilder.append(word.charAt(wordLength - 1));

        return keyBuilder.toString();
    }
}
