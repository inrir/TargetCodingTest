package Programmers;

import java.util.*;
public class sol4 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            // LRU 를 알고 있는지 묻는 수준
            int answer = 0;
            List<String> list = new ArrayList<>();

            if(cacheSize == 0){
                return cities.length * 5;
            }
            for(int i = 0; i < cities.length; i++){
                String tmp = cities[i].toUpperCase(); // 대소문자 예외없음

                if(list.remove(tmp)){ // cache hit
                    list.add(tmp);
                    answer += 1;
                }else{ // cache miss
                    if(list.size() >= cacheSize){
                        list.remove(0);
                    }
                    list.add(tmp);
                    answer += 5;

                }
            }

            return answer;
        }
    }
}
