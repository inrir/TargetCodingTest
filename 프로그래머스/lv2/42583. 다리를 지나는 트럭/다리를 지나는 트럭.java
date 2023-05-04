import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        // 까다로운 구현 생각해야 할 요소가 bridge_length, weight, truck_weigths 고려해야 한다. 
        
        int count = 0; // 이동 중 발생하는 시간 계산
        int sum = 0; // 다리를 건너는 트럭의 무게 추이
        for(int i = 0; i < truck_weights.length; i++){
            int tmp = truck_weights[i];
            
            
            while(true){ // 다리 내의 정보를 보여준다.
                if(queue.isEmpty()){ // 1. 트럭의 요소 고려
                    queue.add(tmp);
                    count++; // 이동 발생
                    sum += tmp; 
                    break; // 다음 대기 트럭을 넣어야 한다.
                }else if(queue.size() == bridge_length){ // 다리를 건너는게 만석이기 때문에 이동해야 한다.
                    // 2. 길이의 고려
                    sum -= queue.poll(); // 이동
                }else{ // 3. 무게의 고려
                    if(sum + tmp <= weight){
                        queue.add(tmp); // 추가해도 된다.
                        count++; 
                        sum += tmp;
                        break; // 다음 대기 트럭을 넣어야 한다.
                    }else{
                        queue.add(0); // 아무것도 넣지 않고 다리 길이를 채운다.
                        count++; // 다리를 건너는 트럭 사이에 이동이 발생한 경우로 고려
                    }
                }
                
            }
        }
        
        
        return count + bridge_length; // 마지막 트럭의 경우 길이 만큼 이동이 발생한다. 
    }
}