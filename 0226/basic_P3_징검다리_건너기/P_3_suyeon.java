import java.io.*;
import java.util.*;

class P_3_suyeon {
    public int solution(int[] stones, int k) {
		int answer = Integer.MAX_VALUE;
		
        int left = 0, right =  200000000;
        int mid = 0;
        
        while(left <= right) {
            mid = (left + right) / 2;
            
            int cnt = 0;
            boolean isAvail = false;
            for(int i = 0; i < stones.length; i++) {
                if(stones[i] <= mid)
                    cnt++;
                else cnt = 0;
                
                if(cnt >= k) {
                    isAvail = true;
                    break;
                }
            }
            
            if(isAvail) {
                answer = Math.min(answer, mid);
                
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}