package essential.dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS04 {
    /**
     * 백준 4179번 불!
     * 지훈과 불이 같이 움직이도록 해야할 거 같다.
     * 지훈이는 경계를 이탈한다면, 탈출에 성공한 것이다. 아닌 경우 IMPOSSIBLE
     */

    static class space{
        int x, y;
        int d; // 이동 거리 횟수
        space(int x, int y, int d){
            this.x = x; // 세로
            this.y = y; // 가로
            this.d = d;
        }
    }
    static Queue<space> fire;
    static Queue<space> human;

    static int R, C;
    static char[][] board; // 상황을 담아주는 곳
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result; // 최종 이동한 결과값 반환
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        fire = new LinkedList<>();
        human = new LinkedList<>();
        for(int i = 0; i < R; i++){
            board[i] = bf.readLine().toCharArray();
            for(int j = 0; j < C; j++){
                if(board[i][j] == 'J'){
                    human.add(new space(i, j, 0));
                }
                if(board[i][j] == 'F'){
                    fire.add(new space(i, j, 0));
                }
            }
        }
        // BFS 에 따른 결과 값 조절
        if(BFS()) System.out.println(result);
        else System.out.println("IMPOSSIBLE");

    }

    public static boolean BFS(){
        while(!human.isEmpty()){
            // 불을 퍼지게 하고
            int size = fire.size();
            for(int i = 0; i < size; i++){
                space s = fire.poll();

                for(int j = 0; j < 4; j++){
                    int nx = s.x + dx[j];
                    int ny = s.y + dy[j];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;

                    if(board[nx][ny] == '#' || board[nx][ny] == 'F') continue;

                    board[nx][ny] = 'F';
                    fire.add(new space(nx, ny, s.d + 1)); // 이동한 횟수 반영
                }
            }

            size = human.size();
            for(int i = 0; i < size; i++){
                space s = human.poll();

                for(int j = 0; j < 4; j++){
                    int nx = s.x + dx[j];
                    int ny = s.y + dy[j];

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C){
                        result = s.d + 1;
                        return true;
                    }
                    if(board[nx][ny] == '#' || board[nx][ny] == 'F' || board[nx][ny] == 'J') continue;

                    board[nx][ny] = 'J';
                    human.add(new space(nx, ny, s.d + 1));
                }
            }

            // 인간을 이동시킨다.
        }

        return false; // 인간이 탈출을 못 한 것이므로.
    }

}
