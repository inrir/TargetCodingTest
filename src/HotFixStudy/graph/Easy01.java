package HotFixStudy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Easy01 {
    /**
     * 백준 1260 DFS와 BFS
     * DFS와 BFS 둘다 탐색한 결과를 출력하는 것
     */

    static int point;
    static int[][] con;
    static boolean[] BFS_visited;
    static boolean[] DFS_visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = bf.readLine().split(" "); // 정점, 간선, 시작 번호
        int edge = Integer.parseInt(nums[1]); // 간선 리스트
        point = Integer.parseInt(nums[0]); // 정점 개수
        int start = Integer.parseInt(nums[2]) - 1; // 시작 번호

        con = new int[point][point]; // 연결된 선들
        StringTokenizer st;
        BFS_visited = new boolean[point]; // BFS 방문 체크
        DFS_visited = new boolean[point]; // DFS 방문 체크

        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(bf.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            con[one - 1][two - 1] = 1;
            con[two - 1][one - 1] = 1;
        }
        DFS(start);
        System.out.println();
        BFS(start);
    }

    public static void DFS(int a){
        DFS_visited[a] = true;
        System.out.print(a + 1 + " ");
        for(int i = 0; i < point; i++){
            if(con[a][i] == 1 && DFS_visited[i] == false){
                DFS(i);
            }
        }
    }
    public static void BFS(int a){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);
        BFS_visited[a] = true;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(tmp + 1 + " ");

            for(int i = 0; i < point; i ++){
                if(con[tmp][i] == 1 && BFS_visited[i] == false){
                    queue.offer(i);
                    BFS_visited[i] = true;
                }
            }
        }
    }
}
