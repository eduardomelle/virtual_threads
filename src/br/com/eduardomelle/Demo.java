/**
 * 
 */
package br.com.eduardomelle;

import java.util.concurrent.Executors;

/**
 * @author eduardo
 *
 */
public class Demo {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		new Demo().run();
	}

	void run() throws Exception {
		var thread = Thread.startVirtualThread(() -> {
			System.out.println("HELLO, THREAD!");
		});
		thread.join();
	}

	void runExecutor() throws Exception {
		for (;;) {
			long start = System.currentTimeMillis();

			try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
				for (int i = 0; i < 100_000; i++) {
					executor.submit(() -> {
						Thread.sleep(2000);
						return null;
					});
				}
			}

			long end = System.currentTimeMillis();

			System.out.println(start - end + " ms");
		}
	}

}
