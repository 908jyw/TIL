/*
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. 
<그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 
각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.


입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_PutNum_2667 {
	
	static int map[][];
	static int N;
	static int cnt;
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		Queue q = new LinkedList<Integer>();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j+1));
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					dfs(i,j);
					q.add(cnt);
				}
			}
		}
		
		int arr[] = new int[q.size()];

		System.out.println(q.size());

		for(int i=0; !q.isEmpty(); i++) {
			arr[i] = (int) q.poll();
		}
		Arrays.sort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void dfs(int n, int m) {
		cnt++;
		visited[n][m] = true;
		
		if(m<N-1 && map[n][m+1]==1 && !visited[n][m+1]) {
			dfs(n,m+1);
		}
		if(n<N-1 && map[n+1][m]==1 && !visited[n+1][m]) {
			dfs(n+1,m);
		}
		if(m>0 && map[n][m-1]==1 && !visited[n][m-1]) {
			dfs(n,m-1);
		}
		if(n>0 && map[n-1][m]==1 && !visited[n-1][m]) {
			dfs(n-1,m);
		}
	}
}
