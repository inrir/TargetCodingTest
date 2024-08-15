package univ.Programmers.sol0319;


import java.util.*;
public class Sol19 {
    /**
     * 회고 분석
     * 누군가에게 발표하든 이야기하면, 틀린부분에 대해서 확인할 수 있다. -> 플로우 유지 -> 긴 line의 문제일수록 변수 틀리거나 집중부족으로 망하는 경우.
     * Set 정렬을 위해서는 List 형태 변환으로 정렬해야 한다.
     */
    class Solution {
        public int[] solution(int[] fees, String[] records) {
            // fees 기본 시간, 기본 요금, 단위 시간, 단위 요금
            HashMap<String, Integer> all = new HashMap<>(); // 누적된 모든 상태를 저장
            HashMap<String, Integer> save = new HashMap<>(); // IN만 저장

            Set<String> set = new HashSet<>();
            HashSet<String> checkset = new HashSet<>();

            for(int i = 0; i < records.length; i++){
                String[] tmp = records[i].split(" ");

                if(tmp[2].equals("IN")){ // IN
                    String[] time = tmp[0].split(":");
                    int mount = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]); // 수치로 환산
                    save.put(tmp[1], mount);
                    if(!all.containsKey(tmp[1])){
                        all.put(tmp[1], 0); // 누적해서 더하기 때문에 초기화
                    }
                    set.add(tmp[1]); // 중복 삽입이 안되는 점에서 마지막에 정렬하고 값 산출
                    checkset.add(tmp[1]); // 추후 00:00되는 점을 고려해서 삭제해준다.

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
                all.put(tmp, all.get(tmp) + (1439 - save.get(tmp))); // 00:00 정산
            }

            // Collections.sort(set); // 정렬

            ArrayList<String> key = new ArrayList<>(set);
            Collections.sort(key);

            int[] answer = new int[set.size()];

            for(int i = 0; i < answer.length; i++){
                answer[i] = all.get(key.get(i));
            }


            for(int i = 0; i <answer.length; i++){
                int time = answer[i];

                if(time > fees[0]){
                    time = time - fees[0];
                    if(time%fees[2] == 0){
                        answer[i] = fees[1] + (time/fees[2])*fees[3];
                    }else{

                        answer[i] = fees[1] + (time/fees[2] + 1)*fees[3];
                    }

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
