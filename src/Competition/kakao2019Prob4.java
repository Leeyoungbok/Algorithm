package Competition;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kakao2019Prob4 {

	static class Food {
		int index;
		int time;

		Food(int index, int time) {
			this.index = index;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		int[] food_times = { 4, 2, 3, 6, 7, 1, 5, 8 };
		long k = 27;
		System.out.println(solution(food_times, k));
	}

	private static int solution(int[] food_times, long k) {
		long total = 0;
		Comparator<Food> cmp_time = (a, b) -> {
			return a.time - b.time;
		};
		PriorityQueue<Food> que_time = new PriorityQueue<>(cmp_time);
		Comparator<Food> cmp_index = (a, b) -> {
			return a.index - b.index;
		};
		PriorityQueue<Food> que_index = new PriorityQueue<>(cmp_index);
		for (int i = 0; i < food_times.length; i++) {
			total += food_times[i];
			que_time.add(new Food(i + 1, food_times[i]));
		}
		if (total <= k)
			return -1;

		long cycle = food_times.length;
		long time = 0;
		int end = 0;
		while (true) {
			long remains = k - time;
			Food min = que_time.peek();
			min.time -= end;
			if (remains >= cycle * min.time) {
				que_time.poll();
				if (remains == cycle * min.time) {
					que_index.addAll(que_time);
					return que_index.peek().index;
				} else {
					time += min.time * cycle;
					end += min.time;
					cycle--;
				}
			} else {
				que_index.addAll(que_time);
				remains %= cycle;
				while (true) {
					Food answer = que_index.poll();
					if (remains == 0)
						return answer.index;
					remains--;
				}
			}
		}
	}
}
