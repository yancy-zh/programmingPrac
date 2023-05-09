import java.util.HashMap;
import java.util.Map;

public class CheckAlmostEquivalence {

	public static boolean checkAlmostEquivalent(String word1, String word2) {
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		Map<Character, Integer> map2 = new HashMap<Character, Integer>();
		for (int i = 0; i < 26; i++) {
			map1.put((char) ('a' + i), 0);
			map2.put((char) ('a' + i), 0);
		}
		for (int j = 0; j < word1.length(); j++) {
			map1.put(word1.charAt(j), map1.get(word1.charAt(j)) + 1);
		}
		for (int k = 0; k < word2.length(); k++) {
			map2.put(word2.charAt(k), map1.get(word2.charAt(k)) + 1);
		}
		for (Character temp : map1.keySet()) {
			if (map1.get(temp) - map2.get(temp) > 3) {
				return false;
			}
		}
		return true;
	}
}
