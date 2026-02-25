import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.isEmpty() || (maxHeap.size() == minHeap.size())) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // minHeap의 최솟값은 maxHeap의 최댓값보다 커야 한다. 
            if(!minHeap.isEmpty() && minHeap.peek() < maxHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(minHeap.poll());
            }

            sb.append(maxHeap.peek()).append('\n');
        }

        System.out.println(sb);
    }
}
