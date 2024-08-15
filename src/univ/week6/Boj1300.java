package univ.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Boj 1300 k번째 수
 *
 * input: N, K + 배열의 첫 인덱스는 1
 *
 * process: A(N*N)=> i*j => B 오름차순 정렬 => 일차원 배열
 *
 * output: B[k] ?
 *
 * algo:
 * 0,0 -> N-1, N-1 로 대각선으로 이동하되, 아래쪽 오른쪽으로 한칸씩 확대하면서 N-1로 다다르면 또 대각선으로 이동
 *
 * for - for: 브루트 포스 방식에서 메모리 초과 문제 발생
 * https://st-lab.tistory.com/281 => 이분 탐색
 *
 */
public class Boj1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int K = Integer.parseInt(bf.readLine());


        // x는 lo <= x <= hi 의 범위를 갖는다.
        long left = 1;
        long right = K; // why don't you use N*N.. over..

        // lower-bound
        while(left < right) {

            long mid = (left + right) / 2;	// 임의의 x(mid)를 중간 값으로 잡는다.
            long count = 0;

            /*
             *  임의의 x에 대해 i번 째 행을 나눔으로써 x보다 작거나 같은 원소의 개수
             *  누적 합을 구한다.
             *  이 때 각 행의 원소의 개수가 N(열 개수)를 초과하지 않는 선에서 합해주어야 한다.
             */
            for(int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            // count가 많다는 것은 임의의 x(mid)보다 작은 수가 B[K]보다 많다는 뜻
            if(K <= count) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
