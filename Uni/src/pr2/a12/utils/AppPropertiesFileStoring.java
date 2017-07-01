package pr2.a12.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import pr2.a12.exceptions.FileHasNotBeenChosenException;

public class AppPropertiesFileStoring {

	protected File recentFile;
	protected Properties props;
	protected final String[] fieldNames;

	public AppPropertiesFileStoring() {
		recentFile = null;
		props = new Properties();
		fieldNames = new String[] { "x", "y", "kopfRadius", "augenKopfProzent", "augapfelWinkel", "laecheln", "locale" };
	}

	public String[] loadProperties() throws IOException, FileHasNotBeenChosenException {
		chooseFileDialog(JFileChooser.OPEN_DIALOG);
		return readProperties();
	}

	public void saveProperties(String[] fields) throws IOException, FileHasNotBeenChosenException {
		chooseFileDialog(JFileChooser.SAVE_DIALOG);
		writeProperties(fields);
	}

	public String[] readProperties() throws IOException {
		try (FileInputStream in = new FileInputStream(recentFile)) {
			props.load(in);
			String[] fields = new String[fieldNames.length];
			for (int i = 0; i < fieldNames.length; i++) {
				fields[i] = props.getProperty(fieldNames[i]);
			}
			return fields;
		} catch (IOException e) {
			throw new IOException();
		}
	}

	public void writeProperties(String[] fields) throws IOException {
		for (int i = 0; i < fieldNames.length; i++) {
			props.setProperty(fieldNames[i], fields[i]);
		}
		try (FileOutputStream out = new FileOutputStream(recentFile)) {
			props.store(out, null);
		} catch (IOException e) {
			throw new IOException();
		}
	}

	protected void chooseFileDialog(int dialogType) throws FileHasNotBeenChosenException {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(recentFile);
		fc.setFileFilter(new FileNameExtensionFilter("Properties Datei (*.properties)", "properties"));
		int option;
		if (dialogType == JFileChooser.SAVE_DIALOG) {
			option = fc.showSaveDialog(null);
		} else {
			option = fc.showOpenDialog(null);
		}
		if (option != JFileChooser.APPROVE_OPTION) {
			throw new FileHasNotBeenChosenException();
		}
		recentFile = fc.getSelectedFile();
	}
	
	public void setFileFilter(JFileChooser jFileChooser) {
		
	}
}
