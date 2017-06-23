package pr2.a11;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;

public class GuiElementsGenerator {
		
	public static JButton createButton(String buttonText, int x, int y, int width, int height,
			ActionListener controller, ActionListener aaPCEventListener, String actionCommand, JComponent parent) {
		
		JButton btn = new JButton(buttonText);

		if (width != 0 && height != 0)
			btn.setBounds(x, y, width, height);

		btn.addActionListener(controller);
		btn.addActionListener(aaPCEventListener);
		btn.setActionCommand(actionCommand);
		parent.add(btn);

		return btn;
	}
	
	public static JLabel createLabel(String LblText, int x, int y, int width, int height, 
			JComponent parent) {

		JLabel lbl = new JLabel(LblText);
		if (width != 0 && height != 0)
			lbl.setBounds(x, y, width, height);
		parent.add(lbl);
		return lbl;
	}
	
	public static JCheckBox createCheckBox(String cbText, int x, int y, int width, int height, Color background, 
			ItemListener controller, ItemListener aaPCEventListener, String actionCommand, JComponent parent) {
		JCheckBox cb = new JCheckBox(cbText);
		cb.addItemListener(controller);
		cb.addItemListener(aaPCEventListener);
		cb.setBackground(background);
		cb.setFocusPainted(false);
		cb.setBounds(x, y, width, height);
		cb.setActionCommand(actionCommand);
		parent.add(cb);
		return cb;
	}
	
	public static JTextField createTextField(String tfText, int x, int y, int width, int height,
			ActionListener controller, ActionListener aaPCEventListener, String actionCommand, JComponent parent) {
		JTextField tf = new JTextField(tfText);
		tf.setBounds(x, y, width, height);
		tf.setActionCommand(actionCommand);
		tf.addActionListener(aaPCEventListener);
		tf.addActionListener(controller);
		parent.add(tf);
		return tf;
	}
	
	public static JSpinner createSpinner(String cbText, int x, int y, int width, int height,
			ChangeListener controller, ChangeListener aaPCEventListener, String actionCommand, 
			Double startWert, Double minWert, Double maxWert, Double schrittWeite, JComponent parent) {
		JSpinner spinner = new JSpinner(new SpinnerNumberModel(startWert,minWert,maxWert,schrittWeite));
		spinner.addChangeListener(controller);
		spinner.addChangeListener(aaPCEventListener);
		spinner.setBounds(x, y, width, height);
		spinner.setName(actionCommand);
		parent.add(spinner);
		return spinner;
	}
}
