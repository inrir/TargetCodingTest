package univ.HotFixStudy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Easy03 {
    /**
     * 백준 2178 미로 탐색
     * (1,1) -> (N,M) 배열의 크기에 맞게 조정하여 구하게 된다.
     */
    static int[][] map; // 데이터를 담는 그릇
    static boolean[][] find; // 지나온 것인지 확인하는 방법
    static int fin_x;
    static int fin_y;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = bf.readLine().split(" ");
        fin_x = Integer.parseInt(tmp[0]);
        fin_y = Integer.parseInt(tmp[1]);

        map = new int[fin_x][fin_y];
        find = new boolean[fin_x][fin_y];

        for(int i = 0; i < fin_x; i++){ // 데이터 담아주기
            String[] a = bf.readLine().split("");
            for(int j = 0; j < fin_y; j++){
                map[i][j] = Integer.parseInt(a[j]);
            }
        }

        System.out.println(BFS());


    }
    static class pos{
        int x;
        int y;
        int count;
        pos(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public static int BFS(){
        Queue<pos> queue = new LinkedList<>();
        queue.offer(new pos(0, 0, 1));
        find[0][0] = true;

        while(!queue.isEmpty()){
            pos tmp = queue.poll();

            for(int i = 0; i < 4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx < 0 || nx >= fin_x || ny < 0 || ny >= fin_y) continue;
                if(nx == fin_x - 1 && ny == fin_y -1) return tmp.count + 1;
                if(map[nx][ny] == 1 && find[nx][ny] == false){
                    queue.offer(new pos(nx, ny, tmp.count + 1));
                    find[nx][ny] = true;
                }

            }
        }

        return -1;

    }
}
