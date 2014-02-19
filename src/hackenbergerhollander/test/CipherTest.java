package hackenbergerhollander.test;

import static org.junit.Assert.*;
import hackenbergerhollander.KeywordCipher;
import hackenbergerhollander.MonoalphabeticCipher;
import hackenbergerhollander.ShiftCipher;
import hackenbergerhollander.SubstitutionCipher;
import hackenbergerhollander.Util;

import org.junit.Test;

/**
 * Test class for all ciphers
 * 
 * @author Hackenberger Christoph
 */
@SuppressWarnings("javadoc")
public class CipherTest {

	@Test
	public void testMonoAlphabeticConstructor() {
		assertEquals(Util.getAlphabet(), new MonoalphabeticCipher().getSecretAlphabet());
	}

	@Test
	public void testSetSecretAlphabetMonoalphabeticCipher() {
		MonoalphabeticCipher c = new MonoalphabeticCipher();
		c.setSecretAlphabet("ßüöäzyxwvutsrqponmlkjihgfedcba".toCharArray());
		assertArrayEquals("ßüöäzyxwvutsrqponmlkjihgfedcba".toCharArray(), c.getSecretAlphabet());
	}

	@Test
	public void testEncryptMonoalphabeticCipher1() {
		MonoalphabeticCipher c = new MonoalphabeticCipher();
		assertEquals("hallo welt!", c.encrypt("Hallo Welt!"));
	}

	@Test
	public void testEncryptMonoalphabeticCipher2() {
		MonoalphabeticCipher c = new MonoalphabeticCipher();
		c.setSecretAlphabet("ßüöäzyxwvutsrqponmlkjihgfedcba".toCharArray());
		assertEquals("wßssp hzsk!", c.encrypt("Hallo Welt!"));
	}

	@Test
	public void testDecryptMonoalphabeticCipher1() {
		MonoalphabeticCipher c = new MonoalphabeticCipher();
		assertEquals("hallo welt!", c.decrypt("Hallo Welt!"));
	}

	@Test
	public void testDecryptMonoalphabeticCipher2() {
		MonoalphabeticCipher c = new MonoalphabeticCipher();
		c.setSecretAlphabet("ßüöäzyxwvutsrqponmlkjihgfedcba".toCharArray());
		assertEquals("hallo welt!", c.decrypt("wßssp hzsk!"));
	}

	@Test
	public void testSubstitutionCipherConstructor1() {
		assertArrayEquals(Util.getAlphabet(), new SubstitutionCipher(Util.getAlphabet()).getSecretAlphabet());
	}

	@Test
	public void testSubstitutionCipherConstructor2() {
		assertArrayEquals("abcdefghijklmnopqrstuvwxyzäöüß".toCharArray(), new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß").getSecretAlphabet());
	}

	@Test
	public void testSetSecretAlphabetSubstitutionCipher1() {
		SubstitutionCipher c = new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöüß");
		c.setSecretAlphabet("ßüöäzyxwvutsrqponmlkjihgfedcba");
		assertArrayEquals("ßüöäzyxwvutsrqponmlkjihgfedcba".toCharArray(), c.getSecretAlphabet());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetSecretAlphabetSubstitutionCipher2() {
		new SubstitutionCipher("abcdefghijklmnopqrstuvwxyzäöü");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetSecretAlphabetSubstitutionCipher3() {
		new SubstitutionCipher("abc");
	}

	@Test
	public void testShiftCipherConstructor1() {
		assertArrayEquals(Util.getAlphabet(), new ShiftCipher(0).getSecretAlphabet());
	}

	@Test
	public void testShiftCipherConstructor2() {
		assertArrayEquals("ghijklmnopqrstuvwxyzäöüßabcdef".toCharArray(), new ShiftCipher(6).getSecretAlphabet());
	}

	@Test
	public void testKeywordCipherConstructor1() {
		assertArrayEquals("REGNSCHIMABDFJKLOPQTUVWXYZÄÖÜß".toLowerCase().toCharArray(), new KeywordCipher("Regenschirm").getSecretAlphabet());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testKeywordCipherConstructor2() {
		new KeywordCipher("Regenschirm!");
	}
}
