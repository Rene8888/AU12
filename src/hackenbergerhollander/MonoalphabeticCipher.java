package hackenbergerhollander;

/**
 * A Cipher to implement a Basic
 * 
 * @author Rene Hollander
 * 
 */
public class MonoalphabeticCipher implements Cipher {

	private char[] secretAlphabet;

	private String parameter;

	/**
	 * Creates a new Monoalphabetic Cipher
	 */
	public MonoalphabeticCipher() {
		// Adds all letters from a to z to the alphabet
		this.secretAlphabet = Util.getAlphabet();
	}

	/**
	 * Method to get the Secret Alphabet
	 * 
	 * @return Secret Alphabet
	 */
	public char[] getSecretAlphabet() {
		return this.secretAlphabet;
	}

	/**
	 * Sets the Secret alphabet
	 * 
	 * @param secretAlphabet
	 *            secret alphabet
	 */
	public void setSecretAlphabet(char[] secretAlphabet) {
		this.secretAlphabet = secretAlphabet;
	}

	/**
	 * Gets the current parameter
	 * 
	 * @return the current param
	 */
	public String getParameter() {
		return this.parameter;
	}

	public String encrypt(String in) {
		char[] input = in.toLowerCase().toCharArray();

		// we loop through every char and replace it by the one representing it
		// in the secret alphabet
		for (int i = 0; i < input.length; i++) {
			int pos = Util.getCharPositionInAlphabet(input[i]);
			if (pos != -1) {
				input[i] = this.secretAlphabet[pos];
			}
		}
		return new String(input);
	}

	public String decrypt(String in) {
		char[] input = in.toLowerCase().toCharArray();

		// we loop through every char and replace it with the corresponding char
		// in the standart alphabet
		for (int i = 0; i < input.length; i++) {
			int pos = this.getCharPositionInSecretAlphabet(input[i]);
			if (pos != -1) {
				input[i] = Util.getCharFromAlphabet(pos);
			}
		}
		return new String(input);
	}

	private int getCharPositionInSecretAlphabet(char c) {
		// returns the position of the char in the secret alphabet
		if (this.isInSecretAlphabet(c)) {
			for (int i = 0; i < this.secretAlphabet.length; i++) {
				if (this.secretAlphabet[i] == c) {
					return i;
				}
			}
			return -1;
		} else {
			return -1;
		}
	}

	private boolean isInSecretAlphabet(char in) {
		// checks if the char is in the secret alphabet
		for (char c : this.secretAlphabet) {
			if (in == c) {
				return true;
			}
		}
		return false;
	}

	public boolean setParameter(String in) {
		this.parameter = in;
		return true;
	}
}
