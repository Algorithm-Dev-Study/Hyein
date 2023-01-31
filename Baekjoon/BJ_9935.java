// BJ_9935
// 폭탄 문자열
// sb 문자열을 하나씩 늘려가면서 마지막 특정문자열길이가 explosionStr과 일치하는지 여부를 따지며 삭제하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String str;
    static String explosionStr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        explosionStr = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch);
            if(sb.length() >= explosionStr.length()) { // sb의 길이가 폭탄의 길이의 이상이 되면
                boolean isSame = true;
                for(int j = 0; j < explosionStr.length(); j++) {
                    char ch1 = sb.charAt(sb.length() - explosionStr.length() + j);
                    char ch2 = explosionStr.charAt(j);
                    if(ch1 != ch2) {
                        isSame = false;
                        break;
                    }
                }
                if(isSame) {
                    //폭발 문자열 삭제
                    sb.delete(sb.length() - explosionStr.length(), sb.length());
                }
            }
        }

        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }

    }
}