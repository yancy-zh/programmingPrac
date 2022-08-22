package algorithms;

public class findLongestSubstringAtLeastKTimes {
/* 395. 至少有 K 个重复字符的最长子串
 * 方法二：滑动窗口
我们枚举最长子串中的字符种类数目，它最小为 11，最大为 |\Sigma|∣Σ∣（字符集的大小，本题中为 2626）。

对于给定的字符种类数量 tt，我们维护滑动窗口的左右边界 l,rl,r、滑动窗口内部每个字符出现的次数 \textit{cnt}cnt，以及滑动窗口内的字符种类数目 \textit{total}total。当 \textit{total} > ttotal>t 时，我们不断地右移左边界 ll，并对应地更新 \textit{cnt}cnt 以及 \textit{total}total，直到 \textit{total} \le ttotal≤t 为止。*/
    public int longestSubstring(String s, int k) {
        int ret = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {
            int l = 0, r = 0;
            int[] cnt = new int[26];
            int tot = 0;
            int less = 0;
            while (r < n) {
                cnt[s.charAt(r) - 'a']++;
                if (cnt[s.charAt(r) - 'a'] == 1) {
                    tot++;
                    less++;
                }
                if (cnt[s.charAt(r) - 'a'] == k) {
                    less--;
                }

                while (tot > t) {
                    cnt[s.charAt(l) - 'a']--;
                    if (cnt[s.charAt(l) - 'a'] == k - 1) {
                        less++;
                    }
                    if (cnt[s.charAt(l) - 'a'] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }
}
