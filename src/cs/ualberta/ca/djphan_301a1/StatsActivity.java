package cs.ualberta.ca.djphan_301a1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class StatsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats);
		
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
	
	public void updateStats (ToDoList list) {
		TextView numTotalArchive = (TextView) findViewById(R.id.totalArchiveToDoText);
		TextView numCheckedArchive = (TextView) findViewById(R.id.checkedArchiveToDoText);
		TextView numUncheckArchive = (TextView) findViewById(R.id.uncheckedArchiveToDoText);

		TextView numCheckedToDo = (TextView) findViewById(R.id.checkedToDoListText);
		TextView numUncheckedToDo = (TextView) findViewById(R.id.checkedToDoListText);
	}
	
}
