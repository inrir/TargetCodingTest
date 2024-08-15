package univ.HotFixStudy.errorDetect;
import java.util.*;
public class Error1 {
    public static void main(String[] args) {
//        String s = "(()(";
        String s = ")()(";
        System.out.println(solution(s));
    }
        static boolean solution(String s) {
            boolean answer = true;
            Stack<Character> stack = new Stack<>();
            HashMap<Character, Character> map = new HashMap<>();

            map.put('(', ')');
            stack.push(s.charAt(0));
            for(int i = 1; i < s.length(); i++){
                if(!stack.isEmpty() && s.charAt(i) == map.getOrDefault(stack.peek() , ' ')){
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
