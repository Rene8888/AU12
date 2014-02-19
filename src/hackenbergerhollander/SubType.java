package hackenbergerhollander;

/**
 * Represents the 3 different types of the monoalphabetic Cipher
 * 
 * @author Hackenberger Christoph
 */
public enum SubType {

	/**
	 * Shift Cipher
	 */
	SHIFT(new ShiftCipher(0), "Shifter", "Shift", 2),

	/**
	 * Keyword Chipher
	 */
	KEY(new KeywordCipher(null), "Keyword", "Keyword", 8),

	/**
	 * Substitution Cipher
	 */
	SUBST(new SubstitutionCipher(Util.getAlphabet()), "Substitution", "Alphabet", 20),

	/**
	 * Extended Keyword Cipher
	 */
	EXTENDED(new ExtendedKeywordCipher(null), "Extended Keyword", "Keyword", 8);

	private final Cipher cipher;
	private final String title;
	private final String txt;
	private final int col;

	private SubType(Cipher cipher, String title, String txt, int col) {
		this.cipher = cipher;
		this.title = title;
		this.txt = txt;
		this.col = col;
	}

	@Override
	public String toString() {
		return this.title;
	}

	/**
	 * Gets the text
	 * 
	 * @return text
	 */
	public String getTxt() {
		return this.txt;
	}

	/**
	 * Returns the length of the textfield to be showed
	 * 
	 * @return textfeld length
	 */
	public int getCol() {
		return this.col;
	}

	/**
	 * Gets the cipher from the current subtype
	 * 
	 * @return cipher
	 */
	public Cipher getCipher() {
		return this.cipher;
	}

}
