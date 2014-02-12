package hackenbergerhollander;

/**
 * Substitution Cipher
 * 
 * @author Rene Hollander
 */
public class SubstitutionCipher extends MonoalphabeticCipher {

	private String secretAlphabet;

	/**
	 * Creates a new Substitution Cipher
	 * 
	 * @param secretAlphabet
	 *            Secret Alphabet
	 */
	public SubstitutionCipher(String secretAlphabet) {
		super();
	}

	/**
	 * Sets the secret alphabet
	 * 
	 * @param secretAlphabet
	 *            Secret Alphabet
	 */
	public void setSecretAlphabet(String secretAlphabet) {
		this.secretAlphabet = secretAlphabet;
	}

}
