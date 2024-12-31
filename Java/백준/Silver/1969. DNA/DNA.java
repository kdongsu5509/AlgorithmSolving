import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. DNA 개수와 각 DNA의 길이를 입력받는다.
        String[] lengthInputValue = br.readLine().split(" ");
        int numberOfDNA = Integer.parseInt(lengthInputValue[0]);
        int lengthOfDNA = Integer.parseInt(lengthInputValue[1]);

        // 2. DNA 정보 입력받기
        String[] DNAInfo = new String[numberOfDNA];
        for (int i = 0; i < numberOfDNA; i++) {
            DNAInfo[i] = br.readLine();
        }

        // 3. 최소 Hamming Distance DNA 계산
        StringBuilder consensusDNA = new StringBuilder();
        int totalHammingDistance = 0;

        for (int i = 0; i < lengthOfDNA; i++) {
            int[] nucleotideCount = new int[4]; // A, C, G, T 카운트
            for (String dna : DNAInfo) {
                char nucleotide = dna.charAt(i);
                if (nucleotide == 'A') nucleotideCount[0]++;
                else if (nucleotide == 'C') nucleotideCount[1]++;
                else if (nucleotide == 'G') nucleotideCount[2]++;
                else if (nucleotide == 'T') nucleotideCount[3]++;
            }

            // 가장 많이 나타나는 염기를 선택
            int maxCount = 0;
            char mostFrequent = 'A';
            for (int j = 0; j < 4; j++) {
                if (nucleotideCount[j] > maxCount) {
                    maxCount = nucleotideCount[j];
                    mostFrequent = "ACGT".charAt(j);
                }
            }
            consensusDNA.append(mostFrequent);

            // 다른 DNA와의 Hamming Distance 계산
            totalHammingDistance += (numberOfDNA - maxCount);
        }

        // 4. 결과 출력
        System.out.println(consensusDNA);
        System.out.println(totalHammingDistance);
    }
}
