package mouseMover;

public class App {
	public static void main(String[] args) {
		Runnable r1 = new SimpleRunnable();

		new Thread(r1).start();
	}
}