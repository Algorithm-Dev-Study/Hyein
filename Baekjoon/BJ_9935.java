// BJ_9935
// 문자열 폭발

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] strArray = str.split("");

        String explosionStr = br.readLine();
        String[] expArray = explosionStr.split("");

        StringBuilder result = new StringBuilder();

        Integer exist;

        for(String s : strArray) {
            exist = 0;
            for(String e : expArray) {
                if(s.equals(e)) {
                    exist = 1;
                }
            }
            if(exist == 0) {
                result.append(s);
            }
        }

        if(result.length() == 0) {
            System.out.print("FRULA");
        } else {
            System.out.print(result);
        }

    }
}