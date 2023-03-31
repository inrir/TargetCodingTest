import java.util.*;
class Solution {
    static HashMap<Character, Character> map;
    public String solution(String p) {
        String answer = dfs(p);
        /*
        if(p.equals(answer)){ // 1번
            return answer;
        }
        // 균형잡힌 결과로 분리하는 법?
        map = new HashMap<>();
        map.put('(',')');
        map.put(')','(');
        
        if(isPerfect(p)) return p; // 올바른 괄호 문자열인 경우 종료
        
        String u = p;
        String v = "";
        // answer
        int check;

        while(true){
            check = isBalance(u);
            if(check == u.length()){ // 끝난 경우
                if(isPerfect(u)){
                    answer += u;
                    return answer;
                }else{
                    answer += reverse(u);
                    return answer;
                }
            }else{
                v = u.substring(check, u.length());
                u = u.substring(0, check);
                if(isPerfect(v)){
                    if(u.length() == isBalance(u)){
                        answer += reverse(u) + v;
                        return answer;
                    }else{
                        answer += v;
                    }
                }else if(isPerfect(u)){
                    answer += u;
                    u = v; // v가 올바르지 않음.
                }
                // System.out.println(reverse(u)+ "???" + u + " ?? " + v);
            }
        }
        
        // return answer;
    }
    
    public String reverse(String input){ // 문자의 괄호 방향을 뒤집는 형태
        String answer = "";
        if(input.length() <= 2){
            answer = "()";
        }else{
            for(int i = 1; i < input.length() - 1; i++){
                if(input.charAt(i) == ')'){
                    answer += "(";
                }else{
                    answer += ")";
                }
            }
            answer = "(" + answer + ")";
        }
        */
        return answer;
    }
    
    public String dfs(String str){ // 참고
        int cnt = 0, idx = 0, len = str.length();
        String result = "";
        //1
        if(str.equals("")) return str;
        while(idx < len){
            char c = str.charAt(idx++);
            if(c == '(') cnt++;
            else cnt--;
            if(cnt == 0) break;
        }
        
        // 2
        String u = str.substring(0, idx);
        String v = str.substring(idx, len);
        
        // 3
        if(isPerfect(u)){
            result = u + dfs(v);
        }
        else{
            result = "(" + dfs(v) + ")";
            int ulen = u.length();
            for(int i = 1; i<ulen-1; i++){
                char c = u.charAt(i);
                if (c == '(') result += ')';
                else result += '(';
            }
        }
        
        return result;
        
        
    }
    
    public int isBalance(String input){ // 균형잡힌 문자열인 것을 확인
        Stack<Character> stack = new Stack<>();
        stack.push(input.charAt(0));
        for(int i = 1; i < input.length(); i++){
            if(stack.isEmpty()){
                return i; // 해당 인덱스
            }
            if(input.charAt(i) == map.get(stack.peek())){ // 균형잡힌 갯수를 파악할 수 있다. 
                stack.pop();
            }else{
                stack.push(input.charAt(i));
            }
        }
        if(stack.isEmpty()){
            return input.length();
        }else{
            return -1; //균형잡힌 문자열 없음
        }
        
        
    }
    public boolean isPerfect(String input){ // 올바른 문자열 확인
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < input.length(); i++){
            if(!stack.isEmpty() && stack.peek() == '(' && input.charAt(i) == ')'){
                stack.pop();
            }else{
                stack.push(input.charAt(i));
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}
/*
1. 입력이 빈 문자열인 경우, 빈 문자열 반환
2. W => 균형잡힌 괄호 문자열 u, v로 분리
3. if u is 올바른 괄호 문자열, v -> 1단계 이후 u + v 반환
4. if u is not 올바른 괄호 문자열, 
4-1. emtpy = '(' + "";
4-2 "(" + v + ")" + reverse u.substring(1, u.length-1);
4-3 반환

*/