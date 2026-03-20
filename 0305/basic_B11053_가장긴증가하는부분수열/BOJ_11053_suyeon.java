import java.io.*;
import java.util.*;

public class BOJ_11053_suyeon {
	public static int N, A[], memo[], resMax;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		A = new int[N];
		memo = new int[N];
		resMax = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			
			int max = 1;
			for(int j = i-1; j >= 0; j--) {
				if(A[j] < A[i])
					max = Math.max(max, memo[j]+1);
				else if(A[j] == A[i])
					max = Math.max(max, memo[j]);
			}
			
			resMax = Math.max(resMax, max);
			memo[i] = max;
		}
		System.out.println(resMax);
	}
}