package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Boj 1300 k번째 수
 *
 * input: N, K
 *
 * process: A(N*N)=> i*j => B 오름차순 정렬 => 일차원 배열
 *
 * output: B[k] ?
 *
 * algo:
 * 0,0 -> N-1, N-1 로 대각선으로 이동하되, 아래쪽 오른쪽으로 한칸씩 확대하면서 N-1로 다다르면 또 대각선으로 이동
 *
 */
public class Boj1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int K = Integer.parseInt(bf.readLine());

        int[][] A = new int[N][N];
        int[] B = new int[N*N];

        // 초기화
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                A[i][j] = (i+1)*(j+1);
            }
        }


        int index = 0;
        int index_B = 0;
        while(index != N){
            B[index_B] = A[index][index];
            index_B++;
            for(int i = 1; (index+i) < N; i++){
                B[index_B] = A[index + i][index];
                index_B++;
                B[index_B] = A[index][index + i];
                index_B++;
            }
            index++;
        }
        System.out.println(B[K-1]);
    }
}
