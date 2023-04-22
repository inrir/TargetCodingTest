class Solution {
    // 최대 공약수와 최소 공배수 상관관계
    public int solution(int[] arr) {
        int answer = 0;
        answer = sol(arr[0], arr[1]); 
        for(int i = 2; i < arr.length; i++){
            answer = sol(answer, arr[i]);
        }
        
        return answer;
    }
    
    // 유클리드 호제법 다시 공부!!!!
    public int sol(int a, int b){ // a가 커야함
        if(a < b){
            int tmp = a;
            a = b;
            b = tmp;
        }
        int big = a * b;
        while(b != 0){
            int result = a % b;
            a = b;
            b = result;
        }
        // return a; // 최대 공약수 구하는 법
        return big / a; // 최소 공배수 구하는 법
    }
    
}