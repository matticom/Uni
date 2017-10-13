package pr2.a12.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import pr2.a12.SmileyModel;
import pr2.a12.exceptions.FileHasNotBeenChosenException;

public class AppStateSerialization extends AbstractAppStateStoring {

	public AppStateSerialization(SmileyModel smileyModel) {
		super(smileyModel);

	}

	public void serializeState() throws IOException, FileHasNotBeenChosenException {
		chooseFileDialog(JFileChooser.SAVE_DIALOG);
		try (FileOutputStream fos = new FileOutputStream(recentFile)) {
			ObjectOutputStream o = new ObjectOutputStream(fos);
			o.writeObject(smileyModel);
		}
	}

	public SmileyModel deSerializeState() throws FileHasNotBeenChosenException, ClassNotFoundException, IOException {
		chooseFileDialog(JFileChooser.OPEN_DIALOG);
		try (FileInputStream fis = new FileInputStream(recentFile)) {
			ObjectInputStream o = new ObjectInputStream(fis);
			return (SmileyModel) o.readObject();
		}
	}

	@Override
	public void setFileFilter(JFileChooser jFileChooser) {
		jFileChooser.setFileFilter(new FileNameExtensionFilter("Ser Datei (*.ser)", "ser"));
	}

}
