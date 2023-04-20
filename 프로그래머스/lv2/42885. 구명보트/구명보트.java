import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people); // 오름차순
        
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){ // 로직을 제대로 생각. -> 우선 2개만 가능하다는 점.
            if(people[left] + people[right] <= limit){
                left++;
            }
            right--;
            answer++;
        }
        
        // 근데 왜 앞에서 순차적으로 다가갈 수 없는 걸까?
        
        return answer;
    }
}