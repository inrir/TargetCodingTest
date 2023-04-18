import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++){
            int value = 100 - progresses[i];
            
            if(value % speeds[i] != 0){
                value = value / speeds[i] + 1;
            }else{
                value = value / speeds[i];
            }
            queue.offer(value);
        }
        while(!queue.isEmpty()){
            int tmp = queue.poll(); // 맨 앞에 수 출력
            System.out.println(tmp);
            int count = 1;
            while(!queue.isEmpty() && tmp >= queue.peek()){
                queue.poll();
                count++;
            }
            list.add(count);
            
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}