package essential.dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS05 {
    /**
     * 백준: 벽 부수고 이동하기
     * 벽을 한 번 부술 수 있다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        char[][] map = new char[m][n];

        for(int i = 0; i < m; i++){
            String tmp = bf.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = tmp.charAt(j);
            }
        }

        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(0, 0, 1, false)); // 시작을 0.0에서 하기 때문에 다음과 같이 초기화

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][][] visited = new boolean[m][n][2]; // [2]의 경우, 부순 여부를 기재한다.

        while(!queue.isEmpty()){
            Loc now = queue.poll();

            if(now.x == m - 1 && now.y == n-1){
                System.out.println(now.count);
                return;
            }

            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                int next_count = now.count + 1;

                if(map[nx][ny] == '0'){ // 지나가는 통로일 경우
                    if(!now.check && !visited[nx][ny][0]){ // 부신 벽이 없었을 경우
                        queue.add(new Loc(nx, ny, next_count, false));
                        visited[nx][ny][0] = true;
                    }else if(now.check && !visited[nx][ny][1]){ // 부신 경험이 있는 경우
                        queue.add(new Loc(nx, ny, next_count, true));
                        visited[nx][ny][1] = true;
                    }
                }else if(map[nx][ny] == '1'){ // 벽일 경우
                    if(!now.check){
                        queue.add(new Loc(nx, ny, next_count, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);

    }
    static class Loc{
        int x;
        int y;
        int count;
        boolean check; // 벽을 부순 곳?

        Loc(int x, int y, int count, boolean check){
            this.x = x;
            this.y = y;
            this.count = count;
            this.check = check;
        }
    }


}
