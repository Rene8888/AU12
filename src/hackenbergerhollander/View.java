package hackenbergerhollander;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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
@SuppressWarnings("serial")
public class View extends JPanel {

	private Control c;
	private JFrame f;
	private JTextField sub;
	private JLabel subText;
	private JComboBox<SubType> subType;
	
	private SubType lastSelected = SubType.SUBST;
	
	private JTextArea message;
	private JButton encrypt;
	private JButton decrypt;
	
	public View(Control c) {
		this.c = c;
		f = new JFrame("MonoAlphabeticChipher");
		f.setSize(400, 280);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(this);
		init();
		f.setVisible(true);
	}
	
	private void init() {
		
		this.setLayout(new BorderLayout());
		
		JPanel north = new JPanel(new GridLayout(2, 1));
		JPanel upper_n = new JPanel();
		JPanel lower_n = new JPanel();
		north.add(upper_n);
		north.add(lower_n);
		
		JLabel typeTxt = new JLabel("Type");
		subType = new JComboBox<SubType>(SubType.values());
		subType.addActionListener(new ComboBoxListener());
		upper_n.add(typeTxt);
		upper_n.add(subType);
		
		subText = new JLabel(((SubType)subType.getSelectedItem()).getTxt());
		sub = new JTextField(20);
		sub.addFocusListener(new FocusListener() {
			
			private String last;
			
			@Override
			public void focusLost(FocusEvent e) {
				try{
					c.setParam((SubType)subType.getSelectedItem(), sub.getText());
				}catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					sub.setText(last);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				last = sub.getText();
			}
		});
		lower_n.add(subText);
		lower_n.add(sub);
		
		JPanel center = new JPanel(new GridLayout(2,1));
		JPanel upper_c = new JPanel();
		JPanel lower_c = new JPanel(new GridLayout(1,2));
		JPanel left_lc = new JPanel();
		JPanel right_lc = new JPanel();
		lower_c.add(left_lc);
		lower_c.add(right_lc);
		center.add(upper_c);
		center.add(lower_c);
		
		message = new JTextArea(5, 30);
		JScrollPane pane = new JScrollPane(message);
		upper_c.add(pane);
		
		encrypt = new JButton("Encrypt");
		decrypt = new JButton("Decrypt");
		encrypt.setActionCommand("ec");
		decrypt.setActionCommand("dc");
		
		ButtonListener bl = new ButtonListener();
		encrypt.addActionListener(bl);
		decrypt.addActionListener(bl);
		
		left_lc.add(encrypt);
		right_lc.add(decrypt);
		
		this.add(north,BorderLayout.NORTH);
		this.add(center,BorderLayout.CENTER);
	}
	
	private class ComboBoxListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if(!(o instanceof JComboBox<?>))
				return;
			@SuppressWarnings("unchecked")
			JComboBox<SubType> box = (JComboBox<SubType>) o;
			SubType type = (SubType) box.getSelectedItem();
			if(type == lastSelected)
				return;
			lastSelected = type;
			subText.setText(type.getTxt());
			sub.setColumns(type.getCol());
			sub.setText("");
		}
	}
	
	private class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("ec"))
				message.setText(c.encrypt(message.getText(), (SubType)subType.getSelectedItem()));
			else if(cmd.equals("dc"))
				message.setText(c.decrypt(message.getText(), (SubType)subType.getSelectedItem()));
		}
	}
}
