package week1.learning;

import java.util.LinkedList;
import java.util.Queue;

/**
 * programmers 기지국 설치
 *
 * input: 기지국 위치
 *
 * output: 어디에 할 지?
 *
 *
 */
public class Step1 {
    static class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0; // 설치되는 기지국의 개수

            int position = 1; // 위치에 해당한다.

            // 겹치는 것을 고려하여 담아주는 영역
            Queue<Integer> stageQueue = new LinkedList<>();
            for(int s:stations) stageQueue.offer(s); // https://goodteacher.tistory.com/112

            while(position <= n){
                // 설치된 기지국과 겹치는 여부를 확인해줘야 한다.
                if(stageQueue.isEmpty() && stageQueue.peek() - w <= position){
                    position = stageQueue.poll() + w + 1;
                }else{
                    answer += 1; // 기지국 설치될 때마다
                    position += w + 1 + w; // 설치시 움직이는 형태
                }
            }

            return answer;
        }
    }
}
