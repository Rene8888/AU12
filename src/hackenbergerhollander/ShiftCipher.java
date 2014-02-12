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
		this.shiftValue = minimizeInt(shiftValue, 26);
		if (this.shiftValue < 1)
			throw new IllegalArgumentException("shiftValue has to be greater then 0");
	}

	public String encrypt(String s) {
		char[] chars = s.toLowerCase().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= 'a' && chars[i] <= 'z') {
				chars[i] = (char) (minimizeInt(chars[i] - 'a' + this.shiftValue, 26) + 'a');
			}
		}
		return new String(chars);
	}

	public String decrypt(String s) {
		char[] chars = s.toLowerCase().toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= 'a' && chars[i] <= 'z') {
				chars[i] = (char) (minimizeInt(chars[i] - 'a' + (26 - this.shiftValue), 26) + 'a');
			}
		}
		return new String(chars);
	}

	private int minimizeInt(int input, int max) {
		while (input >= max) {
			input = input % max;
		}
		return input;
	}

}
