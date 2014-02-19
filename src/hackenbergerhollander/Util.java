package hackenbergerhollander;

/**
 * Small Util class
 * 
 * @author Rene Hollander
 */
public class Util {

	private static final char[] ALPHABET;

	private static final int ALPHABET_LENGTH;

	static {

		// Sets the length of the alphabet
		ALPHABET_LENGTH = 30;

		// Fills the alphabet
		ALPHABET = new char[Util.ALPHABET_LENGTH];
		for (int i = 'a'; i <= 'z'; i++) {
			ALPHABET[i - 'a'] = (char) i;
		}
		// represents ä
		ALPHABET[26] = 228;
		// represents ö
		ALPHABET[27] = 246;
		// represents ü
		ALPHABET[28] = 252;
		// represents ß
		ALPHABET[29] = 223;
	}

	/**
	 * Input gets modulized as long as it is bigger then max
	 * 
	 * @param input
	 *            Input int
	 * @param max
	 *            Highest int
	 * @return modulized int
	 */
	public static int minimizeInt(int input, int max) {
		while (input >= max || input < 0) {
			if (input < 0)
				input = input * -1;
			input = input % max;
		}
		return input;
	}

	/**
	 * Creates a standart alphabet
	 * 
	 * @return Returns alphabet
	 */
	public static char[] getAlphabet() {
		return Util.ALPHABET;
	}

	/**
	 * Checks if the char is in the alphabet
	 * 
	 * @param in
	 *            Char to check
	 * @return true of char is in alphabet
	 */
	public static boolean isInAlphabet(char in) {
		for (char c : Util.getAlphabet()) {
			if (in == c) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Gets the length of the alphabet
	 * 
	 * @return length of the alphabet
	 */
	public static int getAlphabetLength() {
		return ALPHABET_LENGTH;
	}

	/**
	 * Gets the char in the alphabet at the specified index
	 * 
	 * a = 0!
	 * 
	 * @param index
	 *            index of teh char in the alphabet
	 * @return char at the index in the alphabet
	 */
	public static char getCharFromAlphabet(int index) {
		if (index < 0)
			throw new IllegalArgumentException("index has to be greater then 0");
		if (index > (Util.getAlphabetLength()))
			throw new IllegalArgumentException("index cannot be greater then " + Util.getAlphabetLength());
		return Util.getAlphabet()[index];
	}

	/**
	 * Gets the index of a char in an alphabets
	 * 
	 * @param c
	 *            char to search
	 * @return postition in alphabet, -1 if not found
	 */
	public static int getCharPositionInAlphabet(char c) {
		if (Util.isInAlphabet(c)) {
			for (int i = 0; i < Util.getAlphabetLength(); i++) {
				if (Util.getAlphabet()[i] == c) {
					return i;
				}
			}
			return -1;
		} else {
			return -1;
		}
	}

	/**
	 * Checks if the alphabet is valid (only contains chars from a to z and
	 * äöüß, exactly 30 chars)
	 * 
	 * @param alphabet
	 *            alphabet to check
	 * @return true if the alphabet is valid
	 */
	public static boolean checkAlphabet(char[] alphabet) {
		if (alphabet.length == Util.ALPHABET_LENGTH) {
			for (char c1 : alphabet) {
				int currcount = 0;
				for (char c2 : alphabet) {
					if (c1 == c2) {
						currcount++;
					}
				}
				if (currcount != 1) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if all chars are in the alphabet
	 * 
	 * @param chars
	 *            chars to check
	 * @return true if the alphabet is only containing chars from the standart
	 *         alphabet
	 */
	public static boolean areInAlphabet(char[] chars) {
		for (char c : chars) {
			if (!Util.isInAlphabet(Character.toLowerCase(c))) {
				return false;
			}
		}
		return true;
	}

}
