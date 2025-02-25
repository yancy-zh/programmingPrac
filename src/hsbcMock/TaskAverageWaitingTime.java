package hsbcMock;

public class TaskAverageWaitingTime {
	public int average_waiting_time(int[] tasks) {
		int n = tasks.length;
		int[] waiting_time = new int[n];
		waiting_time[0] = 0;
		for (int i = 1; i < n; i++) {
			waiting_time[i] = 0;
			for (int j = 0; j < i; j++) {
				waiting_time[i] += tasks[j];
			}
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += waiting_time[i];
		}
		return sum / n;
	}
}
