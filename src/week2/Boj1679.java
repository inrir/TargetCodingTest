package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * 숨바꼭질 BOJ 1679
 *
 * input: N, K: (0<= <= 100,000)
 *
 * output: 최소 걸린 시간
 *
 */
public class Boj1679 {
    static int N;
    static int K;
    static int[] check = new int[100001];


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        // k-1, k+1, 2*k => 모두 순회하다가 K가 나오는 경우
    }

    static int bfs(int N){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);
        int search = 0;
        check[N] = 1;

        while(!queue.isEmpty()){
            search = queue.remove();

            if(search == K){ // end condition
                return check[search] - 1; // level - 1: current location
            }
            if(search-1 >= 0 && check[search-1] == 0){

            }
            if(search+1 <= 100000 && check[search+1] == 0){

            }
            if(search*2 <= 100000 && check[search*2] == 0){

            }

        }
        return -1; // error

    }

}
