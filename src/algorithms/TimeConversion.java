package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeConversion
{
	/*
	 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
	 * 
	 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock. - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
	 * 
	 * Example
	 * 
	 * 
	 * Return '12:01:00'.
	 * 
	 * 
	 * Return '00:01:00'.
	 * 
	 * Function Description
	 * 
	 * Complete the timeConversion function in the editor below. It should return a new string representing the input time in 24 hour format.
	 * 
	 * timeConversion has the following parameter(s):
	 * 
	 * string s: a time in hour format Returns
	 * 
	 * string: the time in hour format Input Format
	 * 
	 * A single string that represents a time in -hour clock format (i.e.: or ).
	 * 
	 * Constraints
	 * 
	 * All input times are valid Sample Input
	 * 
	 * 07:05:45PM Sample Output
	 * 
	 * 19:05:45
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bufferedReader.readLine();
		
		String result = TimeConversion.timeConversion(s);
		
		System.out.println(result);
		bufferedReader.close();
	}
	
	public static String timeConversion(String s)
	{
		// parse 12:00:00AM
		String[] vals = s.split(":");
		int hh = Integer.parseInt(vals[0].strip()); // get hour
		String tag  = vals[2].substring(2); // get tag
		String mm = vals[1]; // get min
		String ss = vals[2].substring(0,2);
		StringBuilder out = new StringBuilder();
		if (tag == "AM")
		{
			if (hh == 12)
			{
				out.append("00");
			} else {
				out.append(hh);
			}
		} else {
			if (hh == 12)
			{
				out.append("12");
			}else {
				out.append(hh +12);
			}
		}
		out.append(":").append(mm).append(":").append(ss);
		return out.toString();
	}
	
}
