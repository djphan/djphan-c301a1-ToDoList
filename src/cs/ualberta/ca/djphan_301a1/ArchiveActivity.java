package cs.ualberta.ca.djphan_301a1;

import java.util.ArrayList;
import java.util.Collection;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class ArchiveActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_archive);
		
		Bundle sBundle = getIntent().getBundleExtra("bcontrol");
	    ToDoListController listcontroller = (ToDoListController) sBundle.get("lcontrol");
	
	    Collection<ListItem> listItem = ToDoListController.returnArchiveList().getList();

        // Code to populate the list view adapted from StudentPicker example
        ListView listview = (ListView) findViewById(R.id.archiveListView);
        final ArrayList<ListItem> toDoList = new ArrayList<ListItem>(listItem);
        final ToDoListAdapter toDoListViewAdapter = new ToDoListAdapter(this,toDoList, listcontroller);
        
        listview.setAdapter(toDoListViewAdapter);
        listview.setItemsCanFocus(true);
        
        ToDoListController.returnArchiveList().addListener(new Listener() {
        	@Override
        	public void update () {
        		toDoList.clear();
        		Collection<ListItem> listItem = ToDoListController.returnArchiveList().getList();
        		toDoList.addAll(listItem);
        		toDoListViewAdapter.notifyDataSetChanged();
        	}});     
        }		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.emptymenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		return super.onOptionsItemSelected(item);
	}
}
