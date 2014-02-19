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

	/**
	 * Creates a new Control
	 */
	public Control() {
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
		return type.getCipher().encrypt(txt);
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
		return type.getCipher().decrypt(txt);
	}

	/**
	 * Set new parameters for the for the provided encrypt/decrypt type
	 * 
	 * @param type
	 *            type for which the parameter should be changed
	 * @param param
	 *            new parameter
	 * @throws Exception
	 */
	public void setParam(SubType type, String param) throws Exception {
		type.getCipher().setParameter(param);
	}
}
