package algorithms;

public class findProvinceNums {
	public int findCircleNum(int[][] connections) {
		//在一个图里面找出省的数目,“省份数量”
		int numCities = connections.length;
		boolean[] visited = new boolean[numCities];
		int circles = 0;
		for (int i = 0; i < numCities; i++) {
			if (!visited[i]) {
				dfs(connections, visited, numCities, i);
				circles++;
			}
		}
		return circles;
	}
	
	public void dfs(int[][] connections, boolean[] visited, int numProvinces, int i) {
		for (int j = 0; j < numProvinces; j++) {
			if (connections[i][j] == 1 && !visited[j]) {
				visited[j] = true;
				dfs(connections, visited, numProvinces, j);
			}
		}
	}
}
