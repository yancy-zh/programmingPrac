package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortStudents
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int count = Integer.parseInt(sc.nextLine());
		String[] high = sc.nextLine().split(" ");
		String[] weight = sc.nextLine().split(" ");
		List<Player> playerList = new ArrayList<>();
		for (int i = 0; i < count; i++)
		{
			playerList.add(new Player(i + 1, Integer.parseInt(high[i]), Integer.parseInt(weight[i])));
		}
		playerList.sort(null);
		for (int i = 0; i < playerList.size(); i++)
		{
			System.out.print(playerList.get(i).idx + " ");
		}
	}
	
	static class Player implements Comparable<Player>
	{
		private int idx;
		private int high;
		private int weight;
		
		public Player(int idx, int high, int weight)
		{
			this.idx = idx;
			this.high = high;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Player ply)
		{
			if (ply.high > this.high)
			{ return -1; } else if (ply.weight > this.weight)
			{ return -1; } else if (ply.idx > this.idx)
			{ return -1; } else return 1;
		}
	}
	
}
