package Programmers;
import java.util.*;

public class Infomation {
    class Solution { // 개인정보 유효기간
        public int[] solution(String today, String[] terms, String[] privacies) {

            /**
             -1 먼저하고
             (일)N개월을 더하되. if 일 == 01 이라면 => 28일로 수정하고 N-1개월을 더한다.
             (월)13이 되는 경우 월 - 12, 년도 + 1

             최종적으로 하나씩 today와 비교하면서 찾기?
             */
            // int[] answer = {}; // 왜 배열로 설정했을까?
            ArrayList<Integer> ans = new ArrayList<>();
            HashMap<String, Integer> hashMap = new HashMap<>();
            int[] answer;

            for(int i = 0; i < terms.length; i++){ // A,B,C 별로 값 삽입
                hashMap.put(terms[i].substring(0,1), Integer.parseInt(terms[i].substring(2)));
            }

            int year = Integer.parseInt(today.substring(0,4)); // 2022
            int month =Integer.parseInt(today.substring(5,7)); // 05
            int day = Integer.parseInt(today.substring(8,10)); // 19
            int vs =  (year * 12 * 28) + (month * 28) + day;

            for(int i = 0; i < privacies.length; i++){
                int testYear = Integer.parseInt(privacies[i].substring(0,4));
                int testMonth = Integer.parseInt(privacies[i].substring(5,7));;
                int testDay = Integer.parseInt(privacies[i].substring(8,10));

                int cal = hashMap.get(privacies[i].substring(11,12));

                if(testDay == 1){
                    testDay = 28;
                    testMonth += cal - 1;
                    if(testMonth > 12){
                        testYear += 1;
                        testMonth -= 12;
                    }
                }else{
                    testDay -= 1;
                    testMonth += cal;
                    if(testMonth > 12){
                        testYear += 1;
                        testMonth -=12;
                    }
                }


                // 복잡하게 예외를 고려하기 보단 모든 더한 것으로 해보기
                int testVs =  (testYear * 12 * 28) + (testMonth * 28) + testDay;
                if(vs > testVs){
                    ans.add(i+1);
                }
            }

            // 값을 정리해서 answer에 준다.
            answer = new int[ans.size()];
            for(int i = 0; i<ans.size(); i++){
                answer[i] = ans.get(i);
            }
            return answer;
        }
    }
}
