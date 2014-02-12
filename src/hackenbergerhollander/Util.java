package hackenbergerhollander;

/**
 * Small Util class
 * 
 * @author Rene Hollander
 */
public class Util {

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
		char[] alphabet = new char[26];
		for (int i = 'a'; i <= 'z'; i++) {
			alphabet[i - 'a'] = (char) i;
		}
		return alphabet;
	}

}
