package univ.HotFixStudy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Easy04 {
    /**
     * 백준 1012 유기농 배추
     * 1 지점을 0으로 전염
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(bf.readLine());
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};


        for(int i = 0; i < cases; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] nums = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            int x, y;
            int answer = 0; // 최종 흰지렁이 갯수
            Queue<pos> queue = new LinkedList<>(); // BFS를 위해
            for(int j = 0; j < K; j++){
                st = new StringTokenizer(bf.readLine());
                x = Integer.parseInt(st.nextToken()); // 가로 점
                y = Integer.parseInt(st.nextToken()); // 세로
                nums[y][x] = 1;
            }


            for(int j = 0; j < N; j++){
                for(int l = 0; l < M; l++){
                    if(nums[j][l] == 1 && !visited[j][l]){ // 구역별로 끊어주기
                        answer++;
                        queue.add(new pos(j, l));

                        while(!queue.isEmpty()){ // BFS 탐색
                            pos tmp = queue.poll();
                            visited[tmp.x][tmp.y] = true;
                            for(int k = 0; k < 4; k++){
                                int nx = tmp.x + dx[k];
                                int ny = tmp.y + dy[k];

                                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // overflow 제외

                                if(!visited[nx][ny] && nums[nx][ny] == 1){
                                    queue.add(new pos(nx, ny));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                }
            }



            System.out.println(answer);
        }
    }
    static class pos{
        int x;
        int y;
        pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
