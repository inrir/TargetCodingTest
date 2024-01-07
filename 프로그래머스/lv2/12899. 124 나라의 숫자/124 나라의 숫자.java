import java.util.*;
class Solution {
    public String solution(int n) {
        List<Integer> list = new ArrayList<>();
        String answer = "";
        // 124 값 순서대로 나열.
        // 1, 2, 4, 11, 12, 14, 21, 22, 24 .. 
        // 5 * 10 ^ 7 -> 백트래킹인가 규칙인가? => 규칙
        
        int[] nums = {4, 1, 2}; // 3 1 2
        
        int num = n;
        int value = 1;
        while(num > 0){ // 6 -> 0, 2 -> 2, 0
            value = num % 3;
            num /= 3;
            
            if(value == 0) num--;
            // answer = nums[value] + answer;
            list.add(nums[value]);
            
        }
        
        for(int i = 0; i <list.size(); i++){
            answer = list.get(i) + answer;
        }
        
        
        
        
        return answer;
    }
}