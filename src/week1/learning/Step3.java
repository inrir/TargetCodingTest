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

        int min = 0;
        int max = 0;

        for(int a: budgets){
            if(max < a) max = a;
        }
        while(min <= max){
            int mid = (min + max) / 2;
            int sum = 0;

            for(int b: budgets){
                if(b > mid) sum += mid; // 상한액 초과시
                else sum+=b;
            }

            if(sum <= M){
                min = mid + 1;
                answer = mid;
            }else{
                max = mid - 1;
            }
        }

        return answer;
    }

}
