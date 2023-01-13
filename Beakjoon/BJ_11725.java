import java.io.*;
import java.util.*;

public class Main {
    static int N; // 노드의 개수
    static int[] parent; // 부모노드 저장
    static boolean[] isVisit; // 방문여부 확인
    static StringTokenizer st;
    static ArrayList<Integer> list[]; // 노드 저장

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫번째 줄 읽어와서 N 에 넣어주기
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
            System.out.println("result : " + parent[i]);
        }

    }

    public static void dfs(int index) {
        isVisit[index] = true; // 루트는 방문됨

        System.out.println(index + " 번 노드를 방문해보자.");
        System.out.println("---------------" );

        for(int i : list[index]) {
            System.out.println("1. i : " + i + " / index : " + index);
            System.out.println(index + " 번 노드의 값은 " + i + " 이다." );
            System.out.println();

            if(!isVisit[i]) { // 만약 방문되지 않은 노드이면
                System.out.println(i + " 번 노드는 방문 되지 않았다.");
                System.out.println();

                System.out.println("2. i : " + i + " / index : " + index);
                System.out.println(i + " 번 노드의 부모값은 " + index + " 이다. -> 저장");
                System.out.println();

                parent[i] = index; // parent list 에 각 노드들의 부모값을 저장해준다

                System.out.println("다음으로 " + i + " 번 노드를 방문해보자.");
                System.out.println("---------------" );

                dfs(i);
            } else {
                System.out.println(i + " 번 노드는 이미 방문되었다.");
                System.out.println();
            }
        }

        System.out.println(index + " 번 노드는 이미 방문되었다.");
        System.out.println("---------------" );
    }


}
