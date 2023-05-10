package huaweiCodingPrac;

public class CountFrogs {
	/*
	 * 1419. Minimum Number of Frogs Croaking You are given the string croakOfFrogs,
	 * which represents a combination of the string "croak" from different frogs,
	 * that is, multiple frogs can croak at the same time, so multiple "croak" are
	 * mixed.
	 * 
	 * Return the minimum number of different frogs to finish all the croaks in the
	 * given string.
	 * 
	 * A valid "croak" means a frog is printing five letters 'c', 'r', 'o', 'a', and
	 * 'k' sequentially. The frogs have to print all five letters to finish a croak.
	 * If the given string is not a combination of a valid "croak" return -1.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: croakOfFrogs = "croakcroak" Output: 1 Explanation: One frog yelling
	 * "croak" twice. Example 2:
	 * 
	 * Input: croakOfFrogs = "crcoakroak" Output: 2 Explanation: The minimum number
	 * of frogs is two. The first frog could yell "crcoakroak". The second frog
	 * could yell later "crcoakroak". Example 3:
	 * 
	 * Input: croakOfFrogs = "croakcrook" Output: -1 Explanation: The given string
	 * is an invalid combination of "croak" from different frogs.
	 * 
	 * 
	 * Constraints:
	 * 
	 * 1 <= croakOfFrogs.length <= 105 croakOfFrogs is either 'c', 'r', 'o', 'a', or
	 * 'k'.
	 */

	static {
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static final char[] previous = new char['s'];
	static {
		char[] croakPattern = "croakc".toCharArray();
		for (int i = 1; i < croakPattern.length; i++) {
			previous[croakPattern[i]] = croakPattern[i - 1];
		}
	}

	public int minNumberOfFrogs(String croakOfFrogs) {
		int[] cnt = new int['s'];
		for (char ch : croakOfFrogs.toCharArray()) {
			char pre = previous[ch];
			if (cnt[pre] > 0) {
				cnt[pre]--;
			} else if (ch != 'c') {
				return -1;
			}
			cnt[ch]++;
		}
		if (cnt['c'] > 0 || cnt['r'] > 0 || cnt['o'] > 0 || cnt['a'] > 0) {
			return -1;
		}
		return cnt['k'];
	}
}
