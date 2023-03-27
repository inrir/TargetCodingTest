package essential.dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS02 {
    /**
     * 백준 7576번 토마토
     * 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들이 영향을 받아 익는다. 일종의 전염 발생
     * 대각선은 예외로 발생된다.
     * => 며칠 지나야 익는지?
     * 모두 간선으로 연결하고 끝점이 뭔데? => 왜냐면 6-5 5-6
     */
    static class tomato {
        int x;
        int y;

        tomato(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int M;
    static int N;

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1}; // 상하좌우
    static int[][] board; // 토마토 판
    static Queue<tomato> que;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        board = new int[N][M];

        que = new LinkedList<tomato>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j< M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1)
                    que.add(new tomato(i, j));
            }
        }

        System.out.println(BFS());


    }

    public static int BFS(){
        while(!que.isEmpty()){
            tomato t = que.remove();

            int x = t.x; // 세로
            int y = t.y; // 가로

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(board[nx][ny] == 0){
                        // 이제 익은 토마토이기 때문에 넣기
                        que.add(new tomato(nx,ny));
                        // 며칠 째 익은 날짜인지 넣기
                        board[nx][ny] = board[x][y] + 1;
                    }
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 0)
                    return -1; // 있으면 안됨..!

                result = Math.max(result, board[i][j]);
            }
        }

        if(result == 1)
            return 0;

        else{
            return result - 1;
        }

    }


}
