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
	public SubstitutionCipher(String secretAlphabet) throws IllegalArgumentException {
		this(secretAlphabet.toCharArray());
	}

	/**
	 * Creates a new Substitution Cipher
	 * 
	 * @param secretAlphabet
	 *            Secret Alphabet
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
		if(secretAlphabet.length != Util.getAlphabetLength())
			throw new IllegalArgumentException("The secret alphabet has to contains exactly 30 chars");
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
