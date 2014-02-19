package hackenbergerhollander;

/**
 * Shift Cipher
 * 
 * @author Rene Hollander
 */
public class ShiftCipher extends MonoalphabeticCipher {

	private int shiftValue;

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

	/**
	 * Sets the ShiftValue 0 > shiftvalue < infinity
	 * 
	 * @param shiftValue
	 *            Shift value
	 */
	public void setShiftAmount(int shiftValue) {
		this.shiftValue = Util.minimizeInt(shiftValue, Util.getAlphabetLength());
		super.setSecretAlphabet(this.generateAlphabet(shiftValue));
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
		// we loop through every char in the alphabet and adds the shift amount
		// and gets that from that location
		for (int i = 0; i < out.length; i++) {
			out[i] = Util.getCharFromAlphabet(Util.minimizeInt(i + this.shiftValue, Util.getAlphabetLength()));
		}
		return out;
	}

	@Override
	public boolean setParameter(String in) throws IllegalArgumentException {
		try {
			this.setShiftAmount(Math.abs(Integer.parseInt(in)));
			return true;
		} catch (Exception e) {
			throw new IllegalArgumentException("When type is Shifter the Parameter has to be a number");
		}

	}

}
