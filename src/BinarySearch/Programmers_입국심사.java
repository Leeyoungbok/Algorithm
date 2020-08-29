package BinarySearch;

public class Programmers_입국심사 {
	class Solution {
	    public long solution(int n, int[] times) {
	        long answer = 0;
	        long min = 1, max = 0;
	        for(int n1 : times){
	            max = max < n1 ? n1 : max;
	        }
	        
	        max *= n;
	        System.out.println("min : " + min + " / max : " + max);
	        
	        while(min <= max){
	            long avg = (min + max) / 2;
	            long num = 0;
	            for(int n1 : times){
	                num += avg / n1;
	            }
	            
	            if(num >= n){
	                answer = avg;
	                max = avg - 1;
	            }
	            else if(num < n)
	                min = avg + 1;
	        }
	        
	        return answer;
	    }
	}
}
