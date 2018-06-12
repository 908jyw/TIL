/*
<�׸� 1>�� ���� ���簢�� ����� ������ �ִ�. 1�� ���� �ִ� ����, 0�� ���� ���� ���� ��Ÿ����. 
ö���� �� ������ ������ ����� ������ ������ ������ �����ϰ�, ������ ��ȣ�� ���̷� �Ѵ�. 
���⼭ ����Ǿ��ٴ� ���� � ���� �¿�, Ȥ�� �Ʒ����� �ٸ� ���� �ִ� ��츦 ���Ѵ�. �밢���� ���� �ִ� ���� ����� ���� �ƴϴ�. 
<�׸� 2>�� <�׸� 1>�� �������� ��ȣ�� ���� ���̴�. ������ �Է��Ͽ� �������� ����ϰ�, 
�� ������ ���ϴ� ���� ���� ������������ �����Ͽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.


�Է�
ù ��° �ٿ��� ������ ũ�� N(���簢���̹Ƿ� ���ο� ������ ũ��� ������ 5��N��25)�� �Էµǰ�, �� ���� N�ٿ��� ���� N���� �ڷ�(0Ȥ�� 1)�� �Էµȴ�.

���
ù ��° �ٿ��� �� �������� ����Ͻÿ�. �׸��� �� ������ ���� ���� ������������ �����Ͽ� �� �ٿ� �ϳ��� ����Ͻÿ�.
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
