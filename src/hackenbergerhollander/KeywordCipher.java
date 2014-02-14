package hackenbergerhollander;

/**
 * Keyword Cipher
 * 
 * @author Rene Hollander
 */
public class KeywordCipher extends MonoalphabeticCipher {

	private String keyWord;

	private char[] secretAlphabet;

	/**
	 * Creates a new Keyword Cipher
	 * 
	 * @param keyWord
	 *            Keyword
	 */
	public KeywordCipher(String keyWord) {
		super();
		this.setKeyword(keyWord);
	}

	public char[] getSecretAlphabet() {
		return this.secretAlphabet;
	}

	/**
	 * Sets the Keyword
	 * 
	 * @param keyWord
	 *            Keyword
	 */
	public void setKeyword(String keyWord) {
		this.keyWord = keyWord;
		this.secretAlphabet = this.generateAlphabet(this.keyWord);
		super.setSecretAlphabet(this.secretAlphabet);
	}

	/**
	 * Creates a new alphabet from the keyword
	 * 
	 * @param keyword
	 *            Keyword to create the alphabet
	 * @return Returns a alphabet
	 */
	public char[] generateAlphabet(String keyword) {
		return null;
	}
}