import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < phone_book.length; i++){
            map.put(phone_book[i], i); // map에 넣어준다.
        }
        
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0, j))){ // 동일한게 만날 수 없다. 부분 해시로 하나의 key를 판단할 수 있다.
                    return false;
                }
            }
        }
        

        return answer;
    }
}