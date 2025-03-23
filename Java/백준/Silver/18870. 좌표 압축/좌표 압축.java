import java.io.*;
import java.util.*;

public class Main {
    static int[] input;
    static int size;
    static Map<Integer, Integer> mapper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        TreeSet<Integer> minimize = new TreeSet<>();

        size = Integer.parseInt(br.readLine());
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).peek(minimize::add).toArray();

        List<Integer> sorted = new ArrayList<>();
        minimize.forEach(sorted::add);

        mapper = new HashMap<>();

        int x = 0;
        for (int i = 0; i < sorted.size(); i++) {
            mapper.put(sorted.get(i), x++);
        }

        for (int i = 0; i < size; i++) {
            bw.append(mapper.get(input[i]) + " ");
        }

        bw.flush();
    }
}
