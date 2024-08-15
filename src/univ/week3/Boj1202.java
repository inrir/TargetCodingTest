package univ.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Boj 1202 보석 도둑
 *
 * input: N(보석 개수) K(가방), M(보석 무게) V(가격), C(가방이 담는 무게)
 *
 * output: 담은 총 가격
 */
public class Boj1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

//        int[][] M = new int[N][2];
        ArrayList<Bag> list = new ArrayList<>();

        for(int i = 0; i < N; i++){
            String[] inp = bf.readLine().split(" ");
            int M = Integer.parseInt(inp[0]);
            int V = Integer.parseInt(inp[1]);
            list.add(new Bag(M, V));
        }
        int[] C = new int[K];
        for(int i = 0; i<K; i++){
            C[i] = Integer.parseInt(bf.readLine());
        }

//        int answer = 0; // 가격을 담아주는 것

        // C 오름차순 변경
        // M V에서 V를 내림차순으로 하고 동일할 경우 M 오름차순

        /**
         * C: 오름차순
         * M: 오름차순
         * -> 매칭
         * (무게, 가격), (무게)
         * 9 100
         * 8 99
         *
         * => 9 -> 100을 선택하도록
         * V: 내림차순으로 매칭하기!
         */
        Collections.sort(list, (o1, o2) -> o1.m - o2.m); // M 오름차순 정렬

        Arrays.sort(C); // 기본: 오름차순

        // 왜 우선순위 큐를 쓰는 것인지????
        // 가방이 많은 경우도 존재할 수 있다.
       /* int i = 0;
        for(int k = 0; k < N; k++){
            if(i == K)
                break;
            if(C[i] >= M[k][0]){
                answer += M[k][1];
                i++;
            }
        }
*/
        long answer = 0;
        int index = 0;

        PriorityQueue<Bag> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.v - o1.v); //가격순 정렬
        for(int i = 0; i< K; i++){ // 가방을 모두 사용하도록 한다.
            while(index < N && list.get(index).m <= C[i]){ // 해당 무게의 최대의 가격을 가진 것을 넣는다.
                Bag tmp = list.get(index++);
                priorityQueue.add(new Bag(tmp.m, tmp.v));
            }
            if(!priorityQueue.isEmpty()) answer += priorityQueue.poll().v;

        }
        System.out.println(answer);

    }

    public static class Bag{
        int m; // 무게
        int v; // 가격

        public Bag(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
