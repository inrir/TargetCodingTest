package univ.week1.learning;

import java.util.Arrays;

/**
 * 프로그래머스 숫자게임
 *
 * input: A[], B[] => A[]는 유지, B[]는 근소한 차이로 이기도록
 *
 * output: 최대의 이김으로 갯수
 *
 * algo: B가 최대한 유지되면서 근소한 차이로 이기도록 한다.
 * [5, 1, 3, 7], [2, 2, 6, 8]
 *
 * 5 1 3 7
 * 8 2 6 2
 *
 * 1, 3, 5, 7
 * 2, 2, 6, 8
 *
 */
public class Step4 {

    public int solution(int[] A, int[] B){
        int answer = 0;

        Arrays.sort(B); // 정렬

        for(int i = 0; i<A.length; i++){
            for(int j = 0; j < B.length; j++){
                if(A[i] < B[j]){
                    answer++;
                    B[j] = 0;
                    break;
                }
            }
        }

        return answer;

    }
}
