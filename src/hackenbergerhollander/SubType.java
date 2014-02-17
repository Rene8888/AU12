package hackenbergerhollander;

/**
 * Represents the 3 different types of the monoalphabetic Cipher
 * 
 * @author Hackenberger Christoph
 */
public enum SubType {

	SUBST("Substitution","Alphabet",20),
	SHIFT("Shifter","Shift",2),
	KEY("Keyword","Keyword",8);
	
	private final String title;
	private final String txt;
	private	final int col;
	
	private SubType(String title, String txt, int col) {
		this.title = title;
		this.txt = txt;
		this.col = col;
	}
	
	@Override
	public String toString() {
		return this.title;
	}
	
	public String getTxt() {
		return this.txt;
	}
	
	public int getCol() {
		return this.col;
	}
}
