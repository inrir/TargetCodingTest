import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];
        // 초 단위로 기록된 주식 가격..? => 문제 이해가 안된다... -> 시간대별로 떨어지는 추이
        // 1 (1) ->? 2 (2) ->? 3 (3) ->? 4 (2) ->? 5 (3) ?? 
        
//         for(int i = 0; i < len; i++){
//             for(int j = i + 1; j < len; j++){
//                 answer[i]++;
//                 if(prices[i] > prices[j]){
//                     break;
//                 }
                
//             }
//         }
        
        // 다시..
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            answer[stack.peek()] = len - stack.peek() - 1;
            stack.pop();
        }
        
        return answer;
    }
}