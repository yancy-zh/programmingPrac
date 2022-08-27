package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Participant implements Comparable<Participant>
{
	int id;
	int sum = 0;
	List<Integer> scores;
	
	public Participant(int id, List<Integer> scores)
	{
		super();
		this.id = id;
		this.scores = scores;
		calcScores();
	}

	@Override
	public int compareTo(Participant o)
	{
		// compare by score sum
		if (this.sum > o.sum) // descending order
		{
			return -1;
		} else if (this.sum< o.sum)
		{
			return 1;
		} else {
			// high scores are in the set [10, 9, ...]
			for (int i = 10; i >= 1; i--)
			{
				if (chkCount(this.scores, i) > chkCount(o.scores, i))
				{
					return -1;
				}
			}
		}
		return 0;
	}
	
	private int chkCount(List<Integer> scores, int target)
	{
		int count = 0;
		for (int i = 0; i < scores.size(); i++)
		{
			if (scores.get(i) == target)
			{
				count++;
			}
		}
		return count;
	}
	
	private void calcScores()
	{
		for (int i = 0; i < this.scores.size(); i++)
		{
			this.sum += this.scores.get(i);
		}
	}
	
}

public class ScoreTheMatch
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String[] line = scanner.nextLine().split(",");
		// get M judges
		int M = Integer.parseInt(line[0]);
		// get N participants
		int N = Integer.parseInt(line[1]);
		if (M> 10 || M <3 || N> 100 || N<3)
		{
			System.out.println(-1); 
			return;
		}
		// score 2d,  data of scores, NxM, per row is a score set of one participant
		List<Participant> participants = new ArrayList<>(N); // N participants
		// scores in a 2d matrix
		List<List<Integer>> result = new ArrayList<>(M);
		// parse scores
		for (int j = 0; j < M; j++) // M 
		{
			List<Integer> oneRound = Arrays.asList(scanner.nextLine().split(",")).stream().map(Integer::valueOf).collect(Collectors.toList()); // scores given by all judges in one round
			result.add(oneRound);
		}
		
		for (int i = 0; i < N; i++) //N participants
		{
			List<Integer> scoresForOneParticipant= new ArrayList<>();
			for (int j = 0; j < M; j++) //M judges
			{
				scoresForOneParticipant.add(result.get(j).get(i));
			}
			Participant participant = new Participant(i, scoresForOneParticipant);
			participants.add(participant);
		}
		Collections.sort(participants);
		// output the top 3 participants' ids, separated by comma
		for (int k = 0; k < 3; k++)
		{
			if (k ==2) // last data
			{
				System.out.println(participants.get(k).id+1);
			}else {
				System.out.print(participants.get(k).id+1 + ",");
			}
		}
	}
}
