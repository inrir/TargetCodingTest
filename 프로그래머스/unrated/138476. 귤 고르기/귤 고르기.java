import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        int[] arr = new int[tangerine.length];
        int[] count = new int[tangerine.length];
        int index = 0;
        arr[0] = tangerine[0];
        count[0]++;
        for(int i = 1; i < tangerine.length; i++){ // 1 1 1 2 2 2
            int tmp = tangerine[i];
            
            if(arr[index] == tangerine[i]){
                count[index]++; 
            }else{
                ++index;
                arr[index] = tangerine[i];
                count[index]++;
            }
        }
        
        Arrays.sort(count);
        
        for(int i = count.length - 1; i >= 0; i--){
            answer++;
            k -= count[i];
            if(k <= 0) break; 
        }
        
        
        
        
        return answer;
    }
}