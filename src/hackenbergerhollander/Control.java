package hackenbergerhollander;

/**
 * Control part of the MVC for the GUI
 * 
 * @author Hackenberger Christoph
 * 
 */
@SuppressWarnings("javadoc")
public class Control {

	public View view;
	public ShiftCipher shifter;
	public SubstitutionCipher subst;
	public KeywordCipher key;

	/**
	 * Creates a new Control
	 */
	public Control() {
		shifter = new ShiftCipher(0);
		subst = new SubstitutionCipher(Util.getAlphabet());
		key = new KeywordCipher("");
		view = new View(this);
	}

	/**
	 * Encrypts the provided text with the method of the provided type
	 * 
	 * @param txt
	 *            text which should be encrypted
	 * @param type
	 *            type for the encrypt-method
	 * @return the encrypted text
	 */
	public String encrypt(String txt, SubType type) {
		switch (type) {
		case SUBST:
			return subst.encrypt(txt);

		case KEY:
			return key.encrypt(txt);

		case SHIFT:
			return shifter.encrypt(txt);

		default:
			return null;
		}
	}

	/**
	 * Decrypts the provided text with the method of the provided type
	 * 
	 * @param txt
	 *            text which should be decrypted
	 * @param type
	 *            type for the decrypt-method
	 * @return the decrypted text
	 */
	public String decrypt(String txt, SubType type) {
		switch (type) {
		case SUBST:
			return subst.decrypt(txt);

		case KEY:
			return key.decrypt(txt);

		case SHIFT:
			return shifter.decrypt(txt);

		default:
			return null;
		}
	}

	/**
	 * Set new parameters for the for the provided encrypt/decrypt type
	 * 
	 * @param type
	 *            type for which the parameter should be changed
	 * @param param
	 *            new parameter
	 * @throws IllegalArgumentException
	 *             when type is SubType.SHIFT and the param does not represents
	 *             a number
	 */
	public void setParam(SubType type, String param) throws IllegalArgumentException {
		switch (type) {
		case SUBST:
			subst.setSecretAlphabet(param);
			break;

		case KEY:
			key.setKeyword(param);
			break;

		case SHIFT:
			try {
				int shift = Math.abs(Integer.parseInt(param));
				shifter.setShiftAmount(shift);
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("When type is Shifter the Parameter has to be a number");
			}
		}
	}
}
