package Programmers.sol0319;

public class Sol15 {
    public class Solution {
        public int solution(int n) {
            int ans = 1; // 무조건 발생하는 0 -> 1

            // 0 - 1(1)
            // 1 - 2 - 4 - 8 - 16
            // 2 - 2*2 - 2*2*2 - 2*2*2*2
            // 5000/2 => 2500 * 2 => 1250*4 => 625 * 8 =>
            // 6/2 => 3/2
            // ipad로 계속 그려본 결과 나머지 1의 총 개수의 합이다.
            while(n != 1){
                if(n%2 == 1){
                    ans++;
                }
                n = n/2;
            }

            return ans;
        }
    }

}
