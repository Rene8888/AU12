package hackenbergerhollander;

/**
 * A Cipher to implement a Basic
 * 
 * @author Rene Hollander
 * 
 */
public class MonoalphabeticCipher implements Cipher {

	private String secretAlphabet;

	/**
	 * Creates a new Monoalphabetic Cipher
	 */
	public MonoalphabeticCipher() {

	}

	/**
	 * Method to get the Secret Alphabet
	 * 
	 * @return Secret Alphabet
	 */
	public String getSecretAlphabet() {
		return this.secretAlphabet;
	}

	public String encrypt(String in) {
		return null;
	}

	public String decrypt(String in) {
		return null;
	}

}
