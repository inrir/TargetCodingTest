import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        /*
        -20 -19 -18 -17 -16 -15
                                -14 -13 -12 -11 -10 -9 -8 -7 -6 -5
                -18 -17 -16 -15 -14 -13
                                                                -5 -4 -3
        */
        int min = -300001; // 범위 밖 최소의 수
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1])); // 오름차순 정렬
        for(int i = 0; i < routes.length; i++){
            if(min < routes[i][0]){
                min = routes[i][1]; // 다음 최소 값 넣어주기
                answer++;
            }
        }
        
        return answer;
    }
}