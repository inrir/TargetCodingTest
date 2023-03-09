package Programmers;

public class Sol11 {
    class Solution {
        public int solution(int n, int k) {
            // n -> k진수로 뽑아내기
            // 0을 통해 값을 분리하기
            // 분리된 값 중 1이 아닌 것들 카운팅 => answer
            int answer = 0;

            String tmp = nTok(n, k);
            String[] fin = tmp.split("0"); // 나중에 정수 변환 과정에서 상관 없긴 해. 01 => 1 취급.
            for(String check : fin){
                if(check.equals("")) continue;
                Long num = Long.parseLong(check); // 왜 Long 일까? -> 런타임에러로 숫자가 int에서 초과된다. 1번 15번?에서 발생
                if(isPrime(num)) answer++;

            }
            return answer;
        }

        public String nTok(int n, int k){ // n -> k진수 변환기
            String answer = "";

            while(n != 0){ // 어쨋든 0이 되면 모든 경우가 끝난 것이다.
                answer = n%k + answer; // 순서 맞추기
                n = n/k;
            }

            return answer;
        }

        public boolean isPrime(Long num){
            if(num <= 1){
                return false;
            }
            for(int i = 2; i<=Math.sqrt(num); i++){ // 49 반례로 등호를 넣는다.
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }기
    }
}
