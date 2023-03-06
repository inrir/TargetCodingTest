package Programmers;

import java.util.*;
public class Sol7 {
    class Solution
    {
        public int solution(String s)
        {
            // 정답 보고 1일 뒤 시작. -> 자료구조 숙지 필요.
            // stack을 쓰는 것이 for을 쓸때 보다 몇배 더 효율설 보장 -> 자료구조 기본 초급 중급 숙지
            Stack<Character> stack = new Stack<>();
            for(char tmp : s.toCharArray()){
                if(!stack.isEmpty() && stack.peek() == tmp){
                    stack.pop(); // 중복되는 쌍이 발견돼었기 때문에 삭제.
                }else{
                    stack.push(tmp); // 2개의 쌍이 없는 경우는 새로 넣어주기
                }
            }

            if(stack.isEmpty()){ // 없는 경우 삭제.
                return 1;
            }else{
                return 0;
            }

        }
    }
}
