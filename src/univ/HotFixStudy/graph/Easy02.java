package univ.HotFixStudy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Easy02 {
    /**
     * 백준 2667 단지번호 붙이기
     * 1인 것에 대해서 BFS? 탐색
     * 하고 카운트 하고 출력?
     */
    static int point; // 가로 세로의 각각의 길이
    static int[][] map; // 움직인 경로를 넣어주기
    static boolean[][] find; // 탐색한 여부 알려주기.
    // 인접 행렬 움직이는 경로를 적기 위해서 dx dy
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class pos{ // 2차원 상의 움직임
        int x;
        int y;
        pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        point = Integer.parseInt(bf.readLine()); // 정점의 개수
        map = new int[point][point];
        find = new boolean[point][point]; // 지났는지 확인해주는 역할.
        for(int i = 0; i < point; i++){
            String[] tmp = bf.readLine().split("");
            for(int j = 0; j < point; j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        int count  = 0; // 카운트 횟수
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < point; i++){
            for(int j = 0;  j < point; j++){
                if(map[i][j] == 1 && find[i][j] == false){
                    count++; // 전체 개수 탐지
                    list.add(BFS(i, j));
                }
            }
        }

        System.out.println(count);
        Collections.sort(list); // 리스트 정렬법 + 오름차순으로 정렬해야하기 때문에 필수
        for(int i = 0; i < count; i++){
            System.out.println(list.get(i));
        }
    }
    public static int BFS(int x, int y){
        int answer = 1;
        Queue<pos> queue = new LinkedList<>();
        queue.offer(new pos(x, y)); // 처음 하나
        find[x][y] = true;

        while(!queue.isEmpty()){
            pos tmp = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx >= point || nx < 0 || ny >= point || ny <0) continue;
                if(map[nx][ny] == 1 && find[nx][ny] == false){
                    queue.offer(new pos(nx, ny));
                    find[nx][ny] = true;
                    answer++;
                }
            }
        }

        return answer;
    }


}
