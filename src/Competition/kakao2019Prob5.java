package Competition;

import java.util.Arrays;

public class kakao2019Prob5 {

	public static void main(String[] args) {
		int[][] arr = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		solution(arr);
	}
	static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        int[][] map = new int[15][15];
        for(int i = 0 ; i < nodeinfo.length ; i++) {
        	map[nodeinfo[i][0]][nodeinfo[i][1]] = i+1;
        }
        for(int i = 0 ; i < 15 ; i ++) {
        	for(int j = 0 ; j < 15 ; j++) {
        		System.out.print(map[i][j] + " ");
        	}System.out.println();
        }
        int[] arr = new int[nodeinfo.length+1];
        int idx = 0;
        for(int i = 0 ; i < 10001 ; i++) {
        	for(int j = 0 ; j < 10001 ; j++) {
        		if(map[i][j] != 0)
        		arr[idx++] = map[i][j];
        	}
        }
        System.out.println(Arrays.toString(arr));
        return answer;
    }

}
