import java.util.Scanner;
/*
* hello nowcoder
8*/
public class LastWordLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split(" ");
            String lastWord = words[words.length - 1];
            System.out.println(lastWord.length());
        }
    }
}
