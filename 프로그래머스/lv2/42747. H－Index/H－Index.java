import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        
        Arrays.sort(citations); // 0(5) 1(4) 3(3) 5 6
        int len = citations.length;
        
        for(int i = 0 ; i < len; i++){
            if(len - i <= citations[i]){
                answer = len - i; // 인용된 논문의 개수
                break;
            }
        }
        return answer;
    }
}