package essential.dfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;

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
    public static void main(String[] args) {
        // test
        N = 4;
        int M = 5;
        int V = 1;


        map = new int[N+1][N+1];
        map[1][2] = 1;
        map[1][3] = 1;
        map[1][4] = 1;
        map[2][4] = 1;
        map[3][4] = 1;
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
