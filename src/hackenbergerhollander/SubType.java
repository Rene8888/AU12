package hackenbergerhollander;

import java.util.regex.Pattern;

/**
 * Represents the 3 different types of the monoalphabetic Cipher
 * 
 * @author Hackenberger Christoph
 */
public enum SubType {

	/**
	 * Shift Cipher
	 */
	SHIFT(new ShiftCipher(0), "^[0-9]{1,2}$", "Shifter", "Shift", "Shift Amount 0-29", 2),

	/**
	 * Keyword Chipher
	 */
	KEY(new KeywordCipher(null), "^[" + new String(Util.getAlphabet()) + "]{1," + Util.getAlphabetLength() + "}$", "Keyword", "Keyword", "chars from a-z and äöüß (double chars get removed)", 8),

	/**
	 * Substitution Cipher
	 */
	SUBST(new SubstitutionCipher(Util.getAlphabet()), "^[" + new String(Util.getAlphabet()) + "]{1," + Util.getAlphabetLength() + "}$", "Substitution", "Alphabet", "30 chars from a-z and äöüß", 20),

	/**
	 * Extended Keyword Cipher
	 */
	EXTENDED(new ExtendedKeywordCipher(null), ".*", "Extended Keyword", "Keyword", "Any chars are allowed", 8);

	private final Cipher cipher;
	private final Pattern pattern;
	private final String title;
	private final String txt;
	private final String tooltip;
	private final int col;

	private SubType(Cipher cipher, String regex, String title, String txt, String tooltip, int col) {
		this.cipher = cipher;
		this.pattern = Pattern.compile(regex);
		this.title = title;
		this.txt = txt;
		this.tooltip = tooltip;
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

	/**
	 * Gets the regex pattern
	 * 
	 * @return regex pattern
	 */
	public Pattern getPattern() {
		return this.pattern;
	}
	
	/**
	 * Gets the tooltip text
	 * 
	 * @return tooltip text
	 */
	public String getTooltip() {
		return this.tooltip;
	}

}
