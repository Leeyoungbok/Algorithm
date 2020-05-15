package Competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Hongik2019_면접보는승범이네{
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
      
      for(int i = 0 ; i <= N ; i++) { // ��������Ʈ �ʱ�ȭ
         list.add(new ArrayList<>());
         city[i] = Long.MAX_VALUE; // �� ���� �ʱ�ȭ
      }
      
      for(int i = 0 ; i < M ; i++) { // ��������Ʈ ���� 
         /*
          * �� �������� ���������� ��ΰ� �־�������, ���� ������ ������Ű�� ���� ���������� ������
          */
         st = new StringTokenizer(br.readLine(), " ");
         int start = Integer.parseInt(st.nextToken()); 
         int end = Integer.parseInt(st.nextToken()); 
         int cost = Integer.parseInt(st.nextToken()); 
         list.get(end).add(new Edge(end, start, cost));
      }
      
      
      st = new StringTokenizer(br.readLine(), " ");
      for(int i =0 ; i < K ; i++) { // �������� �Է¹ް� ��� ť�� �־���
         int dest = Integer.parseInt(st.nextToken()); 
         city[dest] = 0;
         queue.add(new Edge(0, dest, 0));
      }
      
      int cnt = 0;
      while(!queue.isEmpty()) { // ���ͽ�Ʈ��
         Edge e = queue.poll();
         if(used[e.end]) continue; // �湮�� �����̸� continue
         cnt++; // �� N���� ������ ��� �������� ����
         if(e.cost >= maxCost) { // cost�� ���ų� ���� ��� ���� ��ȣ�� ���� ����
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