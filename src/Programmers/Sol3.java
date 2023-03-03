package Programmers;

import java.util.*;
public class Sol3 {
    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length]; // 초기화로  0, 0, ..

            HashMap<String, HashSet<String>> hashMap = new HashMap<>();
            HashMap<String, Integer> indexMap = new HashMap<>();

            for(int i = 0; i < id_list.length; i++){ // "muzi" : 0 = key : value
                hashMap.put(id_list[i], new HashSet<>());
                indexMap.put(id_list[i], i); // 인덱스 조정됨
            }

//         for(int i = 0; i < report.length; i++){ // ADD: 동일한 사람이 신고하면 1번만.
//             String tmp = report[i].substring(report[i].indexOf(" ")+1);
//             String all = report[i];
//             if(!dedectMap.containsKey(all)){
//                 hashMap.put(tmp, hashMap.get(tmp) + 1); // 신고 받은 상태를 알림.
//                 dedectMap.put(all, 1);
//             }

//         }

            for(int i = 0; i < report.length; i++){ // 나를 신고했던 사람을 담기 (플립드 생각) => 신고한 사람의 인덱스를 올리면 된다.
                String tmp = report[i].substring(report[i].indexOf(" ")+1);
                String me = report[i].substring(0, report[i].indexOf(" "));
                hashMap.get(tmp).add(me); // hashSet 으로 넣기
            }

            for(int i = 0; i < id_list.length; i++){
                HashSet<String> tmp = hashMap.get(id_list[i]);
                if(tmp.size() >= k){
                    for(String a : tmp){
                        answer[indexMap.get(a)]++;
                    }
                }
            }


            return answer;
        }
    }
}
