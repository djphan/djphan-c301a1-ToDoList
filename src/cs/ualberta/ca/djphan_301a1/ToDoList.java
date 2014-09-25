package cs.ualberta.ca.djphan_301a1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class ToDoList implements Serializable{
	private static final long serialVersionUID = 1L;
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
	
	public void addListener(Listener listener) {
		listeners.add(listener);
	}
	
	public void removeListner(Listener listener) {
		listeners.remove(listener);
	}
	
	private void notifyListners() {
		// Function to notify listeners that a change occurred to update views.
		// Code is based around the Hindle Student Picker Tutorial
		for (Listener listener:listeners) {
			listener.update();
		}			
	}

	public int countTotalItems() {
		return toDoList.size();
	}
	
	public int countCheckedItem () {
		int counter = 0;
		for (ListItem todoItem : toDoList) {
			if (todoItem.getCheckItem() == true ){
				counter += 1;
			}
		}
		return counter;
	}
	
	public int countArchivedItem () {
		int counter = 0;
		for (ListItem todoItem : toDoList) {
			if (todoItem.getCheckArchive() == true ){
				counter += 1;
			}
		}
		return counter;
		}

}
