package cs.ualberta.ca.djphan_301a1;

import java.util.ArrayList;
import java.util.Collection;

public class ToDoList {
	
	private ArrayList<ListItem> toDoList;
	
	public ToDoList() {
		toDoList = new ArrayList<ListItem>();
	}
	
	public Collection<ListItem> getList() {
		return toDoList;
	}
	
	public void addListItem (ListItem listItem) {
		toDoList.add(listItem);
	}

	public void removeListItem (ListItem listItem) {
		toDoList.remove(listItem);
	} 
	
	public int countTotalListItem () {
		return toDoList.size();	
	}
	
	public int countCheckedItem () {
		//int countCItems = Collection.frequency(toDoList, );
		return 0;
	}
	
	public void countArchivedItem () {
		}

}
