package cs.ualberta.ca.djphan_301a1data;

import java.util.ArrayList;
import java.util.List;

import android.app.LauncherActivity.ListItem;


public interface iDataManager {
	public ArrayList<ListItem> loadToDoList();
	public void saveToDoList(List<ListItem> savelist);
}
