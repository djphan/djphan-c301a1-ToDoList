package cs.ualberta.ca.djphan_301a1;

import java.util.ArrayList;
import java.util.Collection;

import EmailHandler.EmailAdapter;
import EmailHandler.EmailHandler;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class EMailArchiveActivity extends Activity {
	public EmailHandler emailHandler = new EmailHandler(this);
	public Collection<ListItem> listItem;
	public ArrayList<ListItem> emailList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email_archive);

		// Receive Bundle
		Bundle sBundle = getIntent().getBundleExtra("bcontrol");
	    ToDoListController listcontroller = (ToDoListController) sBundle.get("lcontrol");
	    listItem = ToDoListController.returnArchiveList().getList();
	    
        // Code to populate the list view adapted from StudentPicker example
        ListView listview = (ListView) findViewById(R.id.listViewEmailArch);
    	final ArrayList<ListItem> toDoList = new ArrayList<ListItem>(listItem);
        final EmailAdapter emailAdapter = new EmailAdapter(this,toDoList, listcontroller);
    	emailList = toDoList;
        listview.setAdapter(emailAdapter);
        listview.setItemsCanFocus(true);
        
        ToDoListController.returnArchiveList().addListener(new Listener() {
        	@Override
        	public void update () {
        		toDoList.clear();
        		Collection<ListItem> listItem = ToDoListController.returnArchiveList().getList();
        		toDoList.addAll(listItem);
        		emailAdapter.notifyDataSetChanged();
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void SendAllArcToDo(View v) {
		Toast.makeText(this, "Send All Archived Items", Toast.LENGTH_SHORT).show();
		emailHandler.emailArrayList(emailList);
	}
	
	public void SendSelArcToDo(View v) {
		Toast.makeText(this, "Send Selected Archived Items", Toast.LENGTH_SHORT).show();
		
	}
}
