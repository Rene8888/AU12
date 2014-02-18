package hackenbergerhollander.test;

import static org.junit.Assert.assertEquals;
import hackenbergerhollander.Control;
import hackenbergerhollander.SubType;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for all gui tests
 * 
 * @author Rene Hollander
 */
@SuppressWarnings("javadoc")
public class GuiTest {

	private Control c;
	
	@Before
	public void setup() {
		c = new Control();
	}
	
	@Test
	public void testShiftEncrypt() throws InterruptedException {
		c.view.subType.setSelectedItem(SubType.SHIFT);
		c.view.sub.setText("2");
		c.view.message.setText("Hallo Welt!");
		c.view.encrypt.doClick();
		assertEquals("jcnnq ygnv!", c.view.message.getText());

	}
	
	@Test
	public void testShiftDecrypt() throws InterruptedException {
		c.view.subType.setSelectedItem(SubType.SHIFT);
		c.view.sub.setText("2");
		c.view.message.setText("jcnnq ygnv!");
		c.view.decrypt.doClick();
		assertEquals("hallo welt!", c.view.message.getText());
	}

	@Test
	public void testKeywordEncrypt() throws InterruptedException {
		c.view.subType.setSelectedItem(SubType.KEY);
		c.view.sub.setText("kryptos");
		c.view.message.setText("Hallo Welt!");
		c.view.encrypt.doClick();
		assertEquals("akeeh vten!", c.view.message.getText());
	}
	
	@Test
	public void testKeywordDecrypt() throws InterruptedException {
		c.view.subType.setSelectedItem(SubType.KEY);
		c.view.sub.setText("kryptos");
		c.view.message.setText("akeeh vten!");
		c.view.decrypt.doClick();
		assertEquals("hallo welt!", c.view.message.getText());
	}

	@Test
	public void testSubstitutionEncrypt() throws InterruptedException {
		c.view.subType.setSelectedItem(SubType.SUBST);
		c.view.sub.setText("regänschimtöadbfjüklopquvßwxyz");
		c.view.message.setText("Hallo Welt!");
		c.view.encrypt.doClick();
		assertEquals("hrööb qnöl!", c.view.message.getText());
	}
	
	@Test
	public void testSubstitutionDecrypt() throws InterruptedException {
		c.view.subType.setSelectedItem(SubType.SUBST);
		c.view.sub.setText("regänschimtöadbfjüklopquvßwxyz");
		c.view.message.setText("hrööb qnöl!");
		c.view.decrypt.doClick();
		assertEquals("hallo welt!", c.view.message.getText());
	}

}
