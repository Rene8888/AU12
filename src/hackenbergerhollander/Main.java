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

		Cipher cipher = new KeywordCipher("1234");

		String decoded = cipher.encrypt("Hallo Welt!");

		System.out.println(decoded);

		System.out.println(cipher.decrypt(decoded));

		new Control();
	}

}
