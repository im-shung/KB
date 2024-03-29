import java.util.Arrays;

/*
 
 	질문: n개의 바위를 제거 후 각 바위 사이의 거리의 최솟값 중 가장 큰 값을 구하라
 	-> 각 바위 사이의 거리 배열이 있다.
 	-> i번째 바위를 제거하면, i+1번째 값 += i번째 값이 되어야한다.
 	
 	-> 각 바위 사이의 거리가 최소가 되려면, 각 바위 사이의 거리 배열을 정렬해야 한다. 
 	-> 가운데 값이 n개의 바위를 제거 후 각 바위 사이의 거리의 최솟값 중 가장 큰 값이 된다. 
 */

class Solution {
	static int ROCKS_SIZE;
	
    public int solution(int distance, int[] rocks, int n) {
    	// 각 바위 사이의 거리 배열을 정렬한다.
        Arrays.sort(rocks);
    	
        ROCKS_SIZE = rocks.length;
        
        // diff := 출발지 - 바위 - 바위 - ... - 도착지 간의 '거리를 담는다.
        long[] diff = new long[ROCKS_SIZE + 1];
    	diff[0] = rocks[0];
    	diff[ROCKS_SIZE] = distance - rocks[ROCKS_SIZE];
    	for (int i = 1; i < ROCKS_SIZE; i++) {
    		diff[i] = rocks[i] - rocks[i - 1];
    	}
    	
    	
    	// binary search
    	// 
    	
    	
    	int answer = 0;
        return answer;
    }
}