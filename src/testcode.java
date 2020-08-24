import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class testcode {
   static int N, M, fuel;
   static int taxi_i, taxi_j;
   static List<Passenger> passengers;
   static int[][] map;
   static int[][] passengerMap;
   static boolean[][] visit;
   static int[][] dist;

   static int[] di = { -1, 1, 0, 0 };
   static int[] dj = { 0, 0, -1, 1 };

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      N = sc.nextInt();
      M = sc.nextInt();
      fuel = sc.nextInt();

      map = new int[N + 1][N + 1];
      passengerMap = new int[N + 1][N + 1];
      for (int i = 1; i <= N; i++) {
         for (int j = 1; j <= N; j++) {
            map[i][j] = sc.nextInt();
         }
      }
      dist = new int[N + 1][N + 1];
      visit = new boolean[N + 1][N + 1];

      taxi_i = sc.nextInt();
      taxi_j = sc.nextInt();

      passengers = new ArrayList<>();
      for (int i = 0; i < M; i++) {
         int n1 = sc.nextInt();
         int n2 = sc.nextInt();
         Passenger p = new Passenger(n1, n2, sc.nextInt(), sc.nextInt());
         passengerMap[n1][n2] = i+1;
         passengers.add(p);
      }

      boolean impossible = false;
      while (fuel > 0 && passengers.size() > 0) {
         initVisit();
         initDist();
         bfs();
         
         int selected = findShortestPassenger();
         if(selected == -1) {
            impossible = true;
            break;
         }
         initVisit();
         bfs(selected);
      }
      
      if (impossible || fuel < 0)
         System.out.println(-1);
      else
         System.out.println(fuel);
   }

   // 택시의 위치로부터 각 칸으로의 최단거리를 기록.
   static void bfs() {
      Queue<Point> queue = new LinkedList<>();
      visit[taxi_i][taxi_j] = true;
      queue.add(new Point(taxi_i, taxi_j));
      
      int count = 0;
      boolean check = false;
      while (!queue.isEmpty()) {
         if(check) break;
         int size = queue.size();
         for (int s = 0; s < size; s++) {
            Point now = queue.poll();
            
            for (int d = 0; d < 4; d++) {
               int ni = now.x + di[d];
               int nj = now.y + dj[d];

               if (ni < 1 || ni > N || nj < 1 || nj > N || visit[ni][nj] || map[ni][nj] == 1)
                  continue;
               visit[ni][nj] = true;
               queue.add(new Point(ni, nj));
               dist[ni][nj] = count+1;
               // 여기다가 처음으로 승객을 만났을때 check = true 이거만 한번 넣어봐
               if(passengerMap[ni][nj] != 0) {
            	   check = true;
               }
            }
         }
         count++;
      }
   }
            
   // 계산된 최단거리로부터 가장 가까운 승객의 번호를 구함. 구함과 동시에 택시의 위치를 그 곳으로 이동시키고, 연료를 계산해줌.
   static int findShortestPassenger() {

      int p_num = -1;
      int min = Integer.MAX_VALUE;

      for (int i = 0; i < passengers.size(); i++) {
         Passenger p = passengers.get(i);
         
         if(dist[p.si][p.sj] == Integer.MAX_VALUE)
            continue;
         
         if (dist[p.si][p.sj] < min) {
            min = dist[p.si][p.sj];
            p_num = i;
         } else if (dist[p.si][p.sj] == min) {
            if (p.si < passengers.get(p_num).si) {
               p_num = i;
            } else if (p.si == passengers.get(p_num).si) {
               if (p.sj < passengers.get(p_num).sj) {
                  p_num = i;
               }
            }
         }
      }

      if(p_num != -1) {
         taxi_i = passengers.get(p_num).si;
         taxi_j = passengers.get(p_num).sj;
         passengerMap[taxi_i][taxi_j] = 0;
         fuel -= min;
      }

      return p_num;
   }

   // 선택된 승객의 목적지 좌표까지 택시를 이동시킴.
   static void bfs(int selected) {
      Queue<Point> queue = new LinkedList<>();
      visit[taxi_i][taxi_j] = true;
      queue.add(new Point(taxi_i, taxi_j));

      int count = 0;
      while (!queue.isEmpty()) {
         int size = queue.size();
         for (int s = 0; s < size; s++) {
            Point now = queue.poll();

            if (now.x == passengers.get(selected).di && now.y == passengers.get(selected).dj) {
               passengers.remove(selected);
               
               fuel -= count;
               if (fuel >= 0) {
                  fuel += 2 * count;
               }

               taxi_i = now.x;
               taxi_j = now.y;

               return;
            }

            for (int d = 0; d < 4; d++) {
               int ni = now.x + di[d];
               int nj = now.y + dj[d];

               if (ni < 1 || ni > N || nj < 1 || nj > N || visit[ni][nj] || map[ni][nj] == 1)
                  continue;
               visit[ni][nj] = true;
               queue.add(new Point(ni, nj));
            }
         }
         count++;
      }
   }

   static void initVisit() {
      for (int i = 1; i <= N; i++) {
         for (int j = 1; j <= N; j++) {
            visit[i][j] = false;
         }
      }
   }

   static void initDist() {
      for (int i = 1; i <= N; i++) {
         for (int j = 1; j <= N; j++) {
            dist[i][j] = Integer.MAX_VALUE;
         }
      }
   }

   static class Passenger {
      int si;
      int sj;
      int di;
      int dj;

      public Passenger(int si, int sj, int di, int dj) {
         this.si = si;
         this.sj = sj;
         this.di = di;
         this.dj = dj;
      }

      @Override
      public String toString() {
         return "Passenger [si=" + si + ", sj=" + sj + ", di=" + di + ", dj=" + dj + "]";
      }
   }
}