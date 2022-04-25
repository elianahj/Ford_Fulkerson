//컴퓨터알고리즘 중간고사 201902954한현진

import java.util.*;

public class FordFulkerson {

    // 1.경로 찾기
    //residual = 잔여 용량, src = 출발점, s = 도착점, path = 출발점->도착점 가는 경로 저장
    private static boolean findpath(int[][] r, int src, int s, int[] path) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[r.length]; //정점을 방문했었는지 여부 저장
        queue.add(src);
        visited[src]=true;

        while(!queue.isEmpty()) {
            int a = queue.poll(); //a = 현재 정점
            for(int i=0;i<r.length; i++){
                if(!visited[i] && r[a][i]>0){ //방문하지 않은 정점 중에서 잔여 용량이 남아있으면 방문합니다
                    queue.add(i);
                    visited[i] = true;
                    path[i] = a; //i를 현재 노드로 설정하고 다시 반복
                    if (i==s) return true; //도착지에 도착할 때까지
                }
            }
        }
        return false;
    }

    //2.Ford Fulkerson 알고리즘 수행
    private static int fordfulkerson(int[][] graph, int source, int sink) {
        int max = 0; //max = 최대 용량
        int[][] r = new int[graph.length][graph.length]; //잔여 용량 residual
        for (int i = 0; i < graph.length; ++i) {
            System.arraycopy(graph[i], 0, r[i], 0, graph.length); //최초의 잔여 용량은 보낸 용량이 없으므로 생성한 그래프와 같으니까 복붙해줍니다
        }
        int[] path = new int[graph.length];

        while (findpath(r, source, sink, path)) { //찾은 경로들에 대해 동시에 보낼 수 있는 최대 용량을 찾습니다
            int F = Integer.MAX_VALUE;
            int i = sink;

            while (i!=source) {
                int parent = path[i];
                F = Math.min(F,r[parent][i]); //경로 내 최소값을 찾아서 그만큼의 용량을 보낸다
                i = parent;
            }
            max += F; //보낸 용량을 최대 용량에 더해줌

            i=sink;
            while(i!=source){
                int parent = path[i];
                r[parent][i] -= F;//정간선에는 잔여 용량에 보내는 용량을 빼주고
                r[i][parent] += F;//역간선에는 잔여 용량에 보내는 용량을 더해준다
                i = parent;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 8, 0, 0, 3, 0 }, { 0, 0, 9, 0, 0, 0 }, { 0, 0, 0, 0, 7, 2 },
                { 0, 0, 0, 0, 0, 5 }, { 0, 0, 7, 4, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };

        System.out.print("최대 용량 = " + fordfulkerson(graph,0,5));

    }


}
