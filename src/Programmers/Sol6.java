package Programmers;

public class Sol6 {
    class Solution {
        public int count = 0; // 0 개수 세는 기계
        public int[] solution(String s) {
            // 이진변환: 1. 0을 모두 제거 2. 해당 길이로 2진수 생성
            // result: [이진변환된 번수, 0을 제거한 개수]
            int[] answer = new int[2];
            int index = 0; // 이진변환
            while(!s.equals("1")){
                s = NumToString(StringToNum(s));
                index++;
            }
            answer[0] = index;
            answer[1] = count;
            return answer;
        }

        public int StringToNum(String s){
            int answer = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.substring(i,i+1).equals("0")){
                    count++;
                }else{
                    answer++;
                }
            }
            return answer;
        }

        public String NumToString(int i){
            String answer ="";
            String real = "";
            while(i != 1){
                answer += ""+(i%2);
                i = i/2;
            }
            answer += "1";

            for(int a = answer.length(); a > 0; a--){
                real += answer.substring(a-1, a);
            }
            return real;
        }
    }
}
