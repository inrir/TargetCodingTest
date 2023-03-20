package Programmers.sol0326;

import java.util.*;
public class sol21 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {

            HashMap<Character, Integer> hashMap = new HashMap<>(); // skill 들 차수 정하기
            int answer = 0;
            int check = 0;
            for(int i = 0; i < skill.length(); i++){
                hashMap.put(skill.charAt(i), i); //0 -> 1 -> 2
            }

            for(int i = 0; i < skill_trees.length; i++){
                int index = 0;
                for(int j = 0; j < skill_trees[i].length(); j++){
                    char tmp = skill_trees[i].charAt(j);
                    if(hashMap.containsKey(tmp)){ // key에 포함된 것만.
                        if(hashMap.get(tmp) > index){
                            check = 1;
                        }
                        index++;
                    }
                }
                if(check == 0){
                    answer++;
                }
                check = 0;
            }

            return answer;
        }
    }
}
