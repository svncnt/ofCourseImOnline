package mouseMover;

import java.awt.AWTException;
import java.awt.Robot;

public class SimpleRunnable implements Runnable {
	int korrektur = 11000;
	int intervall = 5;// Wie viele Minuten bis zur naechsten Bewegung
	double starttime = System.currentTimeMillis();

	public void run() {
		System.out.println("Maus wird alle " + intervall + " Minuten bewegt");
		while (true) {
			try {
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				for (int j = 80; j > 0; j--) {
					Thread.sleep(125); // 0,125 Sec
					System.out.print("+");
				}
				move();
				move();
				move();

				System.out.println("\nmoved");
				double time = System.currentTimeMillis();
				int diffsek = (int) (time - starttime) / 1000;
				int sek = diffsek % 60;
				int min = (diffsek / 60) % 60;
				int hrs = min / 60;
				System.out.println("Dauer: " + hrs + "h " + min + "m " + sek + "s");
				for (int j = intervall; j > 1; j--) {
					System.out.println("Bewegung in " + j + " Minuten");
					Thread.sleep(57800 - korrektur);
					korrektur = 0;
				}
				System.out.println("Bewegung in 1 Minute");
				Thread.sleep(57800);

			} catch (InterruptedException ie) {
				System.out.println("Interrupted");
			}
		}

	}

	private void move() {
		Robot rob;
		int sleep = 100;
		try {
			rob = new Robot();
			rob.mouseMove(700, 700);// ol
			Thread.sleep(sleep);
			rob.mouseMove(800, 700);// or
			Thread.sleep(sleep);
			rob.mouseMove(800, 800);// ur
			Thread.sleep(sleep);
			rob.mouseMove(700, 800);// ul
			Thread.sleep(sleep);
			rob.mouseMove(700, 700);// ol
		} catch (AWTException e) {
			System.out.println("AWT Exception");
		} catch (InterruptedException ie) {
			System.out.println("Interrupted");
		}

	}

}