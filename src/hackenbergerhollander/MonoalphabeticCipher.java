package hackenbergerhollander;

/**
 * A Cipher to implement a Basic
 * 
 * @author Rene Hollander
 * 
 */
public class MonoalphabeticCipher implements Cipher {

	private char[] secretAlphabet;

	/**
	 * Creates a new Monoalphabetic Cipher
	 */
	public MonoalphabeticCipher() {
		// Adds all letters from a to z to the alphabet
		this.secretAlphabet = Util.getAlphabet();
	}

	/**
	 * Method to get the Secret Alphabet
	 * 
	 * @return Secret Alphabet
	 */
	public char[] getSecretAlphabet() {
		return this.secretAlphabet;
	}

	public String encrypt(String in) {
		return in;
	}

	public String decrypt(String in) {
		return in;
	}

}
