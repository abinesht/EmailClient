package Assignment2;

public class EmailStatRecorder implements StateObserver{

	@Override
	public void update(String message) {
		System.out.println(message);
	}

}
