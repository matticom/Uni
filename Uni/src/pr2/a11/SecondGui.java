package pr2.a11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class SecondGui {
	public static void main(String[] args) {
		AaPCEventPrinter printer = new AaPCEventPrinter();
		SmileyModel smileyModel = new SmileyModel();
		Controller controller = new Controller(smileyModel);
		SmileyControlPanel smileyControlPanel = new SmileyControlPanel(controller, smileyModel, printer);
		SmileyDisplayPanel smileyView = new SmileyDisplayPanel(smileyModel);
				
		smileyModel.addPropertyChangeListener(printer);
		smileyModel.addPropertyChangeListener(smileyView);
		smileyModel.addPropertyChangeListener(smileyControlPanel);
		JFrame jFrame = new JFrame("Smiley");
		jFrame.setSize(new Dimension(850, 600));
		
		Container contentPane = jFrame.getContentPane();
		contentPane.add(smileyView, BorderLayout.CENTER);
		contentPane.add(smileyControlPanel, BorderLayout.EAST);
		jFrame.setVisible(true);		
	}
}
