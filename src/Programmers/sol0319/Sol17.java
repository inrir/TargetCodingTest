package Programmers.sol0319;

import java.util.*;
public class Sol17 {

    class Solution {
        public int solution(String str1, String str2) {
        /*
        자카드 유사도 집합 A, B => 공집합일 경우, J(A, B) = 1 : 합집합 == 0 => 1
        두 글자씩 자르는데, 오직 영문자만 유효하다. => 다른 것을 거르기보단 영문자만 챙기기.
        대소문자 구분 없음 => 대문자로 통일.
        */
            // 모두 담아주고, 동일하게 겹치는 교집합 부분은 하나만 취급해주기.
            double answer;
            List<String> list1 = new ArrayList<>(); // str1 담는 통
            List<String> list2 = new ArrayList<>(); // str2 담는 통

            String str = str1.toUpperCase(); // 대문자로 변경
            int len = str.length();

            for(int i = 0; i < len; i++){ // 영문자 조각들만 담아주기
                if(i+1 < len && str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' && str.charAt(i+1) >= 'A' && str.charAt(i+1) <= 'Z'){
                    list1.add(str.substring(i,i+2));
                }
            }

            str = str2.toUpperCase();
            len = str.length();
            for(int i = 0; i < len; i++){ // 영문자 조각들만 담아주기
                if(i+1 < len && str.charAt(i) >= 'A' && str.charAt(i) <= 'Z' && str.charAt(i+1) >= 'A' && str.charAt(i+1) <= 'Z'){
                    list2.add(str.substring(i,i+2));
                }
            }

            int union = 0; // 합집합
            int inter = 0; // 교집합

            for(String tmp : list1){
                if(list2.remove(tmp)){
                    inter++;
                }
                union++;
            }

            for(String tmp : list2){
                union++;
            }

            if(union == 0){ // 모두 공집합인 경우이면 자카드 유사도는 1이다.
                answer = 1;
            }else{
                answer = (double) inter / (double) union;
            }

            return (int) (answer * 65536);

        }
    }
}
