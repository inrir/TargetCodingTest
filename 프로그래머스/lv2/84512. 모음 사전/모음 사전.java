import java.util.*;
class Solution {
    static List<String> list;
    static String[] arr;
    public int solution(String word) {
        int answer = 0;
        // 제한시간이 안 보이긴 한데.. A, E, I, O, U
        // 무조건 백트래킹 -> 생성 형식이 재귀적.. A -> AA -> .... AAAAA -> AAAAE -> AAAAI... 
        list = new ArrayList<>();
        arr = new String[]{"A", "E", "I", "O", "U"};
        DFS(0, "", word);
        
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(word)){ // 동일하다면 종료
                answer = i;
            }
        }
        
        return answer;
    }
    
    public void DFS(int depth, String value, String word){
        list.add(value);
            
        if(depth == 5){ // 깊이에 도달.
            return;
        }
        
        for(int i = 0; i < 5; i++){
            DFS(depth + 1, value + arr[i], word);
        }
        
        
        
    }
}