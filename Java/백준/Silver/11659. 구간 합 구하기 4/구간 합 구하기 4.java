import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nUndm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> sumArrays = new ArrayList<>();
        int[] arrays = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        sumArrays.add(0);
        for(int i = 0 ; i < nUndm[0] ; i++) {
            sumArrays.add(sumArrays.get(i) + arrays[i]);
        }

        //입력 받자!
        for(int i = 0 ; i < nUndm[1] ; i++) {
            int[] startAndEndIdx = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.append(sumArrays.get(startAndEndIdx[1]) - sumArrays.get(startAndEndIdx[0] - 1) + "\n");
        }

        bw.flush();
    }
}