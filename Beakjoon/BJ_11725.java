/*
        1
       / \
      6   4
     / \   \
    2  7    3
             \
              5
 */
import java.io.*;
import java.util.*;

public class BJ_11725 {
    static int N; // 노드의 개수
    static int[] parent; // 부모노드 저장
    static boolean[] isVisit; // 방문여부 확인
    static StringTokenizer st;
    static ArrayList<Integer> list[]; // 노드 저장

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 줄의 노드의 개수를 N 에 넣어주기
        N = Integer.parseInt(br.readLine());

        isVisit = new boolean[N + 1];
        list = new ArrayList[N + 1];
        parent = new int[N + 1];

        for(int i = 0;i < N + 1;i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0;i < N - 1;i++) { // 연결된 노드 값들을 입력받는다
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1); // 트리의 루트는 1

        for(int i = 2;i < parent.length;i++) { // 결과값 출력
            System.out.println(parent[i]);
        }

    }

    public static void dfs(int index) {
        isVisit[index] = true;
        for(int i : list[index]) {
            if(!isVisit[i]) {
                parent[i] = index; // parent list 에 각 노드들의 부모값을 저장해준다
                dfs(i);
            }
        }
    }


}
