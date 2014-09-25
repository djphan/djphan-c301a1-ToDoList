package cs.ualberta.ca.djphan_301a1;

public class ToDoListController {
	
	// Total ToDoList
	private static ToDoList toDoList = null;
	
	// Sectional Lists for Archive and Main
	private ToDoList arc_todolist;
	private ToDoList pub_todolist;
	
	
	public static ToDoList getToDoList () {
		
		if (toDoList == null) {
			// Create a new toDoList
			toDoList = new ToDoList();
		}
		
		return toDoList;
		
	}
	
	public ToDoList returnArchiveList () {
		return arc_todolist;
	}
	
	public ToDoList returnPubList () {
		return pub_todolist;
	}
	
	public void updateTrackingLists () {
		for (ListItem items : toDoList.getList()) {
			if (items.getCheckArchive() == false) {
				// Case checking to update 'public interface' list
				if (arc_todolist.getList().contains(items)) {
					arc_todolist.removeListItem(items);	
				}
				
				if (pub_todolist.getList().contains(items) == false) {
					pub_todolist.addListItem(items);
				}
				
			} else {
				if (arc_todolist.getList().contains(items) == false) {
					arc_todolist.addListItem(items);	
				}
				
				if (pub_todolist.getList().contains(items)) {
					pub_todolist.removeListItem(items);
				}
				
			}
		}
	}
	
	
	public void bruteUpdateTrackinglists() {
		// Naive method that brute forces update the lists
		ToDoList temp_arc = new ToDoList();
		ToDoList temp_pub = new ToDoList();
		
		for (ListItem items : toDoList.getList()) {
			if ( items.getCheckArchive() == true ) {
				temp_arc.addListItem(items);
			} else {
				temp_pub.addListItem(items);
			}
			
		}
		
		arc_todolist = temp_arc;
		pub_todolist = temp_pub;
	}
	
	public void addItem (ListItem item) {
		getToDoList().addListItem(item);
		if (item.getCheckArchive() == true) {
			arc_todolist.addListItem(item);
		} else {
			pub_todolist.addListItem(item);
		}
				
	}
		
	public void removeItem(ListItem item) {
		getToDoList().removeListItem(item);	
		
		if (item.getCheckArchive() == true) {
			arc_todolist.removeListItem(item);
		} else {
			pub_todolist.removeListItem(item);
		}	
	}
		
	}
	


