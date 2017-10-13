package pr2.aKlausur;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class App {
	
	public static void main(String[] args) {
		Polynom poly = new Polynom();
		XRezi rezi = new XRezi();
		Linear linear = new Linear();
		FunctionPlotter fctPlotter = new FunctionPlotter(poly);
		JFrame win = new JFrame("Funktionsplotter");
		win.getContentPane().add(fctPlotter, BorderLayout.CENTER);
		win.setSize(500, 600);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);
	}
}
