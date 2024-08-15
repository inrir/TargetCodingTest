package univ.HotFixStudy.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Normal02 {
    /**
     * 백준 1629 곱셈
     * A^B / C
     */
    static long C;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = bf.readLine().split(" ");

        long A = Long.parseLong(tmp[0]);
        long B = Long.parseLong(tmp[1]);
        C = Long.parseLong(tmp[2]);

        // 아마 비트 연산자를 써야할 듯.. 아니네..

        System.out.println(pow(A, B));

    }

    public static long pow(long A, long B){ // 밑, 지수
        if(B == 1){
            return A % C;
        }

        long tmp = pow(A, B/2); // 모듈러 연산식을 위해 지수 줄이기 a^4 % C = a^2 % C * a^2 % C


        if(B % 2 == 1){ // 홀수일 경우, a^9 = a^8 * a
            return (tmp * tmp % C) * A % C; // tmp * tmp 이상은 long을 넘는다.
        }

        return tmp * tmp % C;
    }
}
