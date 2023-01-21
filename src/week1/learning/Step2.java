package week1.learning;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * 프로그래머스 가장 큰 수
 *
 * input: 정수로 값을 내기에는 크기가 너무 크다.
 *
 * output:
 *
 * algo: 정수 -> 문자 -> 내림차순 -> 조합
 */

public class Step2 {

    static class Solution {
        public static void main(String[] args) {
//            int[] test = new int[]{6, 10, 2};
            int[] test = new int[]{3, 30, 34, 5, 9};
//            String solution = solution(test);
            System.out.println(solution(test));
        }
        public static String solution(int[] numbers) {
            String answer = "";
            String[] input = new String[numbers.length];
            for(int i = 0; i < numbers.length; i++){
//                input[i] = String.valueOf(numbers[i]);
                input[i] = "" + numbers[i];
            }

//            Arrays.sort(input, Collections.reverseOrder()); // 문자 내림차순으로 결정
            Arrays.sort(input, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return (s2+s1).compareTo(s1+s2); // 내림차순
                }
            });
            for(String a:input){
                answer += a;
            }
            return answer;
        }
    }
}
