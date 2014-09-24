package cs.ualberta.ca.djphan_301a1;

public class ToDoListController {
	
	private static ToDoList toDoList = null;
	static public ToDoList getToDoList () {
		if (toDoList == null) {
			toDoList = new ToDoList();
		}
		
		return toDoList;
	}

	public void addItem (ListItem item) {
		getToDoList().addListItem(item);
	}
	
}
