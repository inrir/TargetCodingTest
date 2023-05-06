import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int x, int y, int n) {
        // BFS? DP?
        visited = new boolean[y * 3]; // x 겹치는 값 제외
        int answer = BFS(x, y, n);
        
        
        return answer;
    }
    
    public int BFS(int x, int y, int n){
        Queue<pos> queue = new LinkedList<>();
        
        queue.add(new pos(x, 0));
        visited[x] = true;
        
        while(!queue.isEmpty()){
            pos tmp = queue.poll();
            
            if(tmp.x == y){
                return tmp.count;
            }
            
            if(tmp.x + n <= y && !visited[tmp.x + n]){
                queue.add(new pos(tmp.x + n, tmp.count+1));
                visited[tmp.x + n] = true;
            }
            
            if(tmp.x * 2 <= y && !visited[tmp.x * 2]){
                queue.add(new pos(tmp.x * 2, tmp.count + 1));
                visited[tmp.x * 2] = true;
            }
            
            if(tmp.x * 3 <= y && !visited[tmp.x * 3]){
                queue.add(new pos(tmp.x * 3, tmp.count + 1));
                visited[tmp.x * 3] = true;
            }
        }
        
        return -1;
    }
    
    class pos{
        int x;
        int count;
        
        pos(int x, int count){
            this.x = x;
            this.count = count;
        }
    }
}