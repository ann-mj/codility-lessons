import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    static int N = 10; // 정점의 갯수
    static int[] dist = new int[N];
    static ArrayList<Edge>[] edges;

    static void dijkstra(int start) {

        for(int i = 1; i<= N; i++) dist[i] = Integer.MAX_VALUE;

        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));

        pq.add(new Info(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Info info = pq.poll();
            if (dist[info.idx] < info.dist) continue;
            for( Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    static class Edge {
        public int to, weight;

        public Edge(int _to, int _weight) {
            this.to = _to;
            this.weight = _weight;
        }
    }

    static class Info {
        public int idx, dist;

        public Info() {
        }

        public Info(int _idx, int _dist) {
            this.idx = _idx;
            this.dist = _dist;
        }
    }

}
