package SW_Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1873 {
	static int H, W;
	static char[][] map;
	static Tank tank;
	static int[] di = {-1,1,0,0}; // 0:상 1:하 2:좌 3:우
	static int[] dj = {0,0,-1,1};
	static final int UP=0, DOWN=1, LEFT=2, RIGHT=3;
	static int orderCnt;
	static String order;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			
			for(int i=0; i<H; i++) { // 맵 정보를 입력받음.
				String line = br.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = line.charAt(j);
					switch(map[i][j]) { // 전차가 입력 들어오네 ?! 전차의 좌표, 방향을 기록하고 그자리는 평지임.
					case '^': 
						tank = new Tank(i,j);
						tank.dir = UP;
						map[i][j] = '.';
						break;
					case 'v':
						tank = new Tank(i,j);
						tank.dir = DOWN;
						map[i][j] = '.';
						break;
					case '<':
						tank = new Tank(i,j);
						tank.dir = LEFT;
						map[i][j] = '.';
						break;
					case '>':
						tank = new Tank(i,j);
						tank.dir = RIGHT;
						map[i][j] = '.';
						break;
					}
				}
			} // 입력 끝
			
			orderCnt = Integer.parseInt(br.readLine()); // 명령 갯수
			order = br.readLine(); // 명령어 묶음.
			
			for(int i=0; i<orderCnt; i++) {
				char op = order.charAt(i); // 명령어 글자를 떼서
				if(op=='S') { // 포탄 발사 명령인 경우
					int ni = tank.i; // 전차 위치에서 포탄이 출발함.
					int nj = tank.j;
					while(true) { // 포탄이 얼마나 날아갈지 몰르니까
						ni = ni + di[tank.dir]; // 일단 전차 방향으로 한칸 이동한 좌표
						nj = nj + dj[tank.dir];
						if(ni>=H || ni<0 || nj>=W || nj<0 || map[ni][nj]=='#') // 맵밖 or 강철벽
							break;
						
						if(map[ni][nj]=='*') { // 위의 if에 안걸렸으면 일단 맵 안에 있음. 벽돌벽인 경우.
							map[ni][nj]='.';
							break;
						}
					}					
				}else { // 이동 명령인 경우
					switch(op) { // 일단 현재 전차의 방향을 변경하고.
					case 'U': tank.dir = UP; break;
					case 'D': tank.dir = DOWN; break;
					case 'L': tank.dir = LEFT; break;
					case 'R': tank.dir = RIGHT; break;
					} // 방향 변경함.
					int ni = tank.i + di[tank.dir];
					int nj = tank.j + dj[tank.dir];
					if(ni>=0 && ni<H && nj>=0 && nj<W && map[ni][nj]=='.') { // 바뀐 방향에서 칸 이동
						tank.i = ni; 
						tank.j = nj;
					}
				}
			} // 명령어 실행 loop
			
			switch(tank.dir) {
			case UP: 	map[tank.i][tank.j]='^';break;
			case DOWN: 	map[tank.i][tank.j]='v';break;
			case LEFT: 	map[tank.i][tank.j]='<';break;
			case RIGHT: map[tank.i][tank.j]='>';break;
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	static class Tank{
		int i, j, dir;
		Tank(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}









