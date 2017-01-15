package pr1.a11;

import java.io.File;

public class DirContentTest {

	// Typkonvertierungskonstruktoren: 
	//		von String in File / Parent Path(als String/File) kann 
	//		mit Child Path zu einen File Path verkn�pft werden (als String) / 
	//		von URI in File
	// File ( String pathname ) 
	// File ( String parent, String child ) 
	// File ( File parent, String child )
	// File ( URI uri )
	
	// Statische Factorymethoden:
	//		static File[] listRoots(): Gibt eine List mit File Objekten der 
	//			Rootverzeichnisse auf dem System zur�ck (C:\, ...)
	//		static File createTempFile( String prefix, String suffix ):
	//			Legt eine neue Datei im tempor�ren Verzeichnis an. Das 
	//			Verzeichnis findet sich h�ufig unter einem Standard-Unix
	//			/tmp oder unter Windows C:\Dokumente und Einstellungen\ 
	//			Benutzername\Lokale Einstellungen\Temp. Der Dateiname 
	//			setzt sich aus einem benutzerdefinierten Pr�fix, einer 
	//			Zufallsfolge und einem Suffix zusammen.
	//		static File createTempFile( String prefix, String suffix, File directory): 
	//			hier kann das Tempverzeichnis zus�tzlich selbst bestimmt werden
	
	// Eigenschaften einer Methodenverbundklasse:
	// 		die File Klasse hat weder Klassenmethoden (nur spezielle statische 
	//		Factorymethoden) noch statische Konstanten
	
	public static void main(String[] args) {
		DirContent dirContent = new DirContent();
		File[] dirs = {new File("C:/eclipse/"), new File("C:/"), new File("C:/Windows/")};
		dirContent.test(dirs);
	}
}
