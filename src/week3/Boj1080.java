package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Boj 1080 행렬
 *
 * input: N M
 *
 * 3 * 3 변환 연산 -> count
 * (0,0) -> (0,1) or (1,0)과 같이 3*3의 (0,0) 기준으로 확인하고 동일하지 않을시 바꿔주도록 한다.
 * 모든 확인이 끝난 후에도 동일하지 않은 부분 존재시 -1로 반환 or 동일시 cnt로 반환
 * output: count
 */
public class Boj1080 {
    static int[][] A;
    static int[][] B;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];
        for(int i = 0; i< N; i++){
            String input = bf.readLine();
            for(int j = 0; j<M; j++){
                A[i][j] = input.charAt(j) - '0'; // 문자 -> 정수
            }
        }
        for(int i = 0; i< N; i++){
            String input = bf.readLine();
            for(int j = 0; j<M; j++){
                B[i][j] = input.charAt(j) - '0'; // 문자 -> 정수
            }
        }

        // 하나씩 확인하고 +2 => 오른쪽 아래쪽
        int answer = 0; // 최소 갯수

        for(int i = 0; i<N-2; i++){
            for(int j = 0; j<M-2; j++){
                if(A[i][j] != B[i][j]) {
                    change(i, j);
                    answer++; // 연산자 사용횟수 추가
                }
            }
        }
        int flag = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(A[i][j] != B[i][j]) { // 다른 여부가 발생하는지 확인한다
                    flag = 1;
                }
            }
        }
        if(flag == 0){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }

    }
    static void change(int start, int end){
        for(int i = start; i < start+3; i++){
            for(int j = end; j < end+3; j++){
                A[i][j] ^= 1; // 0 -> 1 || 1 -> 0
            }
        }
    }
}
