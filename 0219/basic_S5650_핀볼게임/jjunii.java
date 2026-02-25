package swea;

import java.io.*;
import java.util.*;

public class Swea5650 {

	static int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};	//  상 하 좌 우
	static int[][] turn = new int[][] {{1, 0, 3, 2}, {1, 3, 0, 2}, {3, 0, 1, 2}, {2, 0, 3, 1}, {1, 2, 3, 0}, {1, 0, 3, 2}};	// 0(벽), 1, 2, 3, 4, 5 방향전환(상하좌우)
	
	static Map<Integer, List<int[]>> wormhole= new HashMap<>(); 	// 웜홀 최대 5개, 한 쌍, 좌표
	static int[][] map;
	static int N, result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= t; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			wormhole.clear();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 6) {
						wormhole.computeIfAbsent(map[i][j], k -> new ArrayList<>()).add(new int[] {i, j});
					}
				}
			}

			result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						map[i][j] = -1;
						for (int d = 0; d < 4; d++) {
							play(i, j, d);
						}
						map[i][j] = 0;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void play(int x, int y, int d) {
		int cnt = 0;
		while (true) {
			x += dir[d][0];
			y += dir[d][1];
			
			// 벽
			if (x < 0 || x >= N || y < 0 || y >= N) {
				cnt++;
				d = turn[0][d];
				continue;
			}
			
			int c = map[x][y];
			//  시작 위치 or 블랙홀
			if (c == -1) {
				result = Math.max(result, cnt);
				return;
			}
			
			// 블록
			if (c >= 1 && c <= 5) {
				cnt++;
				d = turn[c][d];
			} else if (c >= 6 && c <=10) {	// 웜홀
				for (int[] coordinate : wormhole.get(c)) {
					if (x != coordinate[0] || y != coordinate[1]) {
						x = coordinate[0];
						y = coordinate[1];
						break;
					}
				}
			}
		}
	}
}
