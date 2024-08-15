package univ.Programmers.sol0319;

public class Sol18 {
    class Solution {
        public String solution(int n, int t, int m, int p) {
            /** 규칙
             0~9 숫자 말하고
             10이상 두음절로 말하기.

             다양한 진법으로 계산을 고려해야 한다.  t * m => 최대 10^3 * 10^2 = 10^5 완전탐색 가능.
             // 진법을 어떻게 보이나?? => Integer.toString(대상, 진법);
             */
            StringBuilder all = new StringBuilder();
            StringBuilder answer = new StringBuilder();

            for(int i = 0; i < t*m; i++){
                all.append(Integer.toString(i, n)); // 진법 변환된 값들이 담긴다.
            }

            for(int i = p - 1; i < t*m; i+=m){ // 순서에 해당하는 값을 뽑는다.
                answer.append(all.charAt(i));
            }

            return answer.toString().toUpperCase();

        }
    }
}
