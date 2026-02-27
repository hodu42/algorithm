
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Jaemin {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		Queue<Integer> minHeap = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if( maxHeap.size() == minHeap.size()) {
			maxHeap.offer(n);
			}else {
				minHeap.offer(n);
			}
			
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if(maxHeap.peek()> minHeap.peek()) {
					int max = maxHeap.poll();
					int min = minHeap.poll();
					
					maxHeap.offer(min);
					minHeap.offer(max);
				}
			}
			
			sb.append(maxHeap.peek()).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
