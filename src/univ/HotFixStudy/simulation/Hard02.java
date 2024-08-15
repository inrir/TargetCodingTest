package univ.HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hard02 {
    /**
     * 백준 9663 N-Queen
     *
     */
    static int N;
    static int[] arr;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        /**
         * 0 0
         * 0 0
         *
         * 0 0 0
         * 0 0 0
         * 0 0 0
         *
         * 1 0 0 0
         * 0 0 0 0
         * 0 1 0 0
         * 0 0 0 0
         *
         * 1 0 0 0 0
         * 0 0 1 0 0 (3)
         * 0 0 0 0 1 (1)
         * 0 1 0 0 0 (1)
         * 0 0 0 1 0
         *
         *백트래킹이라는데, 도대체 어떻게 생각해서 구현해야하나??
         */
        arr = new int[N];

        nqueen(0);

        System.out.println(count);

    }

    public static void nqueen(int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i = 0 ; i < N; i++){
            arr[depth] = i;
            if(check(depth)){
                nqueen(depth + 1);
            }
        }
    }

    public static boolean check(int col){
        for(int i = 0; i < col; i++){
           // 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우)
            if (arr[col] == arr[i]) {
                return false;
            }

            /*
             * 대각선상에 놓여있는 경우
             * (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
             */
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }

        }

        return true; // 조건 지나고 통과
    }

}
