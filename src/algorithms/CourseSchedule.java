package algorithms;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule
{
	List<List<Integer>> edges;
	int[] visited;
	boolean valid = true;
	
	public boolean canFinish(int numCourses, int[][] prerequisites)
	{
		edges = new ArrayList<>();
		for (int i = 0; i < numCourses; i++)
		{
			edges.add(new ArrayList<Integer>());
		}
		visited = new int[numCourses];
		for (int[] requirement : prerequisites)
		{
			edges.get(requirement[1]).add(requirement[0]);
		}
		for (int i = 0; i < numCourses && valid; i++)
		{
			if (visited[i] == 0)
			{
				dfs(i);
			}
		}
		return valid;
		
	}
	
	public void dfs(int u)
	{
		visited[u] = 1;
		for (int v : edges.get(u))
		{
			if (visited[v] == 0)
			{
				dfs(v);
				if (!valid)
				{ return; }
			}
			else if (visited[v] == 1)
			{
				valid = false;
				return;
			}
		}
		visited[u] = 2;
	}
}
