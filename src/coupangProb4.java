import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class coupangProb4 {

	public static void main(String[] args) {
		String depar = "SEOUL";
		String hub = "DAEGU";
		String dest = "YEOSU";
		
		String[][] roads = {{"ULSAN","BUSAN"},{"DAEJEON","ULSAN"},{"DAEJEON","GWANGJU"},{"SEOUL","DAEJEON"},{"SEOUL","ULSAN"},{"DAEJEON","DAEGU"},{"GWANGJU","BUSAN"},{"DAEGU","GWANGJU"},{"DAEGU","BUSAN"},{"ULSAN","DAEGU"},{"GWANGJU","YEOSU"},{"BUSAN","YEOSU"}};
		System.out.println(solution(depar, hub, dest, roads));
	}
	
	public static int solution(String depar, String hub, String dest, String[][] roads) {
		int answer = 0;
		boolean[][] matrix = new boolean[10001][10001];
		long[] memo = new long[10001]; 
		Map<String, Integer> map = new HashMap<>();
		
		int idx = 0;
		for(int i = 0 ; i < roads.length ; i++) {
			int start = -1;
			int end = -1;
			if(!map.containsKey(roads[i][0])) {
				map.put(roads[i][0], idx);
				start = idx++;
			}else {
				start = map.get(roads[i][0]);
			}
			if(!map.containsKey(roads[i][1])) {
				map.put(roads[i][1], idx);
				end = idx++;
			}else {
				end = map.get(roads[i][1]);
			}
			matrix[start][end] = true;
		}

		Queue<Truck> queue = new LinkedList<>();
		
		queue.add(new Truck(map.get(depar), false));
		memo[map.get(depar)] = 1;
		long cnt = 0;
		while(!queue.isEmpty()) {
			Truck t = queue.poll();
			if(t.s == map.get(dest)) {
				if(t.hubCheck)
					cnt++;
				continue;
			}
			for(int i = 0 ; i < idx ; i++) {
				if(t.s == i) continue;
				if(!matrix[t.s][i]) continue;
				if(t.s == map.get(hub)) queue.add(new Truck(i, true));
				else queue.add(new Truck(i, t.hubCheck));
			}
		}
//		cnt = memo[map.get(hub)] * memo[map.get(dest)];
		answer = (int)cnt%10007;
		return answer;
	}
	
	static class Truck{
		int s;
		boolean hubCheck;
		Truck(int s, boolean hubCheck){
			this.s = s;
			this.hubCheck = hubCheck;
		}
	}

}
