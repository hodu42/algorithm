package boj;

import java.io.*;
import java.util.*;

public class Boj11053 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] list = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		int result = 0;
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (list[j] < list[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
	}
}
