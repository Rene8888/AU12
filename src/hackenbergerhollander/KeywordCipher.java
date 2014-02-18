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
	public KeywordCipher(String keyWord) throws IllegalArgumentException{
		super();
		this.setKeyword(keyWord);
	}

	/**
	 * Sets the Keyword
	 * 
	 * @param keyWord
	 *            Keyword
	 */
	public void setKeyword(String keyWord) throws IllegalArgumentException {
		if(!Util.areInAlphabet(keyWord.toCharArray()))
			throw new IllegalArgumentException("The keyword has to contain only chars from a to z and äöüß");
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