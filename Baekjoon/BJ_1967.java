// BJ_1967
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    // 간선에 가중치가 있으므로 연결된 노드 번호와 가중치를 담기 위해 Node라는 클래스를 만들어서 입력을 받았다.
    static class Node {
        int num, len;
        public Node(int num, int len) {
            this.num = num;
            this.len = len;
        }
    }
    static List<Node> list[];
    static boolean visit[];
    static int ans;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        list = new ArrayList[N+1];

        for(int i = 1; i < N+1; i++) {
            list[i] = new ArrayList<Node>();
        }

        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, len));
            list[to].add(new Node(from, len));
        }

        ans = 0;

        for(int i = 1; i <= N; i++) {
            visit = new boolean[N+1];
            visit[i] = true;
            dfs(i, 0);
        }

        System.out.println(ans);
    }

    // dfs - 깊이 우선 탐색
    private static void dfs(int num, int dim) {
        for(Node node : list[num]) {
            if(!visit[node.num]) {
                visit[node.num] = true;
                dfs(node.num, dim + node.len);
            }
        }
        ans = (ans < dim)? dim : ans;
    }

}