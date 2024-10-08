package univ.week2;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Boj 1261 알고스팟
 *
 * (1*1) -> (N*M) 최소 벽 부수기
 *
 * input: 목적지
 *
 * output: 최단 거리
 */

class Point implements Comparable<Point> {
    int x;
    int y;
    int cnt; // 벽을 부순 개수

    Point(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Point o) {
        return cnt - o.cnt;
    }
}

public class Boj1261 {
    static int[] rangeX = { -1, 0, 1, 0 };
    static int[] rangeY = { 0, 1, 0, -1 };
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) { // input 정리
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Character.getNumericValue(input.charAt(j - 1));
            }
        }

        int ans = BFS(1, 1);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    public static int BFS(int x, int y) {
        // 벽을 부순 개수를 오름차순으로 정렬하도록 설정.
        PriorityQueue<Point> q = new PriorityQueue<>();

        q.offer(new Point(x, y, 0));
        boolean[][] visit = new boolean[N + 1][M + 1];
        visit[x][y] = true;

        int dx, dy;
        while (!q.isEmpty()) {
            Point p = q.poll();

            // 도착점에 도달했으면 종료.
            if (p.x == N && p.y == M) {
                return p.cnt;
            }

            for (int i = 0; i < 4; i++) {
                dx = p.x + rangeX[i];
                dy = p.y + rangeY[i];

                if (dx < 1 || dy < 1 || dx > N || dy > M) { // 초과여부 확인
                    continue;
                }

                if (!visit[dx][dy] && map[dx][dy] == 0) { // 안 부술지?
                    visit[dx][dy] = true;
                    q.offer(new Point(dx, dy, p.cnt));
                }

                if (!visit[dx][dy] && map[dx][dy] == 1) { // 부술지?
                    visit[dx][dy] = true;
                    q.offer(new Point(dx, dy, p.cnt + 1));
                }
            }
        }
        return 0;
    }


}
