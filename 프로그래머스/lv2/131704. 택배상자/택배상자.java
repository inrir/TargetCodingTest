import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int max = -1;
        
        for(int i = 0; i < order.length; i++){
            max = Math.max(order[i], max);
        }
        
        Stack<Integer> stack = new Stack<>(); // 보조 컨테이너
        int index = 1; // 계속 나오는 컨테이너
        boolean check = true;
        for(int i = 0; i < order.length; i++){
            while(check){
                if(index == order[i]){
                    index++;
                    answer++;
                    break;
                }else{
                    if(!stack.isEmpty()){
                        if(stack.peek() == order[i]){
                            stack.pop(); // 보조 컨테이너와 매칭됨
                            answer++;
                            break;
                        }
                    }
                    stack.push(index);
                    index++;
                    if(check && max < index){
                        return answer;
                    }
                }
            }
            check = true;
        }
        
        return answer;
    }
}