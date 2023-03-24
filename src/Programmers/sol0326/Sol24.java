package Programmers.sol0326;

import java.util.*;
public class Sol24 {
    class Solution {
        static char map[][];

        public int solution(int m, int n, String[] board) {
            int answer = 0;
            map = new char[m][n];
            for(int i = 0; i < m; i++){ // 첫 초기화
                for(int j = 0; j < n; j++){
                    map[i][j] = board[i].charAt(j);
                }
            }

            int cnt = 1;

            while(cnt != 0){
                cnt = 0; // 초기화

                boolean[][] check = new boolean[m][n]; // 기본 default false

                // -1이 범위안으로 모두 체크할 수 있다.
                for(int i = 0; i < m-1; i++){ // 존재하는 것 true 만들기.
                    for(int j = 0; j < n-1; j++){
                        if(map[i][j] == '-') continue; // 빈칸 4개 모일수도 있으니깐
                        if(detect(i,j)){ // 존재한다면
                            check[i][j] = true;
                            check[i+1][j] = true;
                            check[i][j+1] = true;
                            check[i+1][j+1] = true;

                        }
                    }
                }

                // 갱신 및 삭제해주기.
                for(int i = 0; i < n; i++){ // 열씩 누적해서 쌓아올리기
                    List<Character> bucket = new ArrayList<>();
                    for(int j = m - 1; j >= 0; j--){
                        if(check[j][i]) {
                            cnt++; // true된 개수 체크
                            continue;
                        }
                        bucket.add(map[j][i]);
                    }
                    for(int j = m - 1, k = 0; j >= 0; k++, j--){
                        if(k < bucket.size()) map[j][i] = bucket.get(k);
                        else map[j][i] = '-'; // 빈칸
                    }
                }

                answer += cnt;

            }
            return answer;
        }
        public boolean detect(int i, int j){
            char com = map[i][j];
            if(com == map[i+1][j] && com == map[i][j+1] && com == map[i+1][j+1]){
                return true;
            }
            return false;

        }
    }
/**
 * 전형적인 구현문제...

 * 1. 4블록을 detect 해줄 함수 필요.
 * 2. detect -> update : 반복 (until 변화된 갯수가 없을때까지)
 * 3. 변화된 개수를 입력하면 된다.
 */
}
