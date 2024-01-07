import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        
        int answer = 0;
        // 낮은 수 부터 계속 진행해볼까? 시간 초과가 안 나올까???
        // 값을 넣으면 내부에서 우선 순위를 정해주는 방법??? => 우선 순위 큐..
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++){
            heap.offer(scoville[i]);
        }
        if(heap.peek() >= K) return 0;
        while(true){
            if(heap.size() == 1){
                return -1;
            }
            answer++; // 아래 섞는 과정이 진행된다.
            
            int first = heap.poll();
            int second = heap.poll();
            int mix = first + (second * 2);
            
            heap.offer(mix);
            
            if(heap.peek() >= K) break;
            
            
        }
        
        
        return answer;
    }
}