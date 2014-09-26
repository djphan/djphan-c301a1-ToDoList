package cs.ualberta.ca.djphan_301a1;

import java.io.Serializable;

import android.content.Context;
import android.widget.Toast;

public class ToDoListController implements Serializable {
	
	// Total ToDoList
	private static ToDoList toDoList = null;
	
	// Sectional Lists for Archive and Main
	private static ToDoList arc_todolist = null;
	private static ToDoList pub_todolist = null;
	
	public static ToDoList getToDoList () {
		if (toDoList == null) {
			// Create a new toDoList
			toDoList = new ToDoList();
		}
		return toDoList;	
	}
	
	public static ToDoList returnArchiveList () {
		if (arc_todolist == null) {
			arc_todolist = new ToDoList();
		}
			
		return arc_todolist;
	}
	
	public static ToDoList returnPubList () {
		if (pub_todolist == null) {
			pub_todolist = new ToDoList();
		}
		return pub_todolist;
	}
	
	public void updateTrackingLists () {
		for (ListItem items : toDoList.getList()) {
			if (items.getCheckArchive() == false) {
				// Case checking to update 'public interface' list
				if (returnArchiveList ().getList().contains(items)) {
					returnArchiveList ().removeListItem(items);	
				}
				
				if (returnPubList().getList().contains(items) == false) {
					returnPubList().addListItem(items);
				}
				
			} else {
				if (returnArchiveList ().getList().contains(items) == false) {
					returnArchiveList ().addListItem(items);	
				}
				
				if (returnPubList().getList().contains(items)) {
					returnPubList().removeListItem(items);
				}
				
			}
		}
	}
	
	
	public void addItem (int type, ListItem item) {
		switch (type){
			case 1:
				returnArchiveList().addListItem(item);
			case 2:
				returnPubList().addListItem(item);
			default:
				getToDoList().addListItem(item);
				returnPubList().addListItem(item);
		}
	}
		
	public void removeItem(int type, ListItem item) {
		switch(type) {
		case 1:
			returnArchiveList().removeListItem(item);
		case 2:
			returnPubList().removeListItem(item);
		default:
			getToDoList().removeListItem(item);
			returnPubList().removeListItem(item);
			returnArchiveList().removeListItem(item);
		}

	}
		
	}
