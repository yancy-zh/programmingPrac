package JavaTutorial;

import org.junit.jupiter.api.Test;

class ListOfNumbersTest {

	@Test
	void test() {
		ListOfNumbers sol = new ListOfNumbers();
		String fileName = "F:\\CODE\\github\\programmingPrac\\data\\inFile.txt";
		sol.readList(fileName);
		sol.writeList();
	}

}
