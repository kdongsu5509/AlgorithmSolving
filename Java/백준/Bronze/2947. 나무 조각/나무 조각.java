import java.util.*;
import java.util.stream.Stream;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputByConsole = br.readLine().split(" ");

        ArrayList<Integer> iterableInput = new ArrayList<>();
        Arrays.stream(inputByConsole).map(e -> Integer.parseInt(e)).forEach(e->iterableInput.add(e)); // 변환된 숫자를 출력

        ArrayList<Integer> answer = new ArrayList<>(List.of(1,2,3,4,5));

        while(!iterableInput.equals(answer)) {
            for(int i = 0 ; i < iterableInput.size() -1 ; i++) {
                if(iterableInput.get(i) > iterableInput.get(i+1)) {
                    int temp = iterableInput.get(i);
                    iterableInput.remove(i);
                    iterableInput.add(i+1, temp);
    
                    iterableInput.forEach(e-> System.out.print(e + " "));
                    System.out.println();
                }
            }
        }
    }
}
