class Solution {
    static int[][] box;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        box = new int[rows][columns];
        int index = 0;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                box[i][j] = ++index;
            }
        }
        for(int i = 0; i < queries.length; i++){
            answer[i] = swap(queries[i]);
        }
        return answer;
    }
    
    public static int swap(int[] move){ // 4가지 방향으로 옮겨주는 형태를 만들면 된다. 
        int x1 = move[0] - 1;
        int y1 = move[1] - 1;
        int x2 = move[2] - 1;
        int y2 = move[3] - 1;
        int first = box[x1][y2]; // 순서에 의해 지정된 값
        int min = first; // 제일 최소값 
        
        // 순서를 정해줘야 한다. 왜냐면 어떤게 hidden 처리되는지 알기 위해서
        // 오른쪽 Y로 가는 법 -> 
        for(int i = y2 - 1; i >= y1; i--){
            min = Math.min(min, box[x1][i]);
            box[x1][i+1] = box[x1][i];
        }
        // 위쪽 X로 가는 법
        for(int i = x1 + 1; i <= x2; i++){
            min = Math.min(min, box[i][y1]);
            box[i-1][y1] = box[i][y1]; 
        }
        // 왼쪽 Y로 가는 법
        for(int i = y1 + 1; i <= y2; i++){
            min = Math.min(min, box[x2][i]);
            box[x2][i-1] = box[x2][i];
        }
        // 아래쪽 X로 가는 법
        for(int i = x2-1; i >= x1; i--){
            min = Math.min(min, box[i][y2]);
            box[i+1][y2] = box[i][y2];
        }
        box[x1+1][y2] = first;
        
        return min;
    }
}