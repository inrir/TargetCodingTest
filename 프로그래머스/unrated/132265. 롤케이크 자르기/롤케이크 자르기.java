import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0; // 공평하게 나눠지지 않은 경우
        Set<Integer> all = new HashSet<>();
        
        // hashmap으로 값 조절
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        
        
        
        for(int i = 0; i < topping.length; i++){
            all.add(topping[i]);
            hashMap.put(topping[i], hashMap.getOrDefault(topping[i], 0) + 1);
        }
        
        int all_size = all.size();
        Set<Integer> check = new HashSet<>(); // 비교 값
        for(int i = 0; i < topping.length; i++){
            check.add(topping[i]);
            if(hashMap.get(topping[i]) == 1){ 
                all_size--; // 중복 포함해서 없어지는 경우
            }else{
                hashMap.put(topping[i], hashMap.get(topping[i]) - 1);
            }
            
            if(check.size() == all_size) answer++;
            
        }
        
        
        
        
        return answer;
    }
}