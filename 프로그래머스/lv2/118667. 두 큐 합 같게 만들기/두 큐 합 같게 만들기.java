/**
pop과 insert 1회당 작업 1회
제일 최소로 하는 것

각 해당 queue의 값이 가장 클수록 빼고 넣고 하는 것을 반복한다.
rebalancing queue1_sum > = < queue2_sum
count++;
> queue1.pop(), queue2.insert() sum rebalancing about sum1,2
= 탐색 종료 return answer = count
< queue2.pop(), queue1.pop() sum rebalancing about sum1, 2

> -> < revert >= 3 return answer = -1
예외 케이스를 어떻게 분리시키는 지가 관건
1. queue1.sum + queue2.sum % 2 == 0
2. length * 3? 왜지?

*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        long queue1_sum = 0;
        long queue2_sum = 0;
        
        int length = queue1.length;
        int answer = -2;
        Queue<Long> queue_1 = new LinkedList<>(); 
        Queue<Long> queue_2 = new LinkedList<>(); 

        for(int i = 0; i < queue1.length; i++){
            queue1_sum += queue1[i];
            queue_1.add((long)queue1[i]);
        }

        for(int i = 0; i < queue2.length; i++){
            queue2_sum += queue2[i];
            queue_2.add((long)queue2[i]);
        }

        long tmp = 0;
        if((queue1_sum + queue2_sum)%2 != 0) return -1; // 예외 케이스 1번
        
        while(queue1_sum != queue2_sum){ // 같지 않는다면 계속 반복
            if(count >= length * 3) return -1; // 예외케이스 2번 (이유가 뭘까?)
            if(queue1_sum > queue2_sum){
                count++;
                tmp = queue_1.poll();
                queue1_sum -= tmp;
                queue2_sum += tmp;
                queue_2.add(tmp);

            }
            else if(queue1_sum < queue2_sum){
                count++;
                tmp = queue_2.poll();
                queue1_sum += tmp;
                queue2_sum -= tmp;
                queue_1.add(tmp);

            }
            else{ // 같을 경우인데 그런 경우는 안 옴
            }

           
        }
        answer = count;
        return answer;

    }
}