import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int houseCnt = Integer.parseInt(br.readLine());
        List<Integer> houseInfo = new ArrayList<>();

        Arrays.stream(br.readLine().split(" "))
              .mapToInt(Integer::parseInt)
              .forEach(houseInfo::add);

        Collections.sort(houseInfo);

        // 중앙값 (짝수일 경우, 앞쪽 인덱스)
        System.out.println(houseInfo.get((houseInfo.size() - 1) / 2));
    }
}
