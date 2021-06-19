package Samsung;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A형_상어초등학교 {
    static int N, answer = 0;
    static int[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static List<Point> remStudent = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N + 1][N + 1];

        /*
            비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
            1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
            2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
         */
        int[][] inputArr = new int[N * N][5];

        for(int i = 0 ; i < N * N ; i++){
            // 학생 한 라인 받아주고
            for(int j = 0 ; j < inputArr[0].length ; j++){
                inputArr[i][j] = sc.nextInt();
            }

            // 학생이 어디 앉을지 결정 시킴
            typeOne(inputArr[i]);

        }
        // 다 돌면 만족도 출력
        System.out.println(getAnswer(inputArr));

    }

    private static void typeOne(int[] inputArr){
        // 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
        int max = 0;
        List<Point> list = new ArrayList<>();
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                if(map[i][j] != 0) continue;
                int happyCnt = 0;

                for(int k = 0 ; k < 4 ; k++){
                    int ax = i + dx[k];
                    int ay = j + dy[k];
                    if(ax < 1 || ax > N || ay < 1 || ay > N) continue;

                    for(int ii = 1 ; ii <= 4 ; ii++) {
                        if (map[ax][ay] == inputArr[ii]) {
                            happyCnt++;
                        }
                    }
                }

                if(max == happyCnt){
                    list.add(new Point(i, j));
                }else if(max < happyCnt){
                    max = happyCnt;
                    list.clear();
                    list.add(new Point(i, j));
                }
            }
        }

        if(list.size() == 1){
            Point point = list.get(0);
            map[point.x][point.y] = inputArr[0];
            remStudent.add(new Point(point.x, point.y));
        }else if(list.size() > 1){
            typeTwo(inputArr, list);
        }
    }

    private static void typeTwo(int[] inputArr, List<Point> list){
        // 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
        int max = 0;
        List<Point> list2 = new ArrayList<>();
        for(int i = 0 ; i < list.size() ; i++){
            Point point = list.get(i);
            int happyCnt = 0;

            for(int k = 0 ; k < 4 ; k++){
                int ax = point.x + dx[k];
                int ay = point.y + dy[k];

                if(ax < 1 || ax > N || ay < 1 || ay > N || map[ax][ay] != 0) continue;
                if(map[ax][ay] == 0){
                    happyCnt++;
                }
            }

            if(max == happyCnt){
                list2.add(list.get(i));
            }else if(max < happyCnt){
                max = happyCnt;
                list2.clear();
                list2.add(list.get(i));
            }
        }
        if(list2.size() == 1){
            Point point = list2.get(0);
            map[point.x][point.y] = inputArr[0];
            remStudent.add(new Point(point.x, point.y));

        }else if(list2.size() > 1){
            typeThree(inputArr, list2);
        }
    }

    private static void typeThree(int[] inputArr, List<Point> list){
        //행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
        int minX = list.get(0).x;
        int minY = list.get(0).y;

        for(int i = 0 ; i < list.size() ; i++){
            Point point = list.get(i);

            if(minX >= point.x){
                if(minX == point.x){
                    if(minY > point.y){
                        minX = point.x;
                        minY = point.y;
                    }
                }else if(minX > point.x){
                    minX = point.x;
                    minY = point.y;
                }
            }


        }
        map[minX][minY] = inputArr[0];
        remStudent.add(new Point(minX, minY));
    }

    private static int getAnswer(int[][] inputArr){
        int idx = 0;
        for(Point point : remStudent){
            int cnt = 0;
            for(int k = 0 ; k < 4 ; k++){
                int ax = point.x + dx[k];
                int ay = point.y + dy[k];

                if(ax < 1 || ax > N || ay < 1 || ay > N) continue;
                for(int i = 1 ; i <= 4 ; i++){
                    if(inputArr[idx][i] == map[ax][ay]){
                        cnt++;
                    }
                }
            }
            idx++;
            answer += cnt == 0 ? 0 : (int) Math.pow(10, cnt - 1);;
        }
        return answer;
    }
}
