package hackenbergerhollander;

import java.util.LinkedHashSet;

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
	 * @throws IllegalArgumentException
	 *             if the keyword is invalid
	 */
	public KeywordCipher(String keyWord) throws IllegalArgumentException {
		super();
		this.setKeyword(keyWord);
	}

	/**
	 * Sets the Keyword
	 * 
	 * @param keyWord
	 *            Keyword
	 * @throws IllegalArgumentException
	 *             if the keyword is invalid
	 */
	public void setKeyword(String keyWord) throws IllegalArgumentException {
		if(keyWord == null || keyWord.equals("")) {
			super.setSecretAlphabet(Util.getAlphabet());
			return;
		}
		if (!Util.areInAlphabet(keyWord.toCharArray()))
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
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		for (char c : keyword.toLowerCase().toCharArray()) {
			set.add(c);
		}
		for (char c : Util.getAlphabet()) {
			set.add(c);
		}
		int i = 0;
		char[] chars = new char[set.size()];
		for (char c : set) {
			chars[i] = c;
			i++;
		}
		return chars;
	}

	public boolean setParameter(String in) throws Exception {
		this.setKeyword(in);
		return true;
	}
}
