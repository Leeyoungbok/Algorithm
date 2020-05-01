package Competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Hongik2019_면접보는승범이네 {
   static int N, M, K, maxCity;
   static long maxCost;
   static long[] city;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken()); 
      maxCity = 0;
      maxCost =0;
      city = new long[N+1]; 
      ArrayList<ArrayList<Edge>> list = new ArrayList<>();
      boolean[] used = new boolean[N+1];
      PriorityQueue<Edge> queue = new PriorityQueue<>();
      
      for(int i = 0 ; i <= N ; i++) { // 인접리스트 초기화
         list.add(new ArrayList<>());
         city[i] = Long.MAX_VALUE; // 각 정점 초기화
      }
      
      for(int i = 0 ; i < M ; i++) { // 인접리스트 저장 
         /*
          * 각 정점에서 도착지로의 경로가 주어지지만, 문제 조건을 만족시키기 위해 역방향으로 저장함
          */
         st = new StringTokenizer(br.readLine(), " ");
         int start = Integer.parseInt(st.nextToken()); 
         int end = Integer.parseInt(st.nextToken()); 
         int cost = Integer.parseInt(st.nextToken()); 
         list.get(end).add(new Edge(end, start, cost));
      }
      
      
      st = new StringTokenizer(br.readLine(), " ");
      for(int i =0 ; i < K ; i++) { // 도착지를 입력받고 모두 큐에 넣어줌
         int dest = Integer.parseInt(st.nextToken()); 
         city[dest] = 0;
         queue.add(new Edge(0, dest, 0));
      }
      
      int cnt = 0;
      while(!queue.isEmpty()) { // 다익스트라
         Edge e = queue.poll();
         if(used[e.end]) continue; // 방문한 정점이면 continue
         cnt++; // 총 N개의 정점을 모두 돌았으면 종료
         if(e.cost >= maxCost) { // cost가 높거나 같을 경우 작은 번호의 도시 저장
            if(e.cost > maxCost || e.end < maxCity) {
               maxCity = e.end; 
               maxCost = e.cost;
            }
         }
//         if(cnt == N)
//            break;
         for(Edge edge : list.get(e.end)) {
//            if(used[edge.end]) continue;
            if(city[e.end]!=Long.MAX_VALUE&& city[edge.end] > edge.cost + city[e.end]) {
               city[edge.end] = edge.cost + city[e.end];
               queue.add(new Edge(edge.start, edge.end, city[edge.end]));
            }
         }
         used[e.end] = true;
      }
      
      System.out.println(maxCity + "\n" + maxCost);
   }
   
   static class Edge implements Comparable<Edge>{
      int start, end;
      long cost;
      Edge(int start, int end, long cost){
         this.start = start;
         this.end = end;
         this.cost = cost;
      }
      
      @Override
      public int compareTo(Edge o) {
         if(this.cost > o.cost) return 1;
         if(this.cost < o.cost) return -1;
         return 0;
      }
   }
}