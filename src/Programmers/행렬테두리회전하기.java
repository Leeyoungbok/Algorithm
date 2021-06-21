package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 행렬테두리회전하기 {
    public static void main(String[] args){
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2,2,5,4}, {3,3,6,6}, {5,1,6,3}};
        int[] answer = solution(rows, columns, queries);
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};

        int[][] map = new int[rows + 1][columns + 1];

        int cnt = 1;
        for(int i = 1 ; i <= rows ; i++){
            for(int j = 1 ; j <= columns ; j++){
                map[i][j] = cnt++;
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < queries.length ; i++){
            int rem = map[queries[i][0]][queries[i][3]];

            for(int j = queries[i][1] ; j < queries[i][3] ; j++){
                map[queries[i][0]][j + 1] = map[queries[i][0]][j];
            }

            map[queries[i][0] + 1][queries[i][3]] = rem;
            rem = map[queries[i][2]][queries[i][3]];
            for(int j = queries[i][0] + 2 ; j < queries[i][2] ; j++){
                map[j + 1][queries[i][3]] = map[j][queries[i][3]];
            }

            map[queries[i][2]][queries[i][3] - 1] = rem;
            rem = map[queries[i][2]][queries[i][1]];
            for(int j = queries[i][1] ; j < queries[i][3] - 2 ; j++){
                map[queries[i][2]][j] = map[queries[i][2]][j + 1];
            }

            map[queries[i][2] - 1][queries[i][0]] = rem;
            for(int j = queries[i][0] ; j < queries[i][2] - 2 ; j++){
                map[j][queries[i][1]] = map[j + 1][queries[i][1]];
            }

            for(int a = 1 ; a <= rows ; a++){
                for(int b = 1 ; b <= columns ; b++){
                    System.out.print(map[a][b] + " ");
                }System.out.println();
            }
        }

        Integer[] ret = list.toArray(new Integer[list.size()]);
        return Arrays.stream(ret).mapToInt(i -> i).toArray();
    }
}
