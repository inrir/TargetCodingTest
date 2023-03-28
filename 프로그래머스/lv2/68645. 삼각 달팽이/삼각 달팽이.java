class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2]; // 삼각형의 크기 구하는 공식
        
        int x = -1; // 첫 시작 1 증가할 예정
        int y = 0;
        int num = 0; // 지나간 값을 담는 그릇
        int[][] board = new int[n][n]; // 달팽이 흔적 담을 그릇
        
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                // 달팽이 움직임 표현
                if(i % 3 == 0){ // 아래로 가는 방식
                    x++; 
                }else if(i % 3 == 1){ // 오른쪽으로 가는 방식
                    y++;
                }else if(i % 3 == 2){ // 대각선으로 가능 방식
                    x--;
                    y--;
                }
                
                board[x][y] = ++num;
            }
        }
        
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0) continue;
                answer[k++] = board[i][j];
            }
        }
        
        
        
        
        return answer;
    }
}