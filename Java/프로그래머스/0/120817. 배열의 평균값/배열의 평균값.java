import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        IntStream intStream = Arrays.stream(numbers);
        answer = intStream.sum();

        return answer / numbers.length;
    }
}
