import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeAreATeam {
    public static void main(String[] args) {
        /*
        【We Are A Team】

总共有 n 个人在机房，每个人有一个标号（1<=标号<=n），他们分成了多个团队，需要你根据收到的 m 条消息判定指定的两个人是否在一个团队中，具体的：

1、消息构成为 a b c，整数 a、b 分别代表两个人的标号，整数 c 代表指令

2、c == 0 代表 a 和 b 在一个团队内

3、c == 1 代表需要判定 a 和 b 的关系，如果 a 和 b 是一个团队，输出一行’we are a team’,如果不是，输出一行’we are not a team’

4、c 为其他值，或当前行 a 或 b 超出 1~n 的范围，输出‘da pian zi’

输入描述

第一行包含两个整数 n，m(1<=n,m<100000),分别表示有 n 个人和 m 条消息
随后的 m 行，每行一条消息，消息格式为：a b c(1<=a,b<=n,0<=c<=1)
输出描述: 1、c ==1,根据 a 和 b 是否在一个团队中输出一行字符串，在一个团队中输出‘we are a team’,不在一个团队中输出’we are not a team’ 2、c 为其他值，或当前行 a 或 b 的标号小于 1 或者大于 n 时，输出字符串‘da pian zi’
如果第一行 n 和 m 的值超出约定的范围时，输出字符串”Null”。
示例1 输入输出示例仅供调试，后台判题数据一般不包含示例

输入

5 7

1 2 0

4 5 0

2 3 0

1 2 1

2 3 1

4 5 1

1 5 1

输出

We are a team

We are a team

We are a team

We are not a team

示例2 输入输出示例仅供调试，后台判题数据一般不包含示例

输入：
5 7
1 2 0
1 2 1
3 4 1
3 4 0
3 4 1
1 3 0
2 4 1
输出：
we are a team
we are not a team
we are a team
we are a team
————————————————
版权声明：本文为CSDN博主「Cloud_Strife_MT」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_33103223/article/details/125192807
         */
        int m; // m msgs
        int n; // n persons
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] intro = scanner.nextLine().split(" ");
            m = Integer.parseInt(intro[0]); // number of persons
            n = Integer.parseInt(intro[1]); // num of msgs
            UnionFind unionFind = new UnionFind(m);
            // maintain an array of sets, and they don't intersect with each other
//            ArrayList<Set<Integer>> listOfSets = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String[] msg = scanner.nextLine().split(" ");
                int a = Integer.parseInt(msg[0]); // first element
                int b = Integer.parseInt(msg[1]); // second element
//                Set<Integer> team = new HashSet<>();
//                team.add(Integer.parseInt(msg[0]));
//                team.add(Integer.parseInt(msg[1]));
                //check if list of sets already has this element
                int c = Integer.parseInt(msg[2]); // flag indicating the equality
                if (c == 0) { // a and b are a team
                    unionFind.union(a, b);
                    System.out.println("We are a team");
                } else if (c == 1) {
                    if (unionFind.find(a) == unionFind.find(b)) {
                        System.out.println("We are a team");
                    } else {
                        System.out.println("We are not a team");
                    }
                } else {
                    System.out.println("Da Pian Zi");
                }
            }
        }
    }
}

