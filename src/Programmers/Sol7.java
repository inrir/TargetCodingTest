package Programmers;

public class Sol7 {
    public static void main(String[] args) {
        String tmp = "cdcd";
        System.out.println(solution(tmp));
    }
    public static int solution(String s)
    {
        int answer = 0;

        int tmp = 0;
        while(true){
            int index = check(s);
            if(index == -1){
                if(s.length() == 0){
                    answer = 1;
                    return answer;
                }
                else{
                    answer = 0;
                    return answer;
                }
            }else{
                s = s.substring(0, index) + s.substring(index+2, s.length());
            }
        }

        // return answer;
    }

    public static int check(String s){
        for(int i = 0; i < s.length(); i++){
            if(i+2 <= s.length()){
                if(s.substring(i, i+1).equals(s.substring(i+1, i+2))){
                    return i;
                }
            }
        }
        return -1;
    }
}
