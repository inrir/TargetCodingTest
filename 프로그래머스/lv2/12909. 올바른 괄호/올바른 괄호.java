import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        stack.push(s.charAt(0)); 
        for(int i = 1; i < s.length(); i++){
            if(!stack.isEmpty() && s.charAt(i) == ')' && stack.peek() == '('){ // map -> hard coding
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        if(!stack.isEmpty())
            answer = false;
        

        return answer;
    }
}