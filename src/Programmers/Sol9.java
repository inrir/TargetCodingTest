package Programmers;

public class Sol9 {
    class Solution {
        public int[] solution(int n, long left, long right) {
            // 몰라... -> 우선 그래도 구현한다면, N^2 => 10^(7*2) => overflow... 하나씩 다 채울 수 없다.
            // 모두 다 채웠다면 망했을 경우의 수다...
            // 범위인 점에서 Max(row, col) = 해당 값. + Long인 점을 고려해야한다.
            int length = (int)(right - left) + 1;
            int[] answer = new int[length];

            int index = 0; // answer 용 index
            for(long i = left; i < right+1; i++){
                int row = (int)(i / n) + 1;
                int col = (int)(i % n) + 1;
                answer[index++] = Math.max(row, col); // row, col에서 0을 고려할 필요없다는 것을 알 수 있다.
            }

            return answer;
        }
    }
}
