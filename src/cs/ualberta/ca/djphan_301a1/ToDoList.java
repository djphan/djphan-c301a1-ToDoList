package cs.ualberta.ca.djphan_301a1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class ToDoList implements Serializable{
	private static final long serialVersionUID = 1L;
	public ArrayList<ListItem> toDoList;
	public ArrayList<Listener> listeners;
	
	public ToDoList() {
		toDoList = new ArrayList<ListItem>();
		listeners = new ArrayList<Listener>();
	}
	
	public Collection<ListItem> getList() {
		return toDoList;
	}
	
    //Dr Hindle Student Picker(http://www.youtube.com/watch?v=5PPD0ncJU1g&list=UUTLkh9KmeYXQBR59wJxq1eg)
	// was uised to develop the listener funcions in the ToDoList class
	public void addListItem (ListItem listItem) {
		toDoList.add(listItem);
		// Update UI step
		notifyListners();
	}


	public void removeListItem (ListItem listItem) {
		toDoList.remove(listItem);
		// Update UI step
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

	// Counting Functions for the Stats Portion
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
