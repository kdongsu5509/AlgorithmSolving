import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int wholeCnt = Integer.parseInt(firstLine[0]);
        int totalCnt = Integer.parseInt(firstLine[1]);

        List<Integer> useCaseList = new ArrayList<>();
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(useCaseList::add);

        int IOCnt = 0;

        int cursor = 0;

        Set<Integer> nowUsing = new HashSet<>();
        Map<Integer, Integer> lastUsage = new HashMap<>();

        while (cursor < totalCnt) {
            int currentDevice = useCaseList.get(cursor);

            if (nowUsing.contains(currentDevice)) {
                cursor++;
                continue;
            }

            if (nowUsing.size() < wholeCnt) {
                nowUsing.add(currentDevice);
            } else {
                int deviceToReplace = -1;
                int farthestUse = -1;

                for (int device : nowUsing) {
                    int nextUseIdx = Integer.MAX_VALUE;
                    for (int i = cursor + 1; i < totalCnt; i++) {
                        if (useCaseList.get(i) == device) {
                            nextUseIdx = i;
                            break;
                        }
                    }
                    if (nextUseIdx > farthestUse) {
                        farthestUse = nextUseIdx;
                        deviceToReplace = device;
                    }
                }

                nowUsing.remove(deviceToReplace);
                nowUsing.add(currentDevice);
                IOCnt++;
            }

            cursor++;
        }

        System.out.println(IOCnt);
    }
}
