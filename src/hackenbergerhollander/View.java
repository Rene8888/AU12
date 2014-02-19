package hackenbergerhollander;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * View part of the MVC for our GUI
 * 
 * @author Hackenberger Christoph
 */
@SuppressWarnings("javadoc")
public class View extends JPanel implements ActionListener {

	private static final long serialVersionUID = 2954587672137426890L;

	private Control c;
	private JFrame f;

	public JTextField sub;
	public JLabel subText;
	public JComboBox<SubType> subType;

	public SubType lastSelected = SubType.SUBST;

	public JTextArea message;
	public JButton encrypt;
	public JButton decrypt;

	/**
	 * Creates a new View Frame
	 * 
	 * @param c
	 *            instance of control
	 */
	public View(Control c) {
		this.c = c;
		this.f = new JFrame("MonoAlphabeticCipher");
		this.f.setSize(400, 280);
		this.f.setResizable(false);
		this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.f.add(this);
		this.init();
		this.f.setVisible(true);
	}

	private void init() {
		this.setLayout(new BorderLayout());

		JPanel north = new JPanel(new GridLayout(2, 1));
		JPanel upper_n = new JPanel();
		JPanel lower_n = new JPanel();
		north.add(upper_n);
		north.add(lower_n);

		JLabel typeTxt = new JLabel("Type");
		this.subType = new JComboBox<SubType>(SubType.values());
		this.subType.addActionListener(this);
		upper_n.add(typeTxt);
		upper_n.add(subType);

		this.subText = new JLabel(((SubType) this.subType.getSelectedItem()).getTxt());
		this.sub = new JTextField(20);
		lower_n.add(this.subText);
		lower_n.add(this.sub);

		JPanel center = new JPanel(new GridLayout(2, 1));
		JPanel upper_c = new JPanel();
		JPanel lower_c = new JPanel(new GridLayout(1, 2));
		JPanel left_lc = new JPanel();
		JPanel right_lc = new JPanel();
		lower_c.add(left_lc);
		lower_c.add(right_lc);
		center.add(upper_c);
		center.add(lower_c);

		this.message = new JTextArea(5, 30);
		JScrollPane pane = new JScrollPane(this.message);
		upper_c.add(pane);

		this.encrypt = new JButton("Encrypt");
		this.decrypt = new JButton("Decrypt");

		this.encrypt.addActionListener(this);
		this.decrypt.addActionListener(this);

		left_lc.add(this.encrypt);
		right_lc.add(this.decrypt);

		this.add(north, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.encrypt) {
			String last = this.sub.getText();
			try {
				this.c.setParam((SubType) this.subType.getSelectedItem(), this.sub.getText());
				this.message.setText(this.c.encrypt(this.message.getText(), (SubType) this.subType.getSelectedItem()));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				this.sub.setText(last);
			}
		} else if (e.getSource() == this.decrypt) {
			String last = this.sub.getText();
			try {
				this.c.setParam((SubType) this.subType.getSelectedItem(), this.sub.getText());
				this.message.setText(this.c.decrypt(this.message.getText(), (SubType) this.subType.getSelectedItem()));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				this.sub.setText(last);
			}
		} else if (e.getSource() == this.subType) {
			SubType type = (SubType) this.subType.getSelectedItem();
			if (type == this.lastSelected)
				return;
			this.lastSelected = type;
			this.subText.setText(type.getTxt());
			this.sub.setColumns(type.getCol());
			this.sub.setText("");
		}
	}
}
