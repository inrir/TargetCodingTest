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
 * 효율성 테스트 탈락한 이유
 * 1. loop를 제일 먼저 의심
 * 2. primitive type > object type: faster
 *
 * Tip 효율성 높이기
 * 1. Loop 개선
 * 2. 적절한 데이터 구조 사용
 * 3. 불필요한 오브젝트 제거
 */
public class Step1 {
    static class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0; // 설치되는 기지국의 개수

            int position = 1; // 위치에 해당한다.

            // 겹치는 것을 고려하여 담아주는 영역 object type -> primitive type
//            Queue<Integer> stageQueue = new LinkedList<>();
//            for(int s:stations) stageQueue.offer(s); // https://goodteacher.tistory.com/112
            int stage_index = 0;

            while(position <= n){
                // 설치된 기지국과 겹치는 여부를 확인해줘야 한다.
                if(stage_index < stations.length && stations[stage_index] - w <= position){
                    position = stations[stage_index] + w + 1;
                    stage_index++;
                }else{
                    answer += 1; // 기지국 설치될 때마다
                    position += w + 1 + w; // 설치시 움직이는 형태
                }
            }

            return answer;
        }
    }
}
