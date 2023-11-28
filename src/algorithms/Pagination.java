package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Pagination<T>
{
	private List<T> srcLs = new ArrayList<>();
	private List<List<T>> lsOfPaged = new ArrayList<>();
	static private int PAGE_SIZE = 3;
	
	public Pagination(List<T> ls)
	{
		super();
		this.srcLs = ls;
		divideIntoPages();
	}
	
	private void divideIntoPages()
	{
		int totalPageNumsum = 0;
		if (this.srcLs.size() % PAGE_SIZE == 0)
		{
			totalPageNumsum = this.srcLs.size() / PAGE_SIZE;
			// array has exactly a divisible num of elements
			for (int i = 0; i < totalPageNumsum; i++)
			{
				List<T> selectedList = new ArrayList<>();
				for (int j = i * PAGE_SIZE; j < i * PAGE_SIZE + PAGE_SIZE; j++)
				{
					selectedList.add(this.srcLs.get(j));
				}
				this.lsOfPaged.add(selectedList);
			}
		}
		else
		{
			totalPageNumsum = this.srcLs.size() / PAGE_SIZE + 1;
			// array has remaining elements after divided by page_size
			List<T> selectedList = new ArrayList<>();
			for (int i = 0; i < totalPageNumsum - 1; i++)
			{
				for (int j = i * PAGE_SIZE; j < i * PAGE_SIZE + PAGE_SIZE; j++)
				{
					selectedList.add(this.srcLs.get(j));
				}
				this.lsOfPaged.add(selectedList);
				selectedList.clear();
			}
			// last page
			for (int k = (totalPageNumsum - 1) * PAGE_SIZE; k < this.srcLs.size(); k++)
			{
				selectedList.add(this.srcLs.get(k));
			}
			this.lsOfPaged.add(selectedList);
			selectedList.clear();
		}
	}
	
	public int getSize()
	{
		return this.srcLs.size();
	}
	
	public List<T> getPaginated(int pageNum)
	{
		return this.lsOfPaged.get(pageNum - 1);
	}
}
