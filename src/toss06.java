import java.io.BufferedReader;
import java.io.InputStreamReader;

public class toss06 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String[] str = input.split(";");
		int[][] map = new int[50][50];
		String[] str2 = {};
		
		int x = 0;
		int y = 0;
		for(String s : str) {
			str2 = s.split(" ");
			for(String s2 : str2) {
				map[x][y] = Integer.parseInt(s2);
				y++;
			}
			x++;
			y=0;
		}
		int cnt = 0;
		for(int i = 0  ;i < map.length ; i++) {
			for(int j = 0 ; j <map[i].length ; j++) {
				if(map[i][j] == 1) {
					for(int k = 0 ; k < 4 ; k++) {
						int ax = i + dx[k];
						int ay = j + dy[k];
						if(map[ax][ay] != 1) {
							map[ax][ay] = 2;
							cnt ++;
						}
					}
				}
			}
		}
		
		
		System.out.println(cnt);
	}
}
