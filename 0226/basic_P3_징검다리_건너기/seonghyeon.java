import java.util.*;

class Solution {
    
    public int solution(int[] stones, int k) {
        // 조건 1 : 디딤돌은 한 번 밟을 때마다 1씩 줄어든다.
        // 조건 2 : 디딤돌의 값이 0이면 밟을 수 없음. 이때는 건너뛰어 다음 디딤돌을 밟을 수 있다.
        // 조건 3 : 갈 수 있는 디딤돌이 여러 개이면 가장 가까운거 부터 가야함.
        
        
        int left = 0;
        int right = Arrays.stream(stones).max().orElse(0);
        int answer = 0;
        while(left<=right) {
			int mid = (left+right) / 2;
			if(canCross(stones,k,mid)) {
				answer = mid;
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
        return answer;
    }
    
    private boolean canCross(int[] stones, int k, int people){
        int continues = 0;
		
		for(int stone : stones) {
			if(stone <  people) {
				if(++continues >= k) {
					return false;
				}
			}else {
				continues = 0;
			}
		}
		return true;
    }
}