package hackenbergerhollander;

/**
 * Keyword Cipher
 * 
 * @author Rene Hollander
 */
public class KeywordCipher extends MonoalphabeticCipher {

	private String keyWord;

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

	/**
	 * Sets the Keyword
	 * 
	 * @param keyWord
	 *            Keyword
	 */
	public void setKeyword(String keyWord) {
		this.keyWord = keyWord;
		super.setSecretAlphabet(this.generateAlphabet(this.keyWord));
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