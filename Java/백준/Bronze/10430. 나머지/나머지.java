import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[] inputValues = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
        int a = inputValues[0];
        int b = inputValues[1];
        int c = inputValues[2];

        int ein = (a + b) % c;
        bw.append(ein + "\n");
        int zwei = (a % c) + (b % c);
        zwei = zwei % c;
        bw.append(zwei + "\n");
        int drei = (a * b) % c;
        bw.append(drei + "\n");
        int fuer = (a % c) * (b % c);
        fuer = fuer % c;
        bw.append(fuer+"\n");
        bw.flush();
        
    }
}