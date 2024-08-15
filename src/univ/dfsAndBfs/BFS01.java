package univ.dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS01 {
    /**
     * 백준 2606번 바이러스 BFS 문제
     * 간선 이어주고, BFS 탐색 후 개수 출력
     */
    static int map[][]; // 간선 여부를 넣기
    static boolean visited[];
    static int answer = 0; // 1번을 통해 감연된 바이러스 개수 탐색
    static int computer; // 바이러스의 총 개수

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        computer = Integer.parseInt(bf.readLine()); // 컴퓨터 갯수 입력받기
        int number = Integer.parseInt(bf.readLine()); // 간선의 수 입력

        map = new int[computer][computer];
        visited = new boolean[computer];

        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 배열 형태 맞추기
            from--;
            to--;

            map[from][to] = 1;
            map[to][from] = 1;
        }

        BFS(0);
        System.out.println(answer);
    }


    public static void BFS(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();
//            System.out.print(tmp + " ");

            for (int j = 0; j < computer; j++) {
                if (map[tmp][j] == 1 && visited[j] == false) {
                    queue.offer(j);
                    answer++; // 바이러스 탐색마다 1 증가
                    visited[j] = true;
                }
            }
        }

    }
}
