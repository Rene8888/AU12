package hackenbergerhollander;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
// Nur um die Warnings bei den public attributen zu unterdrücken, da diese zum
// testen public sein müssen
@SuppressWarnings("javadoc")
public class View extends JPanel implements ActionListener {

	private static final long serialVersionUID = 2954587672137426890L;

	private Control c;
	private JFrame f;

	public JTextField sub;
	public JLabel subText;
	public JComboBox<SubType> subType;

	public SubType lastSelected = SubType.values()[0];

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
		this.f.setMinimumSize(new Dimension(600, 500));
		this.f.setSize(new Dimension(600, 500));
		this.f.setResizable(true);
		this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.f.setLocationRelativeTo(null);
		this.f.setContentPane(this);
		this.init();
		this.f.setVisible(true);
	}

	private void init() {
		this.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		JPanel south = new JPanel();

		north.add(new JLabel("Type"));
		this.subType = new JComboBox<SubType>(SubType.values());
		this.subType.addActionListener(this);
		north.add(this.subType);

		this.subText = new JLabel(((SubType) this.subType.getSelectedItem()).getTxt());
		this.sub = new JTextField(((SubType)this.subType.getSelectedItem()).getCol());
		north.add(new JLabel("     "));
		north.add(this.subText);
		north.add(this.sub);

		this.message = new JTextArea();
		this.message.setLineWrap(true);
		this.message.setWrapStyleWord(true);
		JScrollPane pane = new JScrollPane(this.message);
		pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(pane, BorderLayout.CENTER);

		this.encrypt = new JButton("Encrypt");
		this.decrypt = new JButton("Decrypt");

		this.encrypt.addActionListener(this);
		this.decrypt.addActionListener(this);

		south.add(this.encrypt);
		south.add(this.decrypt);
		
		this.add(north, BorderLayout.NORTH);
		this.add(south, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.encrypt) {
			String last = this.sub.getText();
			try {
				this.c.setParam((SubType) this.subType.getSelectedItem(), this.sub.getText());
				this.message.setText(this.c.encrypt(this.message.getText(), (SubType) this.subType.getSelectedItem()));
			} catch (Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				this.sub.setText(last);
			}
		} else if (e.getSource() == this.decrypt) {
			String last = this.sub.getText();
			try {
				this.c.setParam((SubType) this.subType.getSelectedItem(), this.sub.getText());
				this.message.setText(this.c.decrypt(this.message.getText(), (SubType) this.subType.getSelectedItem()));
			} catch (Exception ex) {
				ex.printStackTrace();
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
