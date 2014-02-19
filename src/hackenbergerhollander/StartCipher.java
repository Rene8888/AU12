package hackenbergerhollander;

import javax.swing.UIManager;

/**
 * Main Class
 * 
 * @author Rene Hollander
 */
public class StartCipher {

	/**
	 * Main class for the Cipher Suite
	 * 
	 * @param args
	 *            Command Line arguments
	 */
	public static void main(String[] args) {
		try {
			// makes the gui look better on windows systems
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Control();
	}

}
