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
		this.keyWord = keyWord;
	}

	/**
	 * Sets the Keyword
	 * 
	 * @param keyWord
	 *            Keyword
	 */
	public void setKeyword(String keyWord) {
		this.keyWord = keyWord;
	}

}
