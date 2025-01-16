import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int wholeCnt = Integer.parseInt(firstLine[0]);
        int tapeLen = Integer.parseInt(firstLine[1]);

        List<Integer> wholes = new ArrayList<>();
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(wholes::add);

        // 정렬
        Collections.sort(wholes);

        int usedTapeCnt = 0;
        double lastCovered = 0;

        for (int pos : wholes) {
            if (pos > lastCovered) {
                usedTapeCnt++;
                lastCovered = pos - 0.5 + tapeLen;
            }
        }

        System.out.println(usedTapeCnt);
    }
}
