package hackenbergerhollander;

/**
 * Shift Cipher
 * 
 * @author Rene Hollander
 */
public class ShiftCipher extends MonoalphabeticCipher {

	private int shiftValue;

	private char[] secretAlphabet;

	/**
	 * Creates a new Shift Cipher
	 * 
	 * @param shiftValue
	 *            ShiftAmount
	 */
	public ShiftCipher(int shiftValue) {
		super();
		this.setShiftAmount(shiftValue);
	}

	public char[] getSecretAlphabet() {
		return this.secretAlphabet;
	}

	/**
	 * Sets the ShiftValue 0 > shiftvalue < infinity
	 * 
	 * @param shiftValue
	 *            Shift value
	 */
	public void setShiftAmount(int shiftValue) {
		this.shiftValue = Util.minimizeInt(shiftValue, 26);
		this.secretAlphabet = this.generateAlphabet(shiftValue);
	}

	/**
	 * Creates a alphabet with the specified shift value
	 * 
	 * @param shiftValue
	 *            Shift value
	 * @return secret alphabet
	 */
	public char[] generateAlphabet(int shiftValue) {
		char[] chars = Util.getAlphabet();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= 'a' && chars[i] <= 'z') {
				chars[i] = (char) (Util.minimizeInt(chars[i] - 'a' + this.shiftValue, 26) + 'a');
			}
		}
		return chars;
	}

}
