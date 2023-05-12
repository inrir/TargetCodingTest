import java.util.*;
class Solution {
    static int answer;
    static boolean[] visited;
    static Set<Integer> set;
    public int solution(String numbers) {
        // 숫자 조합에서 백트래킹 하기
        answer = 0;
        set = new HashSet<>();
        visited = new boolean[numbers.length()];
        
        DFS(0, numbers, "");
        return set.size();
    }
    
    public void DFS(int depth, String numbers, String value){
        if(value.length() > 0 && isPrime(Integer.parseInt(value))){
                set.add(Integer.parseInt(value));
        }
        
        if(depth == numbers.length()) return; // 분리해야만 확인할 수 있는 요소?
        
        for(int i = 0; i < numbers.length(); i++){
            if(visited[i]) continue;
            
            visited[i] = true;
    
            DFS(depth + 1, numbers, value + numbers.charAt(i));
            DFS(depth + 1, numbers, numbers.charAt(i) + value);
            
            visited[i] = false;
            
            
        }
        
        
    }
    
    public boolean isPrime(int num){ // 소수 판단
        if(num == 1 || num == 0) return false;
        for(int i = 2; i <= (int)Math.sqrt(num); i++){
            if(num % i == 0){
                return false; // 소수 아님
            }
        }
        return true; // 소수임
    }
    
    
}