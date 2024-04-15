import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<Integer> queue = new LinkedList<>();
        for (int temp : priorities) {
            queue.addLast(temp);
        }
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int priority : priorities) {
            priorityQueue.add(priority);
        }
        
        int answer = 0;
        while (!queue.isEmpty()) {
            int current = queue.pollFirst();
            if (current == priorityQueue.peek()) {
                priorityQueue.poll();
                answer++;
                if (location == 0) {
                    break;
                }
            } else {
                queue.addLast(current);
            }
            location = (location - 1 + queue.size()) % queue.size(); // location 업데이트
        }
        return answer;
    }
}
