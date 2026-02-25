import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int index;
        int value;
        
        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.value, this.value);
        }
    }
    
    public int solution(int[] stones, int k) {
        int n = stones.length;
        
        int[] maxTime = new int[n];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.add(new Node(i, stones[i]));
            
            
            Node curMax = pq.poll();
            while(curMax.index <= i - k) {
                curMax = pq.poll();
            }
            
            maxTime[i] = curMax.value;
            
            pq.add(curMax);
            
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = k-1; i < n; i++) {
            min = Math.min(min, maxTime[i]);
        }
        
        return min;
    }
}