package univ.HotFixStudy.prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easy01 {
    /**
     * 백준 수열 2559번
     * 연속적인 범위의 합 구하기
     * N이 10^5인 점에서 이중 포문은 불가하다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = bf.readLine().split(" ");
        int N = Integer.parseInt(tmp[0]); // 테스트 케이스 수
        int K = Integer.parseInt(tmp[1]); // 연속적인 양의 수

        int[] nums = new int[N]; // 테스트 케이스 담는 그릇
        String[] tmp2 = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(tmp2[i]);
        }

        int big_sum = -1;
        for(int i = 0; i < N - K; i++){ // 10 -> 1? 라고 가면 안된다.
            int index = 0;
            int test_sum = 0;
            while(index != K){
                test_sum += nums[(i+index)];
                index++;
            }
            if(big_sum < test_sum) big_sum = test_sum;
        }

        System.out.println(big_sum);


    }
}
