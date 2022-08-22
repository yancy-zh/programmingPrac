package algorithms;

public class findLongestSubstringAtLeastKTimes {
/* 395. ������ K ���ظ��ַ�����Ӵ�
 * ����������������
����ö����Ӵ��е��ַ�������Ŀ������СΪ 11�����Ϊ |\Sigma|�O���O���ַ����Ĵ�С��������Ϊ 2626����

���ڸ������ַ��������� tt������ά���������ڵ����ұ߽� l,rl,r�����������ڲ�ÿ���ַ����ֵĴ��� \textit{cnt}cnt���Լ����������ڵ��ַ�������Ŀ \textit{total}total���� \textit{total} > ttotal>t ʱ�����ǲ��ϵ�������߽� ll������Ӧ�ظ��� \textit{cnt}cnt �Լ� \textit{total}total��ֱ�� \textit{total} \le ttotal��t Ϊֹ��*/
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
