package cs.ualberta.ca.djphan_301a1;

public class ListItem {
	private String listString; // ToDo List item
	private Boolean checkItem; // Checked value
	private Boolean checkArchive; // Archived value
	
	public ListItem (String listString, Boolean checkItem, Boolean checkArchive) {
		this.listString = listString;
		this.checkItem = checkItem;
		this.checkArchive = checkArchive;
	}
	
	public String getListItem () {
		return this.listString;
	}
	
	public void setListItem (String listString) {
		this.listString = listString;
	}
	
	public boolean getCheckItem () {
		return this.checkItem;
	}
	
	public void setCheckItem (Boolean checkItem) {
		this.checkItem = checkItem;
	}
	
	public boolean getCheckArchive () {
		return this.checkArchive;	
	}
	
	public void setCheckArchive (Boolean checkArchive) {
		this.checkArchive = checkArchive;
	}
	
}
