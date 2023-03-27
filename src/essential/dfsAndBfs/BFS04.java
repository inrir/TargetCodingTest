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
     */

    static class space{
        int x; // 세로
        int y; // 가로
        int d; // 위치

        space(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    static char[][] board; // 미로
    static int M;
    static int N;
    static Queue<space> human;
    static Queue<space> fire;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int res; // 답

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken()); // 행
        N = Integer.parseInt(st.nextToken()); // 열
        board = new char[M][N];
        human = new LinkedList<>();
        fire = new LinkedList<>();
        for(int i = 0; i < M; i++){
            board[i] = bf.readLine().toCharArray();
            for(int j = 0; j < N; j++){

                if(board[i][j] == 'J'){
                    human.add(new space(i, j, 0));
                }
                if(board[i][j] == 'F'){
                    fire.add(new space(i, j, 0));
                }
            }
        }
        if(BFS()) System.out.println(res);
        else System.out.println("IMPOSSIBLE");


    }

    public static boolean BFS(){
        while(!human.isEmpty()){
            // 불이 선행되고
            int size = fire.size(); // 다수 존재시
            for(int i = 0; i < size; i++){
                space s = fire.poll();

                for(int j = 0; j < 4; j++){ // 4방향 이동 고려

                    int nx = s.x + dx[j];
                    int ny = s.y + dy[j];

                    if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

                    if(board[nx][ny] == '#' || board[nx][ny] == 'F') continue;

                    board[nx][ny] = 'F'; // 다른 경우는 불이 전파된다.
                    fire.add(new space(nx, ny, s.d + 1)); // 이동된 거리를 추가한다.
                }
            }

            // 사람 이동

            size = human.size();
            for(int i = 0; i < size; i++){
                space s = human.poll();

                for(int j = 0; j < 4; j++){
                    int nx = s.x + dx[j];
                    int ny = s.y + dy[j];

                    if(nx < 0 || nx >= M || ny < 0 || ny >= N){
                        res = s.d + 1;
                        return true; // 탈출 성공
                    }

                    if(board[nx][ny] == '#' || board[nx][ny] == 'F' || board[nx][ny] == 'J') continue;

                    board[nx][ny] = 'J';
                    human.add(new space(nx, ny, s.d + 1));

                }
            }

        }
        return false;
    }
}
