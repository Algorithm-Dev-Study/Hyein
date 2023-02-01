// BJ_10844
// 쉬운 계단 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    final static long MOD = 1000000000;

    static public int lengthOfNumber(long n) {
        int count = 0;
        while(n != 0) {
            n = n/10;
            count = count +1;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long Number = (long) (1 * Math.pow(10,N-1));
        int NumLength = lengthOfNumber(Number);
        String[] strArray;
        String strNum;
        int result = 0;

//        System.out.println("Number: " + Number);
//        System.out.println("NumLength: " + NumLength);

        if(N == 1) {
            result = 9;
        } else {
            while (NumLength == N) {
                strNum = String.valueOf(Number);
                strArray = strNum.split("");
                for (int i = 0; i < strArray.length - 1; i++) {
                    int int1 = Integer.parseInt(strArray[i]);
                    int int2 = Integer.parseInt(strArray[i + 1]);
                    if (int1 - int2 == 1 || int2 - int1 == 1) {
                        result++;
                    }
                }
                Number++;
                NumLength = lengthOfNumber(Number);
            }
        }

        System.out.println(result % MOD);


    }
}