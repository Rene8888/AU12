package hackenbergerhollander;

import java.awt.Dimension;
import java.util.regex.Pattern;

import javax.swing.JTextField;

@SuppressWarnings("javadoc")
public class RegexTextField extends JTextField {

	private static final long serialVersionUID = 1L;

	public static final Dimension GOOD_SIZE = new Dimension(120, 20);

	private Pattern pattern;

	public RegexTextField(Pattern pattern, String init, int columns) {
		super(new RegexDocument(pattern), init, columns);
		setPreferredSize(GOOD_SIZE);

		this.pattern = pattern;
	}

	public boolean isValid() {
		try {
			String s = getText();
			return pattern.matcher(s).matches();
		} catch (NullPointerException npe) {
			return true;
		}
	}

	public void setPattern(Pattern pattern) {
		((RegexDocument) this.getDocument()).setPattern(pattern);
	}
}
