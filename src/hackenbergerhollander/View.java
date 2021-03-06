package hackenbergerhollander;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
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

	public RegexTextField sub;
	public JLabel subText;
	public JComboBox<SubType> subType;

	// the SubType which is loaded on startup is set here as lastSelection
	public SubType lastSelected = SubType.values()[0];

	public JTextArea message;
	public JButton encrypt;
	public JButton decrypt;
	public JButton paste;
	public JButton copy;

	// Clipboard for copy & paste function
	private Clipboard cb;

	/**
	 * Creates a new View Frame
	 * 
	 * @param c
	 *            instance of control
	 */
	public View(Control c) {
		this.c = c;
		// system clipboard is loaded
		this.cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		this.f = new JFrame("Cipher");
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
		JPanel south = new JPanel(new BorderLayout());

		north.add(new JLabel("Type"));
		this.subType = new JComboBox<SubType>(SubType.values());
		this.subType.addActionListener(this);
		north.add(this.subType);

		SubType type = (SubType) this.subType.getSelectedItem();
		this.subText = new JLabel(type.getTxt());
		this.sub = new RegexTextField(type.getPattern(), "", type.getCol());
		this.sub.setToolTipText(type.getTooltip());
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
		this.paste = new JButton("Paste");
		this.copy = new JButton("Copy");

		this.encrypt.addActionListener(this);
		this.decrypt.addActionListener(this);
		this.paste.addActionListener(this);
		this.copy.addActionListener(this);

		JPanel southwest = new JPanel();
		southwest.add(this.paste);
		south.add(southwest, BorderLayout.WEST);

		JPanel southcenter = new JPanel();
		southcenter.add(this.encrypt);
		southcenter.add(this.decrypt);
		south.add(southcenter, BorderLayout.CENTER);

		JPanel southeast = new JPanel();
		southeast.add(this.copy);
		south.add(southeast, BorderLayout.EAST);

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
			this.sub.setText("");
			this.sub.setColumns(type.getCol());
			this.sub.setPattern(type.getPattern());
			this.sub.setToolTipText(type.getTooltip());
			this.subText.setText(type.getTxt());
		} else if (e.getSource() == this.paste) {
			// the current clipboard content is loaded
			Transferable trans = this.cb.getContents(null);
			// iterate trough the different meta infos from the content, to find
			// the String one
			for (DataFlavor data : trans.getTransferDataFlavors()) {
				try {
					Object text = trans.getTransferData(data);
					if (text instanceof String) {
						this.message.append((String) text);
						return;
					}
				} catch (Exception ex) {

				}
			}
		} else if (e.getSource() == this.copy) {
			StringSelection selection = new StringSelection(this.message.getText());
			// add the String from the message area to the clipboard
			this.cb.setContents(selection, selection);
		}
	}
}
