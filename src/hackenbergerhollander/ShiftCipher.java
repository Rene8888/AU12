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
		this.shiftValue = Util.minimizeInt(shiftValue, Util.getAlphabetLength());
		this.secretAlphabet = this.generateAlphabet(shiftValue);
		super.setSecretAlphabet(this.secretAlphabet);
	}

	/**
	 * Creates a alphabet with the specified shift value
	 * 
	 * @param shiftValue
	 *            Shift value
	 * @return secret alphabet
	 */
	public char[] generateAlphabet(int shiftValue) {
		char[] out = new char[Util.getAlphabetLength()];
		for (int i = 0; i < out.length; i++) {
			out[i] = Util.getCharFromAlphabet(Util.minimizeInt(i + this.shiftValue, Util.getAlphabetLength()));
		}
		return out;
	}

}
