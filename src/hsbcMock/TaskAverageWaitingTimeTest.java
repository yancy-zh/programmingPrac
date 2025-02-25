package hsbcMock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TaskAverageWaitingTimeTest {

	@Test
	void test() {
		TaskAverageWaitingTime sol = new TaskAverageWaitingTime();
		assertEquals(4, sol.average_waiting_time(new int[] { 5, 2, 1 }));
	}

}
