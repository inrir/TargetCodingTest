import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        // 인덱스 원소 사이의 모두 포함하는 부분 수열. 합은 k
        // 중복시 길이가 제일 짧은 것 혹은 
        // 여러 개인 경우 앞쪽에 나온 수열
        // stack? pop? no two pointer
        
        int N = sequence.length;
        int right = N;
        int left = 0;
        int sum = 0;
       
        for(int L = 0, R = 0; L < N; L++){
            // R을 최초 초기화와 주기적 초기화 차이
            // 단방향 선순환이 가능함. 이중 for과 two pointer 차이
            while(R < N && sum < k){
                sum += sequence[R++];    
            }
            
            if(sum == k){
                int range = R - L - 1;
                if((right - left) > range){
                    left = L;  
                    right = R - 1; // ++ 자동갱신 문제  
                }
            }
            
            sum -= sequence[L];
            
        }
        
        answer[0] = left;
        answer[1] = right;
        
        
        return answer;
    }
}