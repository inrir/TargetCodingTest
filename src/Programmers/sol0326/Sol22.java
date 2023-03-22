package Programmers.sol0326;

public class Sol22 {
    class Solution {
        public int solution(String dirs) {
            boolean check[][][][] = new boolean[11][11][11][11]; // 차원이 느는 것이 안 좋은 것은 아니다.
            int[] dx = {0, 0, 1, -1};
            int[] dy = {-1, 1, 0, 0};
            // 음수일 경우 +11을 통해 모두 담아주도록 한다.
            int[][] first = new int[11][11];
            int[][] second = new int[11][11];

            int answer = 0;

            int Before_first = 0; // 첫 시작
            int Before_second = 0; // 첫 시작

            int After_first = 5; // 0의 위치는 5로 둔다.
            int After_second = 5;

            int index = 0;
            for(int i = 0; i < dirs.length(); i++){
                char tmp = dirs.charAt(i);
                Before_first = After_first;
                Before_second = After_second;

                switch(tmp){
                    case 'U': // up
                        index = 1;
                        break;
                    case 'D': // down
                        index = 0;
                        break;
                    case 'R': // right
                        index = 2;
                        break;
                    case 'L': // left
                        index = 3;
                        break;
                    default:
                        break;
                }

                After_first += dx[index];
                After_second += dy[index];

                if(After_first < 0 || After_first > 10 || After_second < 0 || After_second > 10){
                    After_first -= dx[index];
                    After_second -= dy[index];
                    continue;
                }

                // first[x][y] = 1;
                // second[z][w] = 1;
                if(!check[Before_first][Before_second][After_first][After_second] && !check[After_first][After_second][Before_first][Before_second]){
                    check[Before_first][Before_second][After_first][After_second] = true;
                    check[After_first][After_second][Before_first][Before_second] = true;
                    answer++;
                }
            }

//         for(int i = 0; i < 11; i++){
//             for(int j = 0; j < 11; j++){
//                 if(first[i][j] == 1){
//                     answer++;
//                 }
//                 if(second[i][j] == 1){
//                     answer++;
//                 }
//             }
//         }
            // answer = answer/2;
            return answer;
        }
    }
}
