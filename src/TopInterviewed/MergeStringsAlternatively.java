package TopInterviewed;

public class MergeStringsAlternatively {
//leetcode 1768 Merge Strings Alternately
	public static void main(String[] args) {
		String word1 = "abc", word2 = "pqr";
		System.out.println(mergeAlternately(word1, word2).equals("apbqcr"));
	}

	public static String mergeAlternately(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		boolean flagWord1IsShorter = true;
		boolean flagWordsAreEqual = false;
		int mergeLen;
		if (m < n) {
			mergeLen = m;
		} else if (m > n) {
			mergeLen = n;
			flagWord1IsShorter = false;
		} else {
			mergeLen = m;
			flagWordsAreEqual = true;
		}
		int i = 0, j = 0, k = m + n;
		char[] out = new char[k];
		while (i < mergeLen) {
			out[j++] = word1.charAt(i);
			out[j++] = word2.charAt(i);
			i++;
		}
		if (!flagWordsAreEqual) {
			if (flagWord1IsShorter) {
				while (i < n) {
					out[j++] = word2.charAt(i++);
				}
			} else {
				while (i < m) {
					out[j++] = word1.charAt(i++);
				}
			}
		}
		return String.valueOf(out);
	}

}
