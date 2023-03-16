package Programmers.sol0319;
import java.util.*;

public class Sol16 {

    class Solution {
        public int solution(String s) {
            int answer = 0;

            // 무조건적으로 스택을 활용하는 문제다. 근데 HOW?
            // { [ (  연속으로 나온다면 놉 +1 아니면 +1
            // 아니 연속적인 공간을 어떻게 조율하지??

            // 결론 -> [ { ( 방향을 정해서 모든 패턴으로 해봐야한다. 그래야 모든 경우에 해당하는 올바른 값이 나온다... 모든 패턴을 확인하는 수단은 많다. 하나씩 뽑든 범위를 구분하든 쪼개서 본다.
            for(int i = 0; i < s.length() ; i++){
                Stack<Character> stack = new Stack<>();

                String str = s.substring(i, s.length()) + s.substring(0, i);

                for(int j = 0; j < str.length(); j++){
                    char tmp = str.charAt(j);
                    if(stack.isEmpty()){
                        stack.push(tmp);
                    }else if(tmp == ')' && stack.peek() == '('){
                        stack.pop();
                    }else if(tmp == '}' && stack.peek() == '{'){
                        stack.pop();
                    }else if(tmp == ']' && stack.peek() == '['){
                        stack.pop();
                    }else{
                        stack.push(tmp); // 해당하는 경우가 없다면 넣는다.
                    }

                }
                if(stack.isEmpty()){
                    answer++;

                }
            }


            return answer;
        }
    }
}
