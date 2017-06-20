package pr2.a11;

import java.awt.Graphics;
import static pr2.a11.GuiElementsGenerator.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SmileyControlPanel extends JPanel{
	protected JButton traurigButtuon;
	protected JButton zufriedenButton;
	protected JLabel gemuetsLabel;
	protected JCheckBox laechelnCheckBox;
	protected JLabel laechelnLabel;
	protected JTextField augenwinkelTF;
	protected JLabel augenwinkelLabel;
	protected JTextField augenRadiusTF;
	protected JLabel augenRadiusLabel;
	protected JTextField kopfRadiusTF;
	protected JLabel kopfRadiusLabel;
	
	protected Controller controller;
	protected SmileyModel smileyModel;
	protected AaPCEventPrinter eventPrinter;
	
	
	public SmileyControlPanel(Controller controller, SmileyModel smileyModel, AaPCEventPrinter eventPrinter) {
		this.controller = controller;
		this.smileyModel = smileyModel;
		this.eventPrinter = eventPrinter;
		createGuiElements();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
//		augenRadius = kopfRadius * augenKopfProzent / 100;
//		int xPos_linkes_Auge = (int) (kopfRadius / 2);
//		int xPos_rechtes_Auge = (int) (3 * kopfRadius / 2);
//		int yPos_Augen = (int) (4 * kopfRadius / 5);
//		Point linkes_Auge = new Point(x + xPos_linkes_Auge, y + yPos_Augen);
//		Point rechtes_Auge = new Point(x + xPos_rechtes_Auge, y + yPos_Augen);
//		drawKopf(g);
//		drawAugen(g, linkes_Auge, rechtes_Auge);
//		drawAugaepfel(g, linkes_Auge, rechtes_Auge);
//		drawMund(g);
	}
	
	protected void createGuiElements() {
//		traurigButtuon = createButton("Traurig", 20, 400, 40, 10, controller, "TRAURIG_BUTTON", this);
//		zufriedenButton = createButton("Zufrieden", 80, 400, 40, 10, controller, "ZUFRIEDEN_BUTTON", this);
//		gemuetsLabel = createLabel("Gütszustand", 20, 380, 40, 10, this);
//		laechelnCheckBox = createCheckBox("LAECHELN_CHECKBOX", 20, 400, 40, 10, controller, "TRAURIG_BUTTON", this);
		
	}
}
