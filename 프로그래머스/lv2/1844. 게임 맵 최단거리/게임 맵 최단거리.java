import java.util.*;
class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    public int solution(int[][] maps) {
        int answer = 0;
        // 전형적인 BFS 문제
        int x_len = maps.length;
        int y_len = maps[0].length;
        map = maps;
        visited = new boolean[x_len][y_len];
        return BFS(x_len, y_len);
    }
    
    public int BFS(int x_len, int y_len){
        Queue<pos> queue = new LinkedList<>();
        queue.add(new pos(0, 0, 1));
        
        while(!queue.isEmpty()){
            pos tmp = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int x = dx[i] + tmp.x;
                int y = dy[i] + tmp.y;
                if(x >= x_len || x < 0 || y >= y_len || y < 0) continue;
                
                if(x == x_len - 1 && y == y_len - 1){
                    return tmp.cnt + 1;
                }
                
                if(map[x][y] == 1 && !visited[x][y]){
                    queue.add(new pos(x, y, tmp.cnt + 1));
                    visited[x][y] = true;
                }
            }        
        }
        
        return -1; // 없음.     
    }
    class pos{
        int x;
        int y; 
        int cnt;
        pos(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}