package cs.ualberta.ca.djphan_301a1;

import java.util.Collection;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class StatsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats);
		// Receive Bundle
		Bundle sBundle = getIntent().getBundleExtra("bcontrol");
	    ToDoListController listcontroller = (ToDoListController) sBundle.get("lcontrol");
	    
	    // Separate out 2 types of data to update
	    ToDoList mainlist = ToDoListController.returnPubList();
	    ToDoList arclist = ToDoListController.returnArchiveList();
	    
	    updateMainStats (mainlist);
	    updateArchiveStats (arclist);
		
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
	
	public void updateMainStats (ToDoList list) {
		
		TextView numCheckedToDo = (TextView) findViewById(R.id.checkedToDoListText);
		numCheckedToDo.setText(Integer.toString(list.countCheckedItem()));
		TextView numUncheckedToDo = (TextView) findViewById(R.id.uncheckedToDoListText);
		numUncheckedToDo.setText(Integer.toString(list.countTotalItems()- list.countCheckedItem() ));
		
	}
	public void updateArchiveStats (ToDoList list) {		
		TextView numTotalArchive = (TextView) findViewById(R.id.totalArchiveToDoText);
		numTotalArchive.setText(Integer.toString(list.countTotalItems()));
		TextView numCheckedArchive = (TextView) findViewById(R.id.checkedArchiveToDoText);
		numCheckedArchive.setText(Integer.toString(list.countCheckedItem()));
		TextView numUncheckArchive = (TextView) findViewById(R.id.uncheckedArchiveToDoText);
		numUncheckArchive.setText(Integer.toString(list.countTotalItems() - list.countCheckedItem() ));
	
	}
	
}
