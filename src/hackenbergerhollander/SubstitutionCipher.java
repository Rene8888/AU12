package hackenbergerhollander;

/**
 * Substitution Cipher
 * 
 * @author Rene Hollander
 */
public class SubstitutionCipher extends MonoalphabeticCipher {

	/**
	 * Creates a new Substitution Cipher
	 * 
	 * @param secretAlphabet
	 *            Secret Alphabet
	 */
	public SubstitutionCipher(String secretAlphabet) {
		this(secretAlphabet.toCharArray());
	}

	/**
	 * Creates a new Substitution Cipher
	 * 
	 * @param secretAlphabet
	 *            Secret Alphabet
	 */
	public SubstitutionCipher(char[] secretAlphabet) {
		super();
		this.setSecretAlphabet(secretAlphabet);
	}

	/**
	 * Sets the secret alphabet
	 * 
	 * @param secretAlphabet
	 *            Secret Alphabet
	 */
	public void setSecretAlphabet(char[] secretAlphabet) {
		super.setSecretAlphabet(secretAlphabet);
	}

	/**
	 * Sets the secret alphabet
	 * 
	 * @param secretAlphabet
	 *            Secret Alphabet
	 */
	public void setSecretAlphabet(String secretAlphabet) {
		this.setSecretAlphabet(secretAlphabet.toCharArray());
	}

}
