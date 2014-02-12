package hackenbergerhollander;

/**
 * Main Class
 * 
 * @author Rene Hollander
 */
public class Main {

	/**
	 * Main class for the Cipher Suite
	 * 
	 * @param args
	 *            Command Line arguments
	 */
	public static void main(String[] args) {

		ShiftCipher cipher = new ShiftCipher(-5);

		String decoded = cipher.encrypt("Hallo Welt!");

		System.out.println(decoded);

		System.out.println(cipher.decrypt(decoded));

		new Control();
	}

}
