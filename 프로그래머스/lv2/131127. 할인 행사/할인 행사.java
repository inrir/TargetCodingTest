import java.util.*;
class Solution {
    static HashMap<String, Integer> map;
    public int solution(String[] want, int[] number, String[] discount) {
        // 원하는 날 모두 할인 받을 수 있는 경우를 선택해야한다.
        // counting 해서 답변으로 준다.
        int answer = 0;
        map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]); // banana : 3
        }
        
        for(int i = 0; i < discount.length; i++){
            String[] temp = new String[10];
            int index = 0;
            while(true){
                if(i + index >= discount.length) break;
                temp[index] = discount[index + i];
                index++;
                if(index == 10) break;    
            }
            
            if(check(want, temp)) {answer++;
                                  // System.out.println(i + " " + temp[9]);
                                  }
            
            // System.out.println("??: " + i);
        }
        
        return answer;
    }
    
    public boolean check(String[] want, String[] temp){
        HashMap<String, Integer> count = new HashMap<>();
        
        for(int i = 0; i < temp.length; i++){
            count.put(temp[i], count.getOrDefault(temp[i], 0) + 1);
        }
        
        for(int i = 0; i < want.length; i++){
            if(count.getOrDefault(want[i], 0) < map.get(want[i])){
                return false;
            }
        }
        
        return true;
    }
}