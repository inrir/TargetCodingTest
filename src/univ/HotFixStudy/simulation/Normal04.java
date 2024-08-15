package univ.HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Normal04 {
    /**
     * 백준 2870 수학숙제
     * 처음 시작 0 제외하고 숫자를 담아주면 되지 않을까?
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine()); // 줄 갯수

        List<BigInteger> list = new ArrayList<>();


        for(int i = 0; i < N; i++){
            String tmp = bf.readLine();
            int start = 0;
            if(tmp.length() > 1 && tmp.charAt(0) == '0'){
                start = 1;
            }

            boolean check = false;
            String input = "";

            for(int j = start; j < tmp.length(); j++){
                if(tmp.charAt(j) >= '0' && tmp.charAt(j) <= '9'){
                    check = true;
                    input += tmp.charAt(j);
                }else{
                    if(check){
                        list.add(new BigInteger(input)); // 런타임 가능성이 큰 것 => Long <<<< BigInteger
                        input = "";
                    }
                    check = false;

                }
            }

            if(check){
                list.add(new BigInteger(input));
            }
        }

        Collections.sort(list);


        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


    }
}
