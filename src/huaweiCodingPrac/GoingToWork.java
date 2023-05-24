package huaweiCodingPrac;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GoingToWork {
	static int[][] matrix;
	static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int maxTurns;
	static int maxCleans;

	public static void main(String[] args) {
		/*
		 * </a>题目描述</h2> <blockquote> <p>Jungle 生活在美丽的蓝鲸城，大马路都是方方正正，但是每天马路的封闭情况都不一样。<br>
		 * 地图由以下元素组成: （1) ”.” - 空地，可以达到;（2)”*” - 路障，不可达到;（
		 * 3)"S” - Jungle的家; （4)”T” - 公司.<br> 其中我们会限制Jungle拐弯的次数，同时Jungle可以清除给定个数的路障，现在你的任务是计算Jungle是否可以从家里出发到达公司。<br> <strong>输入描述</strong><br> 输入的第一行为两个整数tc(o&lt;tc&lt;100)t代表可以拐弯的次数，c代表可以清除的路障个数<br> 输入的第二行为两个整数n,m(1≤n,m≤100),代表地图的大小。<br> 接下来是n行包含m个字符的地图。n和m可能不一样大。 我们保证地图里有S和T。<br> <strong>输出描述</strong><br> 输出是否可以从家里出发到达公司，是则输出YES，不能则输出NO。<br> <strong>示例1：</strong><br> <strong>输入</strong><br> 2 0<br> 5 5<br> <img src="
		 * https://img-blog.csdnimg.cn/65dc286c80694edfbf046f4fec6b0582.png#
		 * pic_center" alt="在这里插入图片描述"><br> <strong>输出</strong><br> YES</p>
		 * </blockquote> <h2><a id="_19"></a>解题思路</h2> <p>首先，遍历地图，找到 Jungle
		 * 的家所在的位置。接着，使用深度优先搜索（DFS）算法从 Jungle 的家开始探索每一个可达的位置。在搜索过程中，需要记录已经使用的拐弯次数</p>
		 * </div>
		 */
		Scanner sc = new Scanner(System.in);
		List<Integer> line1 = Stream.of(sc.nextLine().split(" ")).map(e -> Integer.parseInt(e))
				.collect(Collectors.toList());
		int maxTurns = line1.get(0); // 可以拐弯的次数
		int maxCleans = line1.get(1); // 可以清除的路障个数
		List<Integer> line2 = Stream.of(sc.nextLine().split(" ")).map(e -> Integer.parseInt(e))
				.collect(Collectors.toList());
		int m = line2.get(0);
		int n = line2.get(1);

	}

	public static boolean dfs(Boolean[][] visited, int x, int y, int turnsUsed, int breakUsed) {
		if ("T".equals(matrix[x][y])) {
			return true;
		}
		visited[x][y] = true;
		// loop in all directions
		for (int[] direction : directions) {
			int currentDirection = direction[2];
			int newX = x + direction[0];
			int newY = y + direction[1];
			// create and initialize two flags
			boolean turnFlags = false;
			boolean breakFlags = false;
			// check if the border is reached
			if (newX > 0 && newX < matrix[0].length && newY > 0 && newY < matrix.length && !visited[newX][newY]) {
				if (turnsUsed + 1 > maxTurns) {
					continue;
				}
				turnFlags = true;

			}
			if ("*".equals(matrix[newX][newY])) {
				if (breakUsed + 1 > maxCleans) {
					continue;
				}
				turnFlags = true;
			}
		}
		return false;
	}

}
