package hackenbergerhollander;

/**
 * Main Class
 * 
 * @author Rene Hollander
 */
public class StartCipher {

	/**
	 * Main class for the Cipher Suite
	 * 
	 * @param args
	 *            Command Line arguments
	 */
	public static void main(String[] args) {

		KeywordCipher kc = new KeywordCipher("Geheimes Passwort!");

		System.out.println(new String(kc.getSecretAlphabet()));

	}

}
