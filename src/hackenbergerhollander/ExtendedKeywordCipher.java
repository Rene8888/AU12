package hackenbergerhollander;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Keyword Cipher
 * 
 * @author Rene Hollander
 */
public class ExtendedKeywordCipher extends MonoalphabeticCipher {

	private String keyWord;

	private MessageDigest sha512;

	/**
	 * Creates a new Keyword Cipher
	 * 
	 * @param keyWord
	 *            Keyword
	 */
	public ExtendedKeywordCipher(String keyWord) {
		super();
		try {
			// Creates a new sha512 hasher
			this.sha512 = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		this.setKeyword(keyWord);
	}

	/**
	 * Sets the Keyword
	 * 
	 * @param keyWord
	 *            Keyword
	 */
	public void setKeyword(String keyWord) {
		this.keyWord = keyWord;
		super.setSecretAlphabet(this.generateAlphabet(this.keyWord));
	}

	/**
	 * Creates a new alphabet from the keyword
	 * 
	 * @param keyword
	 *            Keyword to create the alphabet
	 * @return Returns a alphabet
	 */
	public char[] generateAlphabet(String keyword) {
		// gives back the standart alphabet if no keyword is supplied
		if (keyword == null || keyword.equals(""))
			return Util.getAlphabet();
		try {
			// Hashes the keyword
			byte[] mdbytes = this.sha512.digest(keyWord.getBytes("UTF-8"));

			ArrayList<Character> al = new ArrayList<Character>();

			// goes through all bytes from the hash and tries to combine them as
			// long as a full alphabet is generated
			for (byte b1 : mdbytes) {
				if (al.size() >= Util.getAlphabetLength())
					break;
				for (byte b2 : mdbytes) {
					if (al.size() >= Util.getAlphabetLength())
						break;
					for (byte b3 : mdbytes) {
						if (al.size() >= Util.getAlphabetLength())
							break;
						for (byte b4 : mdbytes) {
							if (al.size() >= Util.getAlphabetLength())
								break;
							for (byte b5 : mdbytes) {
								if (al.size() >= Util.getAlphabetLength())
									break;
								// sums all the bytes and minimizes to get the
								// char in the alphabet
								int i = b1 + b2 + b3 + b4 + b5;
								char c = Util.getCharFromAlphabet(Util.minimizeInt(i, Util.getAlphabetLength()));
								if (al.contains(c)) {
									continue;
								} else {
									al.add(c);
								}
							}
						}
					}
				}
			}

			// fills the arraylist into a char array to return it
			char[] chars = new char[al.size()];
			for (int i = 0; i < chars.length; i++) {
				chars[i] = al.get(i);
			}

			return chars;

		} catch (Exception e) {
			e.printStackTrace();
			return Util.getAlphabet();
		}
	}

	@Override
	public boolean setParameter(String in) {
		this.setKeyword(in);
		return true;
	}
}
