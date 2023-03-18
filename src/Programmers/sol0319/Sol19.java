package Programmers.sol0319;


import java.util.*;
public class Sol19 {
    class Solution {
        public int[] solution(int[] fees, String[] records) {
            // fees 기본 시간, 기본 요금, 단위 시간, 단위 요금
            HashMap<String, Integer> all = new HashMap<>(); // 누적된 모든 상태를 저장
            HashMap<String, Integer> save = new HashMap<>(); // IN만 저장

            HashSet<String> set = new HashSet<>();
            HashSet<String> checkset = new HashSet<>();

            for(int i = 0; i < records.length; i++){
                String[] tmp = records[i].split(" ");

                if(tmp[2].equals("IN")){ // IN
                    String[] time = tmp[0].split(":");
                    int mount = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]); // 수치로 환산
                    save.put(tmp[1], mount);
                    if(!all.containsKey(tmp[1])){
                        save.put(tmp[1], 0); // 누적해서 더하기 때문에 초기화
                    }
                    set.add(tmp[1]); // 중복 삽입이 안되는 점에서 마지막에 정렬하고 값 산출
                    int check = checkset.size();
                    checkset.add(tmp[1]); // 추후 00:00되는 점을 고려해서 삭제해준다.
                    if(checkset.size() == check + 1){ // new face
                        all.put(tmp[1], 0); // 초기화
                    }
                }else{ // OUT
                    String[] time = tmp[0].split(":");
                    checkset.remove(tmp[1]); // 삭제
                    int out = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]); // 수치로 환산

                    // all 을 초기화 해준 적이 없으니 에러.
                    all.put(tmp[1], all.get(tmp[1]) + (out - save.get(tmp[1]))); // 누적해서 더해준다.

                }

            }




            Iterator<String> iter = checkset.iterator(); // set을 Iterator 안에 담기
            while(iter.hasNext()) { // iterator에 다음 값이 있다면
                String tmp = iter.next(); // iter에서 값 꺼내기
                all.put(tmp, all.get(tmp) + (3540 - save.get(tmp))); // 00:00 정산
            }

            // Collections.sort(set); // 정렬

            int[] answer = new int[set.size()];

            int index = 0;
            Iterator<String> iterr = set.iterator(); // set을 Iterator 안에 담기
            while(iterr.hasNext()) { // iterator에 다음 값이 있다면
                answer[index] = all.get(iterr.next()); // iter에서 값 꺼내기
                index++;
            }

            for(int i = 0; i <answer.length; i++){
                int time = answer[i];

                if(time > fees[0]){
                    time = time - fees[0];

                    answer[i] = fees[1] + (time/fees[2])*fees[3];
                }else{
                    answer[i] = fees[1]; // 기본 요금
                }

            }



//         all.put("x",1);
//         if(all.containsKey("x")){
//                    System.out.println(Integer.parseInt("10") * 3);
//         }

            return answer;
        }
    }
}
