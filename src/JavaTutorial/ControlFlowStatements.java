package JavaTutorial;

public class ControlFlowStatements {
	public void printStr(int num) {
		if (num >= 0) {
			if (num == 0) {
				System.out.println("first str");
			}
		} else {
			System.out.println("second str");
		}
		System.out.println("third str");
	}
}
