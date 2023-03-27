class Solution {
    static int[] answer; 
    public int[] solution(int[][] arr) {
        answer = new int[2];
        // 백트래킹 유형이라는데,, 다시 공부해야겠다.
        
        backtracking(0, 0, arr.length, arr);
        return answer;
    }
    
    public void backtracking(int x, int y, int size, int[][] arr){
        if(check(x, y, size, arr)){
            answer[arr[x][y]]++; // 0 or 1
            return;
        }
        backtracking(x, y, size/2, arr);
        backtracking(x + size/2, y, size / 2, arr);
        backtracking(x, y + size/2, size / 2, arr);
        backtracking(x + size / 2, y + size / 2, size/2, arr);
        
    }
    public boolean check(int x, int y, int size, int[][] arr){
        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(arr[x][y] != arr[i][j]) return false;
            }
        }
        return true;
    }
}