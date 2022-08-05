import java.util.*;

public class NumberOfConnectedComponent {
    static ArrayList<Integer>[] connectArray;
    static boolean[] visited;
    static void DFS(Integer startNode) {
        if (visited[startNode]) return;
        visited[startNode] = true;
        ArrayList<Integer> adjNodes = connectArray[startNode];
        for (Integer node:adjNodes) {
            DFS(node);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        connectArray = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i=1;i<=N;i++) {
            connectArray[i] = new ArrayList<>();
        }
        for (int i=0;i<M;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            connectArray[u].add(v);
            connectArray[v].add(u);
        }

        int connectedCount = 0;
        for (int i=1;i<=N;i++) {
            if (!visited[i]) {
                connectedCount++;
                DFS(i);
            }
        }
        System.out.println(connectedCount);
    }
}