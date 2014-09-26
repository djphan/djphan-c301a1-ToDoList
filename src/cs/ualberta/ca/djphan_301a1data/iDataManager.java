package cs.ualberta.ca.djphan_301a1data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cs.ualberta.ca.djphan_301a1.ListItem;

public interface iDataManager {
	public ArrayList<ListItem> loadToDoList();
	public void saveList(Collection<ListItem> saveList);

}
