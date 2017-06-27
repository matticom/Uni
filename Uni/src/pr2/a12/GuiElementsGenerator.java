package pr2.a12;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
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
	
	public static JMenu createMenu(JMenuBar menuBar, String menuText, String menuName, int shortKey) {

		JMenu menu = null;
		menu = new JMenu();
		menu.setText(menuText);
		menu.setName(menuName);
		if (shortKey > 0)
			menu.setMnemonic(shortKey);
		menuBar.add(menu);
		return menu;
	}
	
	public static JMenuItem createMenuItem(JMenu menu, String actionCmd, ActionListener actionListener, ActionListener actionListener2, String miText,
			ImageIcon icon, int shortKey) {

		JMenuItem menuItem = new JMenuItem();
		menuItem.setActionCommand(actionCmd);
		menuItem.setText(miText);
		menuItem.setIcon(icon);
		if (shortKey > 0)
			menuItem.setMnemonic(shortKey);
		menuItem.addActionListener(actionListener);
		menuItem.addActionListener(actionListener2);
		menu.add(menuItem);
		return menuItem;
	}
	
	public static JCheckBox createMenuItemCheckBox(JMenu menu, String actionCmd, ItemListener itemListener, ItemListener itemListener2, String miText,
			ImageIcon icon, int shortKey) {

		JCheckBox menuItemCheckBox = new JCheckBox();
		menuItemCheckBox.setActionCommand(actionCmd);
		menuItemCheckBox.setText(miText);
		menuItemCheckBox.setIcon(icon);
		if (shortKey > 0)
			menuItemCheckBox.setMnemonic(shortKey);
		menuItemCheckBox.addItemListener(itemListener);
		menuItemCheckBox.addItemListener(itemListener2);
		menu.add(menuItemCheckBox);
		return menuItemCheckBox;
	}
	
	public static JMenu createSubMenu(JMenu menu, String miName, String miText,	ImageIcon icon, int shortKey) {

		JMenu subMenu = new JMenu();
		subMenu.setName(miName);
		subMenu.setText(miText);
		subMenu.setIcon(icon);
		if (shortKey > 0)
			subMenu.setMnemonic(shortKey);
		menu.add(subMenu);
		return subMenu;
	}

}
