package pr2.a12;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ThirdGui {
	public static void main(String[] args) {
		
		AaPCEventPrinter printer = new AaPCEventPrinter();
		SmileyModel smileyModel = new SmileyModel();
		Controller controller = new Controller(smileyModel);
		GuiMenuBar guiMenuBar = new GuiMenuBar(controller, smileyModel, printer);
		SmileyControlPanel smileyControlPanel = new SmileyControlPanel(controller, smileyModel, printer);
		SmileyDisplayPanel smileyView = new SmileyDisplayPanel(smileyModel);
				
		smileyModel.addPropertyChangeListener(printer);
		smileyModel.addPropertyChangeListener(smileyView);
		smileyModel.addPropertyChangeListener(smileyControlPanel);
		smileyModel.addPropertyChangeListener(guiMenuBar);
		JFrame jFrame = new JFrame("Smiley");
		jFrame.setJMenuBar(guiMenuBar);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setSize(new Dimension(850, 600));
		
		GuiToolbar toolbar = new GuiToolbar(controller, printer);
		Container contentPane = jFrame.getContentPane();
	
		jFrame.add(toolbar, BorderLayout.NORTH);
		contentPane.add(smileyView, BorderLayout.CENTER);
		contentPane.add(smileyControlPanel, BorderLayout.EAST);
		jFrame.setVisible(true);		
	}
}
