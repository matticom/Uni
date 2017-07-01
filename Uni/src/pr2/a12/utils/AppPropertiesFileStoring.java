package pr2.a12.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import pr2.a12.SmileyModel;

public class AppPropertiesFileStoring extends AbstractAppStateStoring {

	protected Properties props;
	protected final String[] fieldNames;

	public AppPropertiesFileStoring(SmileyModel smileyModel) {
		super(smileyModel);
		props = new Properties();
		fieldNames = new String[] { "x", "y", "kopfRadius", "augenKopfProzent", "augapfelWinkel", "laecheln", "locale" };
	}

	public void loadProperties() {
		try {
			chooseFileDialog(JFileChooser.OPEN_DIALOG);
			smileyModel.setAllFields(readProperties());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Load Property Error", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void saveProperties() {
		try {
			chooseFileDialog(JFileChooser.SAVE_DIALOG);
			writeProperties(smileyModel.getAllFields());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Save Property Error", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}

	protected String[] readProperties() throws IOException {
		try (FileInputStream in = new FileInputStream(recentFile)) {
			props.load(in);
			String[] fields = new String[fieldNames.length];
			for (int i = 0; i < fieldNames.length; i++) {
				fields[i] = props.getProperty(fieldNames[i]);
			}
			return fields;
		}
	}

	protected void writeProperties(String[] fields) throws IOException {
		for (int i = 0; i < fieldNames.length; i++) {
			props.setProperty(fieldNames[i], fields[i]);
		}
		try (FileOutputStream out = new FileOutputStream(recentFile)) {
			props.store(out, null);
		}
	}
	
	@Override
	public void setFileFilter(JFileChooser jFileChooser) {
		jFileChooser.setFileFilter(new FileNameExtensionFilter("Properties Datei (*.properties)", "properties"));
	}	
}
