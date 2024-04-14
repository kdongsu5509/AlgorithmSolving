import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Deque<Integer> waiting = new LinkedList<>();
        Deque<Integer> passingWeight = new LinkedList<>();
        Deque<int[]> passingTotal = new LinkedList<>();
        
        for(int truck : truck_weights){
            waiting.add(truck);
        }
        
        while(true){
            if(!passingTotal.isEmpty() && passingTotal.getFirst()[1] >= bridge_length){
                passingTotal.removeFirst();
                passingWeight.removeFirst();
            }
            if(!waiting.isEmpty() && passingWeight.stream().mapToInt(Integer::intValue).sum() <= weight){
                if(!waiting.isEmpty() && passingWeight.stream().mapToInt(Integer::intValue).sum() + waiting.getFirst() <= weight){
                    int popped = waiting.removeFirst();
                    passingTotal.add(new int[] {popped, 0});
                    passingWeight.add(popped);
                }
            }
            answer++;
            for(int[] x : passingTotal) {
                x[1]++;
            }
            if(passingTotal.isEmpty()){
                break;
            }
        }
        
        return answer;
        
        
    }
}