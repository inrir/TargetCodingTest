import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        // 시간 초과 해결법..? stack을 써야하는데 어떻게 하지?
        // 동일한 문제 있음 꼭 숙지해야할 문제
        Stack<Integer> stack = new Stack<>(); // index 담기
        
        for(int i = 0; i < numbers.length; i++){
            if(stack.isEmpty() || numbers[i] < numbers[i - 1]){
                stack.push(i);
            }else{
                while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }
        
        
        while(!stack.isEmpty()){ // 비교하지 못한 값들을 -1 정리
            answer[stack.pop()] = -1;
        }
        
        
        return answer;
    }
}