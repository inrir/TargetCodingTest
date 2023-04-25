import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people); // 오름차순
        // 30 40 50 60 70
        // 순차적으로 한다면, 30 + 40, 50, 60, 70
        // 아래 로직대로면, 30 + 70, 40 + 60, 50 
        int min = 0;
        int max = people.length - 1;
        
        while(min <= max){ // 로직을 제대로 생각. -> 우선 2개만 가능하다는 점.
            if(people[min] + people[max] <= limit){
                min++;
            }
            max--;
            answer++;
        }
        
        // // 근데 왜 앞에서 순차적으로 다가갈 수 없는 걸까?
        // for(int i = 0 ; i < people.length; i++){
        //     if(i+1 < people.length && people[i] + people[i + 1] <= limit){
        //         i++;
        //     }
        //     answer++;
        // }
        
        
        return answer;
    }
}