package plusInterviewed;

import java.util.Arrays;

public class MeetingRooms
{
	
	public static void main(String[] args)
	{
		// https://leetcode.cn/problems/meeting-rooms/description/?envType=study-plan-v2&envId=premium-algo-100
		/*
		 * 252. Meeting Rooms 简单 相关标签 相关企业 Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all
		 * meetings.
		 * 
		 * Example 1: Input: intervals = [[0,30],[5,10],[15,20]] Output: false Example 2: Input: intervals = [[7,10],[2,4]] Output: true
		 * 
		 * Constraints: 0 <= intervals.length <= 10^4 intervals[i].length == 2 0 <= starti < endi <= 10^6
		 */
		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println(canAttendMeetings(intervals));
		int[][] intervals2 = { { 7, 10 }, { 2, 4 } };
		System.out.println(canAttendMeetings(intervals2));
	}
	
	public static boolean canAttendMeetings(int[][] intervals)
	{
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		for (int i = 0; i < intervals.length - 1; i++)
		{
			if (intervals[i][1] > intervals[i + 1][0])
			{ return false; }
		}
		return true;
	}
}
