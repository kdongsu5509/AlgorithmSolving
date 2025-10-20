import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 빠른 출력을 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder(); 

        Map<String, List<String>> dictionary = new HashMap<>();

        // 1. 사전 단어 처리
        int dictionaryWordCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < dictionaryWordCount; i++) {
            String word = br.readLine();
            String key = createMiniKey(word);
            
            // Map 사용의 모범 사례: computeIfAbsent를 사용하여 간결하게 처리
            dictionary.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        // 2. 검색 문장(혹은 단어 묶음) 처리
        // M개의 줄에 대해
        int searchSentenceCount = Integer.parseInt(br.readLine()); 
        
        for (int i = 0; i < searchSentenceCount; i++) {
            // 한 줄 전체(문장)를 읽고 공백으로 쪼갭니다.
            String sentence = br.readLine(); 
            String[] words = sentence.split(" ");
            
            long possibleCount = 1; // 경우의 수는 매우 커질 수 있으므로 long 사용!

            for (String word : words) {
                String key = createMiniKey(word);
                
                // Map에 해당 key가 존재하는지 확인하고, 개수를 곱합니다.
                List<String> matches = dictionary.get(key);
                
                if (matches != null) {
                    possibleCount *= matches.size();
                } else {
                    // 단어 하나라도 매칭되는 그룹이 없으면 경우의 수는 0
                    possibleCount = 0;
                    break; // 더 이상 곱할 필요가 없으므로 반복문 탈출
                }
            }
            
            sb.append(possibleCount).append("\n");
        }
        
        System.out.print(sb.toString());
    }
    
    // createMiniKey 함수는 완벽하므로 그대로 사용
    private static String createMiniKey(String word) {
        // ... (이전 코드와 동일)
        int length = word.length();
        if (length <= 2) {
            return word + length;
        }

        char firstChar = word.charAt(0);
        char lastChar = word.charAt(length - 1);

        String middlePart = word.substring(1, length - 1);
        char[] middleChars = middlePart.toCharArray();
        Arrays.sort(middleChars);
        String sortedMiddle = new String(middleChars);

        return firstChar + sortedMiddle + lastChar + length;
    }
}