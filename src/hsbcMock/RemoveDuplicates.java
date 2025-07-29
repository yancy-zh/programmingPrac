package hsbcMock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import utils.MyConverter;

public class RemoveDuplicates {
	public int[] removeDuplicates(int[] inarr) {
		List<Integer> outArr = new ArrayList<>();
		HashSet<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < inarr.length; i++) {
			int j = inarr[i];
			if (!set.contains(j)) {
				outArr.add(j);
				set.add(j);
			}
		}
		int[] res = new int[] {};
		MyConverter conv = new MyConverter();
		res = conv.ListIntToPrimitive(outArr);
		return res;
	}
}
