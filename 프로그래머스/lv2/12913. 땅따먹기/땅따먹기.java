class Solution {
    static int answer;
    int solution(int[][] land) {
        answer = 0;
        // 규칙: 동일한 행 접근 불가... 근데 뭔가 또 백트래킹?? 같은데..
       
        // DFS(0, 0, -1, land);
        int len = land.length;
        
        for(int i = 1; i < len; i++){
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
        }
        
        for(int i = 0; i < 4; i++){
            answer = Math.max(answer, land[len - 1][i]);
        }
        
        return answer;
    }
//     public void DFS(int depth, int sum, int place, int[][] land){
//         // 시간초과가 난다... DP.. 메모제이션을 생각해줘야 할 거 같다.
//         if(land.length == depth){
//             answer = Math.max(sum, answer);
//             return;
//         }
//         for(int i = 0; i < 4; i++){
//             if(place == i) continue;
//             DFS(depth + 1, sum + land[depth][i], i, land);
//         }
        
//     }
     
}