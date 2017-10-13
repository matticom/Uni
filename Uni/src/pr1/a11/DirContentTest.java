package pr1.a11;

import java.io.File;

public class DirContentTest {

	// Typkonvertierungskonstruktoren: von String in Path / Parent + Child
	
	
	public static void main(String[] args) {
		DirContent dirContent = new DirContent();
		String bla ="";
		bla = null;
		File[] dirs = {new File(bla), new File("C:/Program Files/"), new File("C:/Windows/")};
		dirContent.test(dirs);
		System.out.println(new File("C:/eclipse/java.projects/git/Uni/Uni/data").getParent());
		System.out.println(new File("C:/eclipse/java.projects/git/Uni/Uni/data").getParentFile());
	}

}
