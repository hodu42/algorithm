import java.io.*;
import java.util.*;

public class Main {
	
	public static class SegmentTree {
		private int[] tree;
		private int n;
		
		public SegmentTree(int n) {
			this.n = n;
			this.tree = new int[n * 4];
		}
		
		public int query(int left, int right) {
			return query(1, 0, n - 1, left, right);
		}
		
		private int query(int node, int start, int end, int left, int right) {
			if(right < start || end < left) {
				return 0;
			}
			if(left <= start & end <= right) {
				return tree[node];
			}
			int mid = (start + end) / 2;
			int leftQuery = query(node * 2, start, mid, left, right);
			int rightQuery = query(node * 2 + 1, mid + 1, end, left, right);
			return Math.max(leftQuery, rightQuery);
		}
		
		public int update(int index, int value) {
			return update(1, 0, n - 1, index, value);
		}
		
		private int update(int node, int start, int end, int index, int value) {
			if(index < start || end < index) {
				return tree[node];
			}
			if(start == end) {
				return tree[node] = value;
			}
			int mid = (start + end) / 2;
			int leftUpdate = update(node * 2, start, mid, index, value);
			int rightUpdate = update(node * 2 + 1, mid + 1, end, index, value);
			return tree[node] = Math.max(leftUpdate, rightUpdate);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SegmentTree st = new SegmentTree(1001);
		for(int i = 0; i < n; i++) {
			int input = sc.nextInt();
			int q = st.query(0, input - 1);
			st.update(input, q + 1);
		}
		System.out.println(st.query(0, 1000));
		
	}
}