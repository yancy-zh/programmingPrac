package algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PartitionFindAllPalindrome {
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // Stack ����� Java ���ĵ����Ƽ�д�� Deque<Integer> stack = new ArrayDeque<Integer>();
        // ע�⣺ֻʹ�� stack ��صĽӿ�
        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, len, stack, res);
        return res;
    }

    /**
     * @param charArray
     * @param index     ��ʼ�ַ�������
     * @param len       �ַ��� s �ĳ��ȣ���������Ϊȫ�ֱ���
     * @param path      ��¼�Ӹ���㵽Ҷ�ӽ���·��
     * @param res       ��¼���еĽ��
     */
    private void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < len; i++) {
            // ��Ϊ��ȡ�ַ������������ܵģ���ˣ����ô��Ӵ��±�ķ�ʽ�ж�һ���Ӵ��Ƿ��ǻ����Ӵ�
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, len, path, res);
            path.removeLast();
        }
    }

    /**
     * ��һ����ʱ�临�Ӷ��� O(N)���Ż��Ľⷨ�ǣ��Ȳ��ö�̬�滮���ѻ����Ӵ��Ľ����¼��һ�������
     *
     * @param charArray
     * @param left      �Ӵ�����߽磬����ȡ��
     * @param right     �Ӵ����ұ߽磬����ȡ��
     * @return
     */
    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
	
}

