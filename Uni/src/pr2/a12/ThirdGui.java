package pr2.a12;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

import pr2.a12.views.GuiMenuBar;
import pr2.a12.views.GuiToolbar;
import pr2.a12.views.SmileyControlPanel;
import pr2.a12.views.SmileyDisplayPanel;

public class ThirdGui {
	public static void main(String[] args) {
		
		AaPCEventPrinter printer = new AaPCEventPrinter();
		SmileyModel smileyModel = new SmileyModel();
		Controller controller = new Controller(smileyModel);
		GuiMenuBar guiMenuBar = new GuiMenuBar(controller, smileyModel, printer);
		GuiToolbar toolbar = new GuiToolbar(controller, smileyModel, printer);
		SmileyControlPanel smileyControlPanel = new SmileyControlPanel(controller, smileyModel, printer);
		SmileyDisplayPanel smileyDisplayPanel = new SmileyDisplayPanel(smileyModel);
				
		smileyModel.addPropertyChangeListener(printer);
		smileyModel.addPropertyChangeListener(smileyDisplayPanel);
		smileyModel.addPropertyChangeListener(smileyControlPanel);
		smileyModel.addPropertyChangeListener(guiMenuBar);
		smileyModel.addPropertyChangeListener(toolbar);
		
		PropertyChangeListener[] propertyChangeListener = 
				new PropertyChangeListener[] {printer, smileyDisplayPanel, smileyControlPanel, guiMenuBar, toolbar};
		controller.setPropertyChangeListener(propertyChangeListener);
		
		JFrame jFrame = new JFrame("Smiley");
		jFrame.setJMenuBar(guiMenuBar);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(new Dimension(1000, 700));
				
		Container contentPane = jFrame.getContentPane();
	
		jFrame.add(toolbar, BorderLayout.NORTH);
		contentPane.add(smileyDisplayPanel, BorderLayout.CENTER);
		contentPane.add(smileyControlPanel, BorderLayout.EAST);
		jFrame.setVisible(true);		
	}
}
