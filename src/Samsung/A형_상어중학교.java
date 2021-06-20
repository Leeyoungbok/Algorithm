package Samsung;

import java.awt.*;
import java.util.*;

public class A형_상어중학교 {
    static int N, M, answer = 0;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][N];

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                map[i][j] = sc.nextInt();
            }
        }

        /*
        격자에 중력이 작용한다.
        격자가 90도 반시계 방향으로 회전한다.
        다시 격자에 중력이 작용한다.
         */
        while(true){
            boolean isRet = false;
            int[] remXy = new int[2]; // 0 : x index, 1 : y index
            boolean[][] used = new boolean[N][N];
            Queue<Point> queue = new LinkedList<>();
            int maxRainbowCnt = 0;
            int maxCnt1 = 1;

            // 크기가 가장 큰 블록 그룹을 찾는다. 그러한 블록 그룹이 여러 개라면 포함된 무지개 블록의 수가 가장 많은 블록 그룹, 그러한 블록도 여러개라면 기준 블록의 행이 가장 큰 것을, 그 것도 여러개이면 열이 가장 큰 것을 찾는다.
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(used[i][j] || map[i][j] == -1 || map[i][j] == 0 || map[i][j] == -2) continue;
                    isRet = true;
                    queue.add(new Point(i, j));
                    used[i][j] = true;
                    int cnt1 = 1;
                    boolean[][] rainbowUsed = new boolean[N][N];
                    int rainbowCnt = 0;
                    int groupColor = map[i][j];
                    while(!queue.isEmpty()){
                        Point point = queue.poll();

                        for(int k = 0 ; k < 4 ; k++){
                            int ax = point.x + dx[k];
                            int ay = point.y + dy[k];

                            if(ax < 0 || ax >= N || ay < 0 || ay >= N) continue;
                            if(map[ax][ay] == -1 || map[ax][ay] == -2) continue;
                            if(used[ax][ay] || rainbowUsed[ax][ay]) continue;

                            if(map[ax][ay] == 0){
                                rainbowCnt++;
                                cnt1++;
                                rainbowUsed[ax][ay] = true;
                                queue.add(new Point(ax, ay));
                            }else if(map[ax][ay] == groupColor){
                                cnt1++;
                                queue.add(new Point(ax,ay));
                                used[ax][ay] = true;
                            }
                        }
                    }
                    if(cnt1 > maxCnt1){
                        maxCnt1 = cnt1;
                        remXy[0] = i;
                        remXy[1] = j;
                    }else if(cnt1 == maxCnt1){
                        if(rainbowCnt >= maxRainbowCnt){
                            maxRainbowCnt = rainbowCnt;
                            remXy[0] = i;
                            remXy[1] = j;
                        }
                    }
                }
            }

            if(!isRet || maxCnt1 == 1) break;
            // 1에서 찾은 블록 그룹의 모든 블록을 제거한다. 블록 그룹에 포함된 블록의 수를 B라고 했을 때, B2점을 획득한다.
            used = new boolean[N][N];
            boolean[][] rainbowUsed = new boolean[N][N];
            queue.add(new Point(remXy[0], remXy[1]));
            used[remXy[0]][remXy[1]] = true;
            int groupColor = map[remXy[0]][remXy[1]];
            int cnt2 = 1;
            map[remXy[0]][remXy[1]] = -2;

            while(!queue.isEmpty()){
                Point point = queue.poll();

                for(int k = 0 ; k < 4 ; k++){
                    int ax = point.x + dx[k];
                    int ay = point.y + dy[k];

                    if(ax < 0 || ax >= N || ay < 0 || ay >= N) continue;
                    if(map[ax][ay] == -1 || map[ax][ay] == -2) continue;
                    if(used[ax][ay] || rainbowUsed[ax][ay]) continue;

                    if(map[ax][ay] == groupColor){
                        map[ax][ay] = -2;
                        used[ax][ay] = true;
                        cnt2++;
                        queue.add(new Point(ax, ay));
                    }else if(map[ax][ay] == 0){
                        map[ax][ay] = -2;
                        rainbowUsed[ax][ay] = true;
                        cnt2++;
                        queue.add(new Point(ax, ay));
                    }

                }
            }
            answer += Math.pow(cnt2, 2);
            gravity();
            rotate();
            gravity();
        }

        System.out.println(answer);


    }

    private static void gravity(){
        for (int j = 0; j < N; j++) {
            int bottom = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (map[i][j] == -2)
                    continue;
                else if (map[i][j] == -1)
                    bottom = i - 1;
                else
                {
                    int block = map[i][j];
                    map[i][j] = -2;
                    map[bottom--][j] = block;
                }
            }
        }
    }

    private static void rotate(){
        int[][] tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 반시계 방향 90도 회전
                tmp[N - 1 - j][i] = map[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp[i][j];
            }
        }
    }

}
