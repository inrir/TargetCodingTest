package Programmers;

public class Sol13 {
    class Solution {
        public String solution(String new_id) {
        /*
        1. 모든 대문자 -> 소문자 치환
        2. 예외 경우 모두 제거.
        3. ".." 혹은 연속된 부분을 하나로 치환
        4. . 처음 혹은 끝인 경우 제거
        5. 빈 문자열이면 new_id = "a"
        6. 길이가 16자 이상이라면, 첫 15자를 제외한 모든 문자 제거. if 제거 후, "."가 끝에 위치한다면 제거
        7. 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될때까지 반복 추가. 0 => aaa 1, bbb 2.abb
        */

            //처리 과정 5
            if(new_id.length() == 0){
                return "aaa";
            }

            String answer = new_id.toLowerCase(); // 처리과정 1
            String tmp = "";

            for(int i = 0; i < answer.length(); i++){ // 처리과정 2
                if(answer.charAt(i) >= 'a' && answer.charAt(i) <= 'z' || answer.charAt(i) == '-' || answer.charAt(i) == '_' || answer.charAt(i) == '.' || answer.charAt(i) >= '0' && answer.charAt(i) <= '9'){
                    tmp = tmp + answer.charAt(i);
                }
            }
            // 처리 과정 3
            answer =tmp.replaceAll("\\.+","."); // 연속된 문자를(\\.: 문자 표현, + 1번 이상(즉 연속된)) -> 하나로 치환식

            // 처리 과정 4
            if(answer.charAt(0) == '.'){
                if(answer.length() == 1) return "aaa";
                answer = answer.substring(1,answer.length());
            }

            if(answer.charAt(answer.length() - 1) == '.'){
                answer = answer.substring(0, answer.length()-1);
            }


            // 처리 과정 6
            if(answer.length() >= 16){
                answer = answer.substring(0,15);
                if(answer.charAt(answer.length() - 1) == '.'){
                    answer = answer.substring(0,14);
                }
            }

            // 처리 과정 7
            if(answer.length() == 2){
                answer = answer + answer.charAt(1);
            }
            if(answer.length() == 1){
                answer = answer + answer + answer; // 자바는 곱셈으로 할 수 없음.
            }



            return answer;
        }
    }
}
