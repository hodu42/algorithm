import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
	static int n;
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<n;i++) {
    		maxHeap.add(Integer.parseInt(br.readLine()));
    		int minSize = minHeap.size();
    		int maxSize = maxHeap.size();
    		
    		if(maxSize >= minSize + 2) {
    			int mid = maxHeap.poll();
    			minHeap.add(mid);
    		}
    		
    		if(!minHeap.isEmpty()){
    			if(minHeap.peek() < maxHeap.peek()) {
        			int minTemp = minHeap.poll();
        			int maxTemp = maxHeap.poll();
        			maxHeap.add(minTemp);
        			minHeap.add(maxTemp);
        		}
    		}
    		sb.append(maxHeap.peek()).append("\n");
    	}
        System.out.println(sb.toString());
    }
}