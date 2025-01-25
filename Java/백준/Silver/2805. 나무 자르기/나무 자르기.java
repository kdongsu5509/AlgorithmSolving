import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int treeCnt = firstLine[0];
        int needTreeMeter = firstLine[1];

        List<Integer> treeInfo = new ArrayList<>();
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(e -> treeInfo.add(e));

        // 나무의 높이를 내림차순 정렬
        Collections.sort(treeInfo, Collections.reverseOrder());

        int left = 0;
        int right = treeInfo.get(0); // 가장 높은 나무의 높이
        int result = 0;

        // 이분 탐색 시작
        while (left <= right) {
            int mid = (left + right) / 2; // 현재 절단 높이

            // 현재 높이로 잘랐을 때 얻을 수 있는 나무 길이 계산
            long total = calculateWood(treeInfo, mid);

            if (total >= needTreeMeter) {
                // 필요한 나무 길이보다 크거나 같으면 절단 높이를 높임
                result = mid;
                left = mid + 1;
            } else {
                // 필요한 나무 길이보다 작으면 절단 높이를 낮춤
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    // 특정 높이로 잘랐을 때 얻을 수 있는 나무 길이 계산
    private static long calculateWood(List<Integer> treeInfo, int height) {
        long total = 0;
        for (int tree : treeInfo) {
            if (tree > height) {
                total += (tree - height);
            } else {
                break; // 정렬되어 있으므로 이후는 모두 높이가 height 이하
            }
        }
        return total;
    }
}
