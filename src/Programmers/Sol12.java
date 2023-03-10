package Programmers;


import java.util.*;
public class Sol12 {
    class Solution {
        public int solution(int[][] board, int[] moves) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>(); // result 담는 그릇.
            int[] index = new int[board[0].length];

            for(int i = 0; i < index.length; i++){ // index 부여
                for(int j = 0; j < index.length; j++){
                    if(board[j][i] != 0){
                        index[i] = j;
                        break;
                    }
                }
            }

            // moves를 통해 하나씩 이동하기
            // 사라질때마다 checking 하기.

            for(int i = 0; i < moves.length; i++){
                int check = moves[i] - 1; // index
                if(index[check] >= board[0].length) continue;
                if(!stack.empty() && stack.peek() == board[index[check]][check]){
                    stack.pop();
                    answer += 2;
                }else{
                    stack.push(board[index[check]][check]);
                }
                index[check]++;

            }

            return answer;
        }
    }
}
