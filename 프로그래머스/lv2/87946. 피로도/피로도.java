class Solution {
    static int answer;
    static boolean[] check;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        // 백트래킹 어떻게 합니까??
        check = new boolean[dungeons.length];
        
        DFS(0, k, dungeons);
        return answer;
    }
    public void DFS(int depth, int K, int[][] dungeons){
        for(int i = 0; i < dungeons.length; i++){
            
            if(!check[i] && dungeons[i][0] <= K){ // 모든 경우를 트래킹하도록 한다.
                check[i] = true;
                
                DFS(depth + 1, K - dungeons[i][1], dungeons);
                
                check[i] = false;
            }
            
        }
        
        answer = Math.max(depth, answer); // 제일 깊이가 크게 된 것...!
        
        
    }
    
}