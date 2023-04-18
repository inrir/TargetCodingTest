import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 효율성을 크게 잡아가는 건 queue 사용여부라서 List를 사용한 것은 크게 영향이 없는듯
        // 추가로 StringBuilder를 쓰는 방법도 좋을거라고 예상됨
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int value = 100 - progresses[i];
            
            if(value % speeds[i] != 0){ 
                value = value / speeds[i] + 1; // 소수점 존재시 올림처리
            }else{
                value = value / speeds[i];
            }
            
            queue.offer(value);
        }
        
        int count;
        while(!queue.isEmpty()){
            int tmp = queue.poll(); // 맨 앞에 수 출력
            count = 1;
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
