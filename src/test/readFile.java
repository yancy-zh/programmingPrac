
package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class readFile
{
	public final List<Object> readRecords(final File pmfFile)
	{
		List<Object> outList = new ArrayList<>();
		BufferedReader bufferedReader = null;
		try
		{
			bufferedReader = new BufferedReader(new FileReader(pmfFile));
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String row = null;
		try
		{
			row = bufferedReader.readLine();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String code = row.substring(0, 0);
		String content = row.substring(1);
		if (code.equals("1"))
		{
			outList.add(content);
		}
		else if (code.equals("2"))
		{
			outList.add(Short.parseShort(content));
		}
		else if (code.equals("3"))
		{
			outList.add(Float.parseFloat(content));
		}
		else
		{
			outList.add(null);
		}
		return outList;
	}
}