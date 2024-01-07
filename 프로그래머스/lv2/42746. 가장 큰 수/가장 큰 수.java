import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        // 조합해야하지 않나? -> 아니고 정렬이다... 
        // o1 + o2 > o2 + o1
        String[] arr = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (o1, o2) -> { // (6 + 10) > (10 + 6) : 내림차순
            return (Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2));
        });
        
        if(arr[0].equals("0")) return "0";
        
        for(int i = 0; i < numbers.length; i++){
            answer += arr[i];
        }
        
        
        
        return answer;
        
    }
}