package pr1.a01;

import java.util.LinkedList;
import java.util.List;

public class LinkedList_Remove_Test {

	public static void main(String[] args) {
		List list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		for(int i=0; i < list.size(); i++){
			System.out.println(i + ": " + list.get(i));
		}
		list.remove(1);
		for(int i=0; i < list.size(); i++){
			System.out.println(i + ": " + list.get(i));
		}
		// Alle Elemente nach gelöschten Index werden zu Index-1

	}

}
