package essential.dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * DFS => deep -> recursion or repeat.
 * BFS => wide -> Queue
 *
 * input: N, M, V: 정점의 개수, 간선의 개수, 시작점
 *
 * output: DFS's Result + '\n' + BFS's Result
 */
public class DFS {
    static int[][] map;
    static boolean[] DFS_visited;
    static boolean[] BFS_visited;
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);

        map = new int[N+1][N+1];

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 양쪽 관계임을 보여줘야 한다. -> 첫번째 틀린 이유
            map[a][b] = 1;
            map[b][a] = 1;

        }

        DFS_visited = new boolean[N+1];
        BFS_visited = new boolean[N+1];

        DFS(V);
        System.out.println();
        BFS(V);


    }
    public static void DFS(int i){
        DFS_visited[i] = true;

        System.out.print(i + " ");
        for(int j = 1; j < N+1; j++ ){
            if(map[i][j] == 1 && DFS_visited[j] == false){
                DFS(j);
            }
        }
    }

    public static void BFS(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        BFS_visited[i] = true;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(tmp + " ");

            for(int j = 1; j < N+1; j++){
                if(map[tmp][j] == 1 && BFS_visited[j] == false){
                    queue.offer(j);
                    BFS_visited[j] = true;
                }
            }
        }

    }

}
