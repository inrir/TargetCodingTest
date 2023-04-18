class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String input = s.toLowerCase();
        if(input.charAt(0) >= 'a' && input.charAt(0) <= 'z')
            answer.append((char)(input.charAt(0) - 32));
        else 
            answer.append(input.charAt(0));
        
        boolean check = false;
        for(int i = 1 ; i < input.length(); i++){
            if(input.charAt(i) == ' '){
                answer.append(' ');
                check = true;
            }else if(check && input.charAt(i) >= 'a' && input.charAt(i) <= 'z'){
                answer.append((char)(input.charAt(i) - 32));
                check = false;
            }else if(check && input.charAt(i) != ' '){
                check = false;
                answer.append(input.charAt(i));
            }else{
                answer.append(input.charAt(i));
            }
        }
        
        return answer.toString();
    }
}