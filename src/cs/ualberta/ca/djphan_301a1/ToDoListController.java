package cs.ualberta.ca.djphan_301a1;

public class ToDoListController {
	
	private static ToDoList toDoList = null;
	
	public static ToDoList getToDoList (String args) {
		if (toDoList == null) {
			// Create a new toDoList
			toDoList = new ToDoList();
		}
		
		switch (args) {
		case "ARCHIVELIST":
			return toDoList;
		case  "MAINLIST":
			return toDoList;
		default:
			return toDoList;
		}

		
	}

	public void addItem (String args, ListItem item) {
		getToDoList(args).addListItem(item);
	}

	public void removeItem(String args, ListItem item) {
		getToDoList(args).removeListItem(item);	
	}
	

	
}
