//BJ_11725
/*
주목해야 할 부분은 트리 구조의 특징이다.
트리는 그래프의 특수한 형태로 어떤 정점의 인접한 정점은 반드시 부모 노드 혹은 자식 노드라는 특징이 있다.
이를 이용하여 루트 노드에서부터 탐색을 시작하면 특정 노드의 부모 노드를 알 수 있다.

위의 트리를 예시로 들어 설명하자면
루트 노드 1 방문
-> 1의 인접한 정점은 4와 6
-> 1이 루트 노드이므로 4와 6은 전부 자식 노드
-> 즉 4와 6의 부모 노드는 1

노드 4 방문
-> 4의 인접한 정점은 1, 2, 7
-> 이 중 1은 이미 방문했으므로 인접한 정점을 찾는 과정에서 제외(부모 노드)
-> 남은 2와 7은 자식 노드
-> 즉 2와 7의 부모 노드는 4

이러한 과정을 통해 특정 노드의 부모 노드를 알아낼 수 있다.
 */
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
        System.out.println("isVisit[" + index + "] = true;");
        isVisit[index] = true; // 루트는 방문됨

        for(int i : list[index]) {
            System.out.println("list[" + index + "]");
            if(!isVisit[i]) { // 만약 방문되지 않은 노드이면
                System.out.println("parent[" + i + "] = " + index + ";");
                parent[i] = index; // parent list 에 각 노드들의 부모값을 저장해준다
                dfs(i);
            }
        }
    }


}
