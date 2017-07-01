package pr2.a12.utils;

import java.io.File;

import javax.swing.JFileChooser;

import pr2.a12.SmileyModel;
import pr2.a12.exceptions.FileHasNotBeenChosenException;

public abstract class AbstractAppStateStoring {

	protected File recentFile;
	protected SmileyModel smileyModel;
	

	public AbstractAppStateStoring(SmileyModel smileyModel) {
		recentFile = null;
		this.smileyModel = smileyModel;
	}

	abstract public void setFileFilter(JFileChooser jFileChooser);
	
	protected void chooseFileDialog(int dialogType) throws FileHasNotBeenChosenException {
		JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(recentFile);
		setFileFilter(fc);
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
}
