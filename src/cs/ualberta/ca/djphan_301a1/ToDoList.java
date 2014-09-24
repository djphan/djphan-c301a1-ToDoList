package cs.ualberta.ca.djphan_301a1;

import java.util.ArrayList;
import java.util.Collection;

public class ToDoList {
	
	private ArrayList<ListItem> toDoList;
	private ArrayList<Listener> listeners;
	
	public ToDoList() {
		toDoList = new ArrayList<ListItem>();
		listeners = new ArrayList<Listener>();
	}
	
	public Collection<ListItem> getList() {
		return toDoList;
	}
	
	public void addListItem (ListItem listItem) {
		toDoList.add(listItem);
		notifyListners();
	}

	public void removeListItem (ListItem listItem) {
		toDoList.remove(listItem);
		notifyListners();
	} 
	
	public void addListners() {
		listeners.add();
	}
	
	private void notifyListners() {
		// Function to notify listeners that a change occurred to update views.
		// Code is based around the Hindle Student Picker Tutorial
		
		for (Listener listener : listeners) {
			((Listener) listeners).update();
		}		
		
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
