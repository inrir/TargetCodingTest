class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int playtime = -1; // 조건 중 재생 기간이 긴 것 일 줄이야...!
        m = change(m);
        for(int i = 0; i < musicinfos.length; i++){
            String[] input = musicinfos[i].split(",");
            String[] time = input[0].split(":");
            String[] ttime = input[1].split(":");
            int minus = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            int one = Integer.parseInt(ttime[0]) * 60 + Integer.parseInt(ttime[1]);
            int gap = one - minus; // time Gap
            String nece = change(input[3]);
            int size = nece.length(); // 문자열 사이즈
            int index = 0;
            String tmp = "";
            if(gap <= size){
                tmp = nece.substring(0, gap);
            }else{
                int count = gap / size;
                
                for(int j = 0; j < count; j++){
                    tmp += nece;
                }
                int diff = gap % size;
                tmp += nece.substring(0,diff);
            }
            
            if(tmp.contains(m) && gap > playtime){ // 반복된 실수 해결을 위한 수단
                answer = input[2];
                playtime = gap;
            } 
        }
       
        return answer;
    }
    // 마지막. 12번 테스트 케이스 위배 DFDD, DFDFDD 불검출 문제
     // public boolean compare(String a, String b){ // a: big, b: Target
    //     int index = 0;
    //     boolean answer = false;
    //     for(int i = 0; i < a.length(); i++){
    //         char tmp = b.charAt(index);
    //         if(a.charAt(i) == b.charAt(index)){
    //             index++; // 동일한 것 발견
    //             answer = true;
    //             if(index == b.length()){
    //                 return true;
    //             }
    //             continue;
    //         }
    //         if(answer){
    //                 answer = false;
    //                 index = 0;
    //         }
    //     }
    //     return false; 
    // }
    public String change(String input){
        String answer = input;
        answer = answer.replaceAll("C#", "H");
        answer = answer.replaceAll("D#", "I");
        answer = answer.replaceAll("A#", "J");
        answer = answer.replaceAll("G#", "K");
        answer = answer.replaceAll("F#", "L");
        
        return answer;
        
    }
}

// 12,20, 21, 30 오류난 이유: 조건 중 일치하는 음악이 여러 개일때에는 라디오에서 재생된 시간이 제일 긴 음악 제목 반환