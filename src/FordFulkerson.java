//컴퓨터알고리즘 중간고사 201902954한현진

import java.util.*;

public class FordFulkerson {
                              //[][]R = 잔여 용량, src = 출발점, s = 도착점, path = 출발점->도착점 가는 경로 저장
    private static boolean bfs(int[][] R, int src, int s, int[] path) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[R.length];
        queue.add(src);
        visited[src]=true;

        while(!queue.isEmpty()) {
            int a = queue.poll(); //a = 현재 노드
            for(int i=0;i<R.length; i++){
                if(visited[i]) continue;
                if(R[a][i]>0){ //잔여 용량이 더 크다면 방문합니다
                    queue.add(i);
                    visited[i] = true;
                    path[i] = a; //i를 현재 노드로 설정하고 다시 반복
                    if (i==s) return true; //도착지에 도착하면 리턴
                }
            }
        }
        return false;
    }

    private static int fordfulkerson(int[][] graph, int source, int sink) {
        int max = 0; //max = 최대 용량
        int[][] R = new int[graph.length][graph.length]; //잔여 용량
        for(int i=0;i< graph.length;++i){
            System.arraycopy(graph[i],0,R[i],0,graph.length);
        }
        int[] path = new int[graph.length];

        while (bfs(R, source, sink, path)) { //bfs로 찾은 경로들에 대해 동시에 보낼 수 있는 최대 용량을 찾습니다
            int F = Integer.MAX_VALUE;
            int a = sink;
            while(a!=source) {
                int parent = path[a];
                F = Math.min(F,R[parent][a]); //경로 중 잔여 용량이 더 작은 것을 찾는다
                a = parent;
            }
            max += F; //최대 용량에 더해줌

            a = sink;
            while (a!=source){
                int parent = path[a];
                R[parent][a] -= F;//정간선에는 잔여 용량에 보내는 용량을 빼주고
                R[a][parent] += F;//역간선에는 잔여 용량에 보내는 용량을 더해준다
                a = parent;
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
