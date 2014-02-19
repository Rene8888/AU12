package hackenbergerhollander;

/**
 * Interface to manage Ciphers
 * 
 * @author Rene Hollander
 */
public interface Cipher {

	/**
	 * Method to encrypt a String
	 * 
	 * @param in
	 *            String to encrypt
	 * @return Encrypted String
	 */
	public String encrypt(String in);

	/**
	 * Method to decrypt a String
	 * 
	 * @param in
	 *            String to decrypt
	 * @return Decrypted String
	 */
	public String decrypt(String in);

	/**
	 * Method to set the parameter, e.g. shift amount, keyword
	 * 
	 * @param in
	 *            input text
	 * @return true if successfully set the parameter
	 */
	public boolean setParameter(String in);

}
