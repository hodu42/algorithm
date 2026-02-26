import java.io.*;
import java.util.*;

public class Minjun {
    static public int solution(int[] stones, int k) {
    	// 정렬할 필요없는 이분 탐색
    	// 시각을 다르게 해라...
    	
    	int answer = 0;
    	
    	int left = 1;
    	int right = 200000000;
    	int mid = 0;
    	
        while(left <= right) {
        	mid = (left + right) / 2;
        	int cnt = 0;
        	boolean isValid = true;
        	
        	for (int i = 0; i < stones.length; i++) {
        		if(stones[i] < mid) {
        			cnt++;
        		} else {
        			cnt = 0;
        		}
        		
        		if (cnt == k) {
        			isValid = false;
        			break;
        		}
        	}
        	
        	if(isValid) {
        		answer = mid;
        		left = mid + 1;
        	} else {
        		right = mid - 1;
        	}
        }
        return answer;
    }
}