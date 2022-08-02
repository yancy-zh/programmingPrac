package algorithms;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Pattern;

public class Solutions {
	/*
	 * to create a new instance Solutions sol= new Solutions();
	 * System.out.println(sol.validIPAddress2(ipString));
	 */
	public String reformatDate(String date) {
		/*将给定日期变换格式打�?
		 * 示例 1�? 输入：date = "20th Oct 2052" 输出�?"2052-10-20" 示例 2�?
		 * 
		 * 输入：date = "6th Jun 1933" 输出�?"1933-06-06" 示例 3�?
		 * 
		 * 输入：date = "26th May 1960" 输出�?"1960-05-26"
		 */
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		HashMap<String, Integer> monthStr2Num = new HashMap<>();
		for (int i = 0; i < months.length; i++) {
			monthStr2Num.put(months[i], i + 1);
		}
		String[] array = date.split(" ");
		int year = Integer.parseInt(array[2]);
		int month = monthStr2Num.get(array[1]);
		int currDate = Integer.parseInt(array[0].substring(0, array[0].length() - 2));
		return String.format("%d-%02d-%02d", year, month, currDate);
	}

	public int hammingWeight(int n) {
		/* leetcode 191. �?1的个�? 
		 * 编写�?个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）�??
		 * int inNum = 11111111111111111111111111111100;
		 */
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			if ((n & (1 << i)) != 0) {
				ret++;
			}
		}
		return ret;
	}

	public int numFriendRequests(int[] ages) {
		/* 适龄的朋�? leetcode 825
		 * 人们会互相发送好友请求，现在给定�?个包含有他们年龄的数组，ages[i] 表示�? i 个人的年龄�??
		当满足以下任�?条件时，A 不能�? B（A、B不为同一人）发�?�好友请求：
		
		age[B] <= 0.5 * age[A] + 7
		age[B] > age[A]
		age[B] > 100 && age[A] < 100
		否则，A 可以�? B 发�?�好友请求�??
		
		注意如果 A �? B 发出了请求，不等�? B 也一定会向 A 发出请求。�?�且，人们不会给自己发�?�好友请求�?��?
		
		求�?�共会发出多少份好友请求?
		 * int[] ages = {20,30,100,110,120};
		 */
		int res = 0;
		int[] count = new int[121];
		for (int age : ages)
			count[age]++;
		for (int ageA = 0; ageA <= 120; ageA++) {
			// 友人A
			int countA = count[ageA]; //得到年龄为ageA的友人数�?
			for (int ageB = 0; ageB <= 120; ageB++) {
				// 友人B
				int countB = count[ageB]; //得到年龄为ageB的友人数�?
				if (ageA * 0.5 + 7 >= ageB)
					continue;
				if (ageA < 100 && ageB > 120)
					continue;
				if (ageA < ageB)
					continue;
				res += countA * countB; //当年龄ageA 和ageB满足交友要求时，可发送交友请求的数量为此年龄友人数量之积�?
				if (ageA == ageB)
					res -= countA;
			}
		}
		return res;
	}

	public String validIPAddress1(String IP) {
		/*
		 * 输入：IP = "172.16.254.1" 输出�?"IPv4"
		 */
		String[] answerStrings = { "IPv4", "IPv6", "Neither" };
		try {
			InetAddress addType = InetAddress.getByName(IP);
			if (addType instanceof Inet4Address) {
				return answerStrings[0];
			} else if (addType instanceof Inet6Address) {
				return answerStrings[1];
			} else {
				return answerStrings[2];
			}
		} catch (Exception e) {
			return answerStrings[2];
		}
	}

	public String validIPAddress2(String IP) {
		/*
		 * 输入：IP = "172.16.254.1" 输出�?"IPv4" e.g. String ipString =
		 * "2001:0db8:85a3:0:0:8A2E:0370:7334";
		 */
		String[] answerStrings = { "IPv4", "IPv6", "Neither" };
		String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
		Pattern patternIpv4 = Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");
		String chunkIpv6 = "[0-9a-fA-F]{1,4}";
		Pattern patternIpv6 = Pattern.compile("^(" + chunkIpv6 + "\\:){7}" + chunkIpv6 + "$");
		if (IP.contains(".")) {
			return (patternIpv4.matcher(IP).matches()) ? answerStrings[0] : answerStrings[2];
		} else if (IP.contains(":")) {
			return (patternIpv6.matcher(IP).matches()) ? answerStrings[1] : answerStrings[2];
		} else {
			return answerStrings[2];
		}
	}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		/* leetcode 57
		 * 给你�?�? 无重叠的 ，按照区间起始端点排序的区间列表�?
		 * 在列表中插入�?个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）�??
		 */
		int left = newInterval[0];
		int right = newInterval[1];
		boolean placed = false;
		java.util.List<int[]> outList = new ArrayList<int[]>();
		for (int[] interval : intervals) {
			if (right < interval[0]) { // new interval is smaller than the left, no intersection
				if (!placed) {
					outList.add(new int[] { left, right });
					placed = true;
				}
				outList.add(interval);
			} else if (left > interval[1]) {
				// interval is inserted to the left
				outList.add(interval);
			} else {
				// has a intersection, and merge
				left = Math.min(left, interval[0]);
				right = Math.max(right, interval[1]);

			}
			if (!placed) {
				outList.add(interval);
			}
		}
		int[][] merged = new int[outList.size()][2];
		for (int i = 0; i < outList.size(); i++) {
			merged[i] = outList.get(i);

		}
		return merged;
	}

	public int removeElement(int[] nums, int val) {
		int slowIndex = 0;
		for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
			if (val != nums[fastIndex]) {
				nums[slowIndex++] = nums[fastIndex];
			}
		}
		return slowIndex;
	}

	public int[][] findContinuousSequence(int target) {
		/*
		 * int[][] res = solv.findContinuousSequence(15); for (int i = 0; i <
		 * res.length; i++) { for (int j = 0; j < res[i].length; j++) {
		 * System.out.print(res[i][j] + " "); } System.out.println(); }
		 */
		int i = 1;
		int j = 1;
		int sum = 0; // sum of the sliding window
		java.util.List<int[]> res = new ArrayList<>();
		while (i <= target / 2) {
			if (sum < target) {
				// right pointer moves to the right
				sum += j;
				j++;
			} else if (sum > target) {
				// left pointer move to the left
				sum -= i;
				i++;
			} else {
				// record result
				int[] arr = new int[j - i];
				for (int k = i; k < j; k++) {
					arr[k - i] = k;
				}
				res.add(arr);
				sum -= i;
				i++;
			}
		}
		return res.toArray(new int[res.size()][]);
	}

	public int[] plusOne(int[] digits) {
		/*
		 * Solutions solv = new Solutions(); int[] inArr = {9, 8, 7, 6, 5, 4, 3, 2, 1,
		 * 0}; solv.plusOne(inArr);
		 */
		long res = 0;
		int deg = 0; // the power of the numbers
		for (int i = digits.length - 1; i >= 0; i--) {
			res += (int) (digits[i] * (Math.pow(10, deg)));
			deg++;
		}
		res++;
		String outString = String.valueOf(res);
		int[] outArr = new int[String.valueOf(res).length()];
		for (int i = 0; i < outString.length(); i++) {
			System.out.print(Integer.parseInt(String.valueOf(outString.charAt(i))));
			outArr[i] = Integer.parseInt(String.valueOf(outString.charAt(i)));
		}
		/*
		 * int i=outArr.length-1; while (i >= 0) { res = res / 10; outArr[i] = res % 10;
		 * i--; }
		 */

		return outArr;
	}

	public int singleNumber(int[] nums) {
		/*
		 * int[] vals = {1, 1, 2, 2, 3};
		 */
		HashSet<Integer> numsSet = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (numsSet.contains(nums[i])) {
				numsSet.remove(nums[i]);
			} else {
				numsSet.add(nums[i]);
			}
		}
		return numsSet.iterator().next();
	}

	public int missingNumber(int[] nums) {
		/*
		 * int[] vals = {9,6,4,2,3,5,7,0,1};
		 * System.out.println(solv.missingNumber(vals));
		 */
		Arrays.sort(nums);
		// judge if n appears in at the end
		if (nums[nums.length - 1] != nums.length) {
			return nums.length;
		} else if (nums[0] != 0) { // judge if n appears in at the beginning
			return 0;
		}
		// judge if the missing number appears between (0, n)
		for (int i = 1; i < nums.length; i++) {
			int expectedNum = nums[i - 1] + 1;
			if (nums[i] != expectedNum) {
				return expectedNum;
			}
		}
		return -1;
	}

	public String reverseLeftWords(String s, int n) {
		/*
		 * System.out.println(solv.reverseLeftWords("lrloseumgh", 6));
		 */
		return s.substring(n, s.length()) + s.substring(0, n);
	}

	public boolean checkIfPangram(String sentence) {
		/*
		 * �?查字串是否包含所有字�? String str="leetcode";
		 * System.out.println(solv.checkIfPangram(str));
		 */
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < sentence.length(); i++) {
			set.add(sentence.charAt(i));
		}
		return set.size() == 26;
	}

	public int findRepeatNumber(int[] nums) {
		/*
		 * not sure if it's correct int[] nums = {2, 3, 1, 0, 2, 5, 3};
		 * System.out.println(solv.findRepeatNumber(nums));
		 */
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashSet.contains(nums[i])) {
				return nums[i];
			} else {
				hashSet.add(nums[i]);
			}
		}
		return hashSet.iterator().next();
	}

	public int[] singleNumbers(int[] nums) {
		// this hashSet has only singleNumbers
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashSet.contains(nums[i])) {
				hashSet.remove(nums[i]);
			} else {
				hashSet.add(nums[i]);
			}
		}
		int i = 0;
		int[] out = { 0, 0 };
		for (Iterator iterator = hashSet.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			out[i] = integer.intValue();
			i++;
		}
		return out;
	}

	public boolean checkPossibility(int[] nums) {
		/*
		 * leetcode 665. 非�?�减数列 int [] nums = {4,2,1}; �?查数列是否是非�?�减数列
		 * 给你�?个长度为 n 的整数数组，请你判断�? �?�? 改变 1 个元素的情况下，该数组能否变成一个非递减数列�?

我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，�?�满�? nums[i] <= nums[i + 1]�?

来源：力扣（LeetCode�?
链接：https://leetcode-cn.com/problems/non-decreasing-array
著作权归领扣网络�?有�?�商业转载请联系官方授权，非商业转载请注明出处�??
		 */
		for (int i = 0; i < nums.length - 1; i++) {
			int x = nums[i], y = nums[i + 1];
			if (x > y) {
				nums[i] = y;
				if (isNonIncreasing(nums)) {
					return true;
				}
				nums[i] = x;
				nums[i + 1] = x;
				return isNonIncreasing(nums);
			}
		}
		return true;
	}

	public boolean isNonIncreasing(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public boolean isLongPressedName(String name, String typed) {
		/*
		 * leetcode 925. 长按键入 �?查一组数中是否有长按后输入的数，即连续重复的�? name 是给定的目标字串，typed是输入的字串
		 */
		int i = 0, j = 0;
		while (j < typed.length()) { // until j reaches the last elem
			if (i < name.length() && name.charAt(i) == typed.charAt(j)) {// ith and jth num are the same
				i++;
				j++;
			} else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
				j++;
			} else {
				return false;
			}
		}
		return i == name.length();
	}

	public int trap(int[] height) {
		/*
		 * 能承接的�?多的雨水�? 考察的知识点：�?�栈�? int[] walls = {0,1,0,2,1,0,1,3,2,1,2,1};
		 * System.out.println(solv.trap(walls));
		 */
		int sum = 0; // 共能承接的雨�?
		/* 接雨�? leetcode 42 */
		// �?两端的列不用考虑，因为一定不会有水�?�所以下标从 1 �? length - 2
		for (int i = 1; i < height.length - 1; i++) {
			int max_left = 0; // 对于正在求的列，左边�?高的�?
			// 找出左边�?�?
			for (int j = i - 1; j >= 0; j--) {
				if (height[j] > max_left) {
					max_left = height[j];
				}
			}
			int max_right = 0;
			// 找出右边�?�?
			for (int k = i + 1; k <= height.length - 1; k++) {
				if (height[k] > max_right) {
					max_right = height[k];
				}
			}
			// 找出两端较小�?
			int lowerWall = Math.min(max_left, max_right);
			// 只有较小的一段大于当前列的高度才会有水，其他情况不会有水
			if (lowerWall > height[i]) {
				sum = sum + (lowerWall - height[i]);
			}
		}
		return sum;
	}

	public String reverseParentheses(String s) {
		/*给出�?个字符串 s（仅含有小写英文字母和括号）�?

请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果�?

注意，您的结果中 不应 包含任何括号�?

来源：力扣（LeetCode�?
链接：https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses
著作权归领扣网络�?有�?�商业转载请联系官方授权，非商业转载请注明出处�??
		 * String str = "(u(love)i)"; 见到括号就将其中内容反过�?
		 */
		Deque<String> stack = new LinkedList<String>(); // store parentheses
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '(') {
				stack.push(sBuffer.toString());
				sBuffer.setLength(0);
			} else if (ch == ')') {
				sBuffer.reverse();
				sBuffer.insert(0, stack.pop());
			} else {
				// when the char is not parentheses add char to the string buffer 
				sBuffer.append(ch);
			}
		}
		return sBuffer.toString();
	}

	public int[][] merge(int[][] intervals) {
		/*以数�? intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回�?个不重叠的区间数组，该数组需恰好覆盖输入中的�?有区间�??
来源：力扣（LeetCode�?56. 合并区间
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络�?有�?�商业转载请联系官方授权，非商业转载请注明出处�??
*/
//		int[][] intLs =  {{1,3},{2,6},{8,10},{15,18}};
		List<int[]> intls = Arrays.asList(intervals);
		List<int[]> newIntls = new ArrayList<>(intls);
		newIntls.sort((o1, o2) -> o1[0] - o2[0]);

		List<int[]> res = new ArrayList<>();
		for (int i = 0; i < newIntls.size();) {
			int rborder = newIntls.get(i)[1]; // current interval
			int j = i + 1; // next interval
			// merge left and right borders of two intervals, which means the jth interval's
			// left border is larger than the right border of the ith interval.
			while (newIntls.size() > j && newIntls.get(j)[0] < rborder) {
				rborder = Math.max(newIntls.get(j)[1], rborder); // merge
				j++;
			}
			res.add(new int[] { newIntls.get(i)[0], rborder }); // update the right border and add the new interval to
																// the list
			i = j;
		}
		// convert array to pure array
		int[][] ans = new int[res.size()][2];
		for (int i = 0; i < res.size(); i++) {
			ans[i][0] = res.get(i)[0];
			ans[i][1] = res.get(i)[1];
		}
		return intervals;
	}

	public String largestNumber(int[] nums) {
		/*给定�?组非负整�? nums，重新排列每个数的顺序（每个数不可拆分）使之组成�?个最大的整数�?

注意：输出结果可能非常大，所以你�?要返回一个字符串而不是整数�??
示例 1�?

输入：nums = [10,2]
输出�?"210"
示例 2�?

输入：nums = [3,30,34,5,9]
输出�?"9534330"*/

		// largest num in all combinations
		int n = nums.length;
		Integer[] numsArrIntegers = new Integer[n];
		for (int i = 0; i < n; i++) {
			numsArrIntegers[i] = nums[i];
		}
		Arrays.sort(numsArrIntegers, (x, y) -> {
			long sx = 10, sy = 10;
			while (x >= sx) {
				sx *= 10;
			}
			while (y >= sy) {
				sy *= 10;
			}
			return (int) (-sy * x - y + sx * y + x);
		});
		if (numsArrIntegers[0] == 0) { // min element of the sorted array is zero, then the returned value will be at
										// the maximum 0
			return "0";
		}
		StringBuilder retBuilder = new StringBuilder();
		for (Integer integer : numsArrIntegers) {
			retBuilder.append(integer);
		}
		return retBuilder.toString();
	}

//    public int[] smallestK(int[] arr, int k) {
//    	int[] vec = new int[k];
//    	Arrays.sort(arr);
//    	for (int i = 0; i< k;i++) {
//    		vec[i] = arr[i];
//    	}
//    	return vec;
//    }

	public int[] smallestK(int[] arr, int k) {
		/* leetcode �?小K个数
		 * 设计�?个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可
		 * int[] arr = {1,3,5,7,2,4,6,8}; int k = 4; for (int i : solv.smallestK(arr,
		 * k)) { System.out.println(i); }
		 */
		int[] vec = new int[k];
		if (k == 0) {
			return vec;
		}
		// 维护�?个最大堆
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer num1, Integer num2) {
				return num2 - num1;
			}
		});
		// 里面随意存储k个元�? 按最大堆排序
		for (int i = 0; i < k; i++) {
			queue.offer(arr[i]);
		}
		// 如果�?大堆堆顶元素大于本元�? 则将其取�? 将本元素入堆
		for (int i = k; i < arr.length; i++) {
			if (queue.peek() > arr[i]) {
				queue.poll();
				queue.offer(arr[i]);
			}
		}
		for (int i = 0; i < k; i++) {
			vec[i] = queue.poll();
		}
		return vec;
	}

	public String minNumber(int[] nums) {
		// sort using priority queue
		/*剑指 Offer 45. 把数组排成最小的�? 
		 * 输入�?个非负整数数组，把数组里�?有数字拼接起来排成一个数，打印能拼接出的�?有数字中�?小的�?个�??*/
		Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 字典序列小的放在堆顶
				return (o1 + o2).compareTo(o2 + o1);
			}
		});
		for (int num : nums) {
			queue.add("" + num);
		}
		StringBuilder retBuilder = new StringBuilder();
		while (!queue.isEmpty()) {
			retBuilder.append(queue.poll());
		}
		return retBuilder.toString();
	}

	
	void dfs(char[][] grid, int r, int c) {
		// 判断base case
		// 如果坐标 (r, c) 超出了网格范围，直接返回
		int nr = grid.length;
		int nc = grid[0].length;
		if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
			return;
		}
		grid[r][c] = '0';
		dfs(grid, r - 1, c);
		dfs(grid, r + 1, c);
		dfs(grid, r, c - 1);
		dfs(grid, r, c + 1);
	}

	public int numIslands(char[][] grid) {
		// 200 岛屿问题 岛屿数量
		/*给你�?个由 '1'（陆地）�? '0'（水）组成的的二维网格，请你计算网格中岛屿的数量�?

岛屿总是被水包围，并且每座岛屿只能由水平方向�?/或竖直方向上相邻的陆地连接形成�??

此外，你可以假设该网格的四条边均被水包围�?

*/
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int nr = grid.length;
		int nc = grid[0].length;
		int num_islands = 0;
		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				if (grid[r][c] == '1') {
					++num_islands;
					dfs(grid, r, c);
				}
			}
		}
		return num_islands;
	}

	public int lengthOfLongestSubstring(String s) {
		/*给定�?个字符串 s ，请你找出其中不含有重复字符�? �?长子�? 的长度�??*/
		// longest substring with unrepeated chars 
		int n = s.length();
		if (n < 1) {
			return n;
		}
		int maxLen = 1;
		int left = 0, right = 0;
		Set<Character> window = new HashSet<>();
		while (right < n) {
			char rightChar = s.charAt(right);
			while (window.contains(rightChar)) {
				window.remove(s.charAt(left));
				left++;
			}
			maxLen = Math.max(maxLen, right - left + 1);
			window.add(rightChar);
			right++;
		}
		return maxLen;
	}

	public int lengthOfLastWord(String s) {
		/*58. �?后一个单词的长度
		 *给你�?个字符串 s，由若干单词组成，单词前后用�?些空格字符隔�?。返回字符串中最后一个单词的长度�?

单词 是指仅由字母组成、不包含任何空格字符的最大子字符串�?? */
		int end = s.length() -1; //�?后一个单词的末尾位置
		while (end > 0 && s.charAt(end) == ' ' ) end--; //末尾出现很多空格
		if (end < 0) return 0;
		int start = end; // �?后一个单词的起始位置
		while (start >= 0 && s.charAt(start)!= ' ') { // �?后一个单词的起始位置
			start--;
		}
		return end - start;
	}
	
	public String longestPalindrome(String s) {
		/*5. �?长回文子�?
		 * 给你�?个字符串 s，找�? s 中最长的回文子串�?*/
		int len = s.length();
		if (len < 2) {
			return s;
		}
		int maxLen = 1;
		int begin = 0;
		// dp[i][j] 表示 s[i..j] 是否是回文串
		boolean[][] dp = new boolean[len][len];
		// 初始化：�?有长度为 1 的子串都是回文串
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}
		char[] charArray = s.toCharArray();
        // 递推�?�?
        // 先枚举子串长�?
		for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松�?�?
			for (int i = 0; i < len; i++) {
				// �? L �? i 可以确定右边界，�? j - i + 1 = L �?
				int j = L + i -1;
				//如果右边界越界，就可以�??出当前循�?
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位�?
                if (dp[i][j] && j - i + 1 > maxLen) {//比之前找到的�?长回文长
                    maxLen = j - i + 1;
                    begin = i;
                }
			}
		}
		return s.substring(begin, begin + maxLen);
	}
}
