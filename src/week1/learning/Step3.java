package week1.learning;

/**
 * 프로그래머스 예산
 *
 * input:
 *
 * output:
 *
 * algo:
 * 최대와 최소에 대한 평균을 잡는다. -> 일단 상한액
 * 상한액으로 합이 초과할 경우, 평균과 최소 -> 상한액 도출
 * 상한액으로 합이 미만일 경우, 최대와 평균 -> 상한액 도출
 */
public class Step3 {
    public static void main(String[] args) {
        int[] a = new int[]{120, 110, 140, 150};
        int b = 485;

        System.out.println(solution(a, b));
    }


    public static int solution(int[] budgets, int M) { // [120, 110, 140, 150], 485 => 127
        int answer = 0;


        int length = budgets.length;
        int avg = 0;
        int min = Integer.MAX_VALUE;
        int max = -1;

        for(int a: budgets){
            avg += a;
            if(min > a) min = a;
            if(max < a) max = a;
        }
        avg /= length; // 평균 완성
        int check = 0;


        // 1st. 최소: 0, 최대: 150
        while(true){
            check = 0;
            for(int i = 0; i<length; i++){
                if(avg < budgets[i]){ // 상한액 도달시 상한액으로 연산
                    check += avg;
                }else{
                    check += budgets[i];
                }
            }

            if(check == M || answer == check)
                break;
            if(check > M ){ // 상한액과 최소와 비교
                max = avg;
                avg = avg + min;
                avg /= 2;
                answer = check;
            }
            if(check < M){ // 최대와 상한액 비교
                min = avg;
                avg = max + avg;
                avg /= 2;
                answer = check;
            }
        }

        answer = avg;
        return answer;
    }

}
