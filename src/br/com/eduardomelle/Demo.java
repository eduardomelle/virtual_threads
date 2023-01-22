/**
 * 
 */
package br.com.eduardomelle;

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

}
