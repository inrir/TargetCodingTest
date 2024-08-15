package univ.dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS03 {
    /**
     * 백준 7569번 응용 BFS
     * 익은 토마토의 영향도 => 위, 아래, 왼쪽, 오른쪽, 앞, 뒤
     * M, N, H
     * 이전과 달리, 탐색 범위를 6가지로 구분한다.
     */

    static int[] dx = {0, 0, -1, 1, 0, 0}; // 상하좌우위아래
    static int[] dy = {0, 0, 0, 0, 1, -1};
    static int[] dz = {1, -1, 0, 0, 0, 0};

    static int[][][] board; // 토마토 통

    static class tomato{
        int x; // 세로
        int y; // 가로
        int z; // 높이

        tomato(int z, int x, int y){
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
    static Queue<tomato> queue;

    static int M; // 가로
    static int N; // 세로
    static int H; // 높이
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        queue = new LinkedList<tomato>();
        board = new int[H][N][M]; // 토마토판
        for(int k = 0; k < H; k++){
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(bf.readLine());
                for(int j = 0; j < M; j++){
                    board[k][i][j] = Integer.parseInt(st.nextToken());
                    if(board[k][i][j] == 1){ // 익은 부분
                        queue.add(new tomato(k, i, j));
                    }
                }
            }
        }

        System.out.println(BFS());


    }

    public static int BFS(){
        while(!queue.isEmpty()){
            tomato t = queue.remove();

            int nx;
            int ny;
            int nz;
            for(int i = 0; i < 6; i++){ // 6가지의 경우를 모두 돈다.
                nx = t.x + dx[i];
                ny = t.y + dy[i];
                nz = t.z + dz[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) {
                    if (board[nz][nx][ny] == 0) {
                        queue.add(new tomato(nz, nx, ny));

                        board[nz][nx][ny] = board[t.z][t.x][t.y] + 1;
                    }
                }

            }
        }

        int result = Integer.MIN_VALUE;

        for(int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(board[k][i][j] == 0) return -1;
                    result = Math.max(result, board[k][i][j]);
                }
            }
        }

        return result - 1;
    }
}
