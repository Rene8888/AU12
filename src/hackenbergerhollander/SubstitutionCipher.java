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
	 * @throws IllegalArgumentException
	 *             if the aphabet is invalid
	 */
	public SubstitutionCipher(String secretAlphabet) throws IllegalArgumentException {
		this(secretAlphabet.toCharArray());
	}

	/**
	 * Creates a new Substitution Cipher
	 * 
	 * @param secretAlphabet
	 *            Secret Alphabet
	 * @throws IllegalArgumentException
	 *             if the aphabet is invalid
	 */
	public SubstitutionCipher(char[] secretAlphabet) throws IllegalArgumentException {
		super();
		this.setSecretAlphabet(secretAlphabet);
	}

	/**
	 * Sets the secret alphabet
	 * 
	 * @param secretAlphabet
	 *            Secret Alphabet
	 */
	public void setSecretAlphabet(char[] secretAlphabet) throws IllegalArgumentException {
		if (!Util.checkAlphabet(secretAlphabet)) {
			throw new IllegalArgumentException("The secret alphabet is invalid!");
		}
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
