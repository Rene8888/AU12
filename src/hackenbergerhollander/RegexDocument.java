package hackenbergerhollander;

import java.util.regex.Pattern;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("javadoc")
public class RegexDocument extends PlainDocument {

	private static final long serialVersionUID = 1L;

	private Pattern pattern;

	public RegexDocument(Pattern pattern) {
		super();
		this.pattern = pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	public void insertString(int offset, String s, AttributeSet a) throws BadLocationException {
		if (s == null)
			s = "";
		String oldString = getText(0, getLength());
		String newString = oldString.substring(0, offset) + s + oldString.substring(offset);
		if (pattern.matcher(newString).find()) {
			super.insertString(offset, s, a);
		}

	}
}