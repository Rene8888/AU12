package hackenbergerhollander.test;

import static org.junit.Assert.assertEquals;
import hackenbergerhollander.Control;
import hackenbergerhollander.SubType;

import org.junit.Test;

/**
 * Test class for all gui tests
 * 
 * @author Rene Hollander
 */
@SuppressWarnings("javadoc")
public class GuiTest {

	@Test
	public void testShift() throws InterruptedException {
		Control c = new Control();
		c.view.subType.setSelectedItem(SubType.SHIFT);
		c.view.sub.setText("2");
		c.view.message.setText("Hallo Welt!");
		c.view.encrypt.doClick();
		assertEquals("jcnnq ygnv!", c.view.message.getText());
		c.view.decrypt.doClick();
		assertEquals("hallo welt!", c.view.message.getText());
	}

	@Test
	public void testKeyword() throws InterruptedException {
		Control c = new Control();
		c.view.subType.setSelectedItem(SubType.KEY);
		c.view.sub.setText("kryptos");
		c.view.message.setText("Hallo Welt!");
		c.view.encrypt.doClick();
		assertEquals("akeeh vten!", c.view.message.getText());
		c.view.decrypt.doClick();
		assertEquals("hallo welt!", c.view.message.getText());
	}

	@Test
	public void testSubstitution() throws InterruptedException {
		Control c = new Control();
		c.view.subType.setSelectedItem(SubType.SUBST);
		c.view.sub.setText("regänschimtöadbfjüklopquvßwxyz");
		c.view.message.setText("Hallo Welt!");
		c.view.encrypt.doClick();
		assertEquals("hrööb qnöl!", c.view.message.getText());
		c.view.decrypt.doClick();
		assertEquals("hallo welt!", c.view.message.getText());
	}

}
