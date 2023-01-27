// BJ_4949
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;

        while(true) {
            s = br.readLine(); // 한 줄의 텍스트를 읽는다.
            System.out.println("s: " + s);

            if(s.equals(".")) {
                System.out.println("\n break!!!!!!!!!!!! \n");
                break;
            }

            sb.append(solve(s)).append("\n");
        }

        System.out.println(sb);
    }

    public static String solve(String s) {
        char[] stack = new char[s.length()];  //스택처럼 사용할 배열
        int i = 0;

        for(char c : s.toCharArray()) {
            // 여는 괄호일 경우 배열에 저장 후 size 1 증가
            if(c == '(' || c == '[') {
                stack[i] = c;
                i++;
            } else if(c == ')') { // 닫는 소괄호일 경우
                if(i != 0 && stack[i-1] == '(') {
                    i--;
                } else { // 요소가 비어있거나 pop 할 원소가 소괄호랑 매칭이 안되는 경우
                    return "No";
                }
            } else if(c == ']') { // 닫는 대괄호일 경우
                if(i != 0 && stack[i-1] == '[') {
                    i--;
                } else { // 요소가 비어있거나 pop 할 원소가 대괄호랑 매칭이 안되는 경우
                    return "No";
                }
            }
        }

        if(i == 0) {
            return "Yes";
        } else {
            return "No";
        }

    }


}

