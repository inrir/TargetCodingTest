import java.util.*;
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        boolean check;
        for(int i = 0; i < places.length; i++){
            String[] search = places[i];
            check = true; // 거리두기하고 있다고 defalut
            
            for(int x = 0; x < 5; x++){
                for(int y = 0; y < 5; y++){
                    if(search[x].charAt(y) == 'P'){
                        if(!bfs(x, y, search)){
                            check = false; // 거리 두기 실패
                        }
                    }
                }
            }
            if(check){
                answer[i] = 1;
            }else{
                answer[i] = 0;
            } 
        }
        
        
        return answer;
    }
    public boolean bfs(int x, int y, String[] search){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || (nx == x && ny == y))
                    continue;
                
                int d = Math.abs(nx - x) + Math.abs(ny - y);
                
                if(search[nx].charAt(ny) == 'P' && d <= 2){ // P가 2 이하의 거리에 있으면 안됨.
                    return false;
                }
                
                if(search[nx].charAt(ny) == 'O' && d < 2){ // 1인 지점에 o가 있다면 주변에 P있는지 탐색해야 함
                    queue.offer(new int[] {nx, ny});  
                }
                
            }
            
        }
        
        
        return true;
    }
}