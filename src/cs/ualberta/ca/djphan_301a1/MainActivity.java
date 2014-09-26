/* 

CMPUT 301 - A1 - To Do List Application (written in Java)

An application to create and store a list of items. You can check
the items off after completion, email items, and keep track
of completed and uncompleted items.


License
=======

Copyright 2014 Daniel Phan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.

You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

You can contact the author at djphan [at] ualberta [dot] ca.

*/

package cs.ualberta.ca.djphan_301a1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;

import cs.ualberta.ca.djphan_301a1data.DataManager;
import cs.ualberta.ca.djphan_301a1data.iDataManager;

public class MainActivity extends Activity {
	private iDataManager datamanager;
	
	public ToDoListController listcontroller = new ToDoListController();
    public Collection<ListItem> listItem = ToDoListController.returnPubList().getList();
    public ArrayList<ListItem> toDoList;
    public ListView listview;
    public ToDoListAdapter toDoListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Data Manager
        datamanager = new DataManager (this);
                
        // Code to populate the list view adapted from StudentPicker example
        listview = (ListView) findViewById(R.id.mainListView);
        toDoList = new ArrayList<ListItem>(listItem);
        toDoListViewAdapter = new ToDoListAdapter(this,toDoList, listcontroller);
        
        listview.setAdapter(toDoListViewAdapter);
        listview.setItemsCanFocus(true);
        
        ToDoListController.returnPubList().addListener(new Listener() {
        	@Override
        	public void update () {
        		toDoList.clear();
        		Collection<ListItem> listItem = ToDoListController.returnPubList().getList();
        		toDoList.addAll(listItem);
        		toDoListViewAdapter.notifyDataSetChanged();
        	}});     
        }

    @Override
	protected void onStart() {
		super.onStart();
		toDoList = datamanager.loadToDoList();
		final ToDoListAdapter toDoListViewAdapter = new ToDoListAdapter(this,toDoList, listcontroller);
        listview.setAdapter(toDoListViewAdapter);
	} 
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
    	switch (item.getItemId()) {

        case R.id.action_archive:
        	openActionArchive();
        	return true;
        	
        case R.id.action_email:
        	openActionEmail();
        	return true;
        	
        case R.id.action_emailarc:
        	openActionArcEmail();
        	return true;
        	
        case R.id.action_stats:
        	openActionStats();
        	return true;

        default:
        	return super.onOptionsItemSelected(item);
	        
        }

    }

	public void openActionArchive() {
		// Provides the UI functions to switch to the Archive Layout Window
    	Toast.makeText(this, "Archive", Toast.LENGTH_SHORT).show();		
    	Intent intent = new Intent(MainActivity.this, ArchiveActivity.class);
		Bundle sBundle = new Bundle();
		sBundle.putSerializable("lcontrol", listcontroller);
		intent.putExtra("bcontrol", sBundle);
    	startActivity(intent);
	}
	
	public void openActionEmail() {
		// Provides the UI functions to switch to the Archive Layout Window
    	Toast.makeText(this, "E-Mail", Toast.LENGTH_SHORT).show();		
    	Intent intent = new Intent(MainActivity.this, EMailActivity.class);
		Bundle sBundle = new Bundle();
		sBundle.putSerializable("lcontrol", listcontroller);
		intent.putExtra("bcontrol", sBundle);
    	startActivity(intent);
	}
	
	public void openActionArcEmail() {
		// Provides the UI functions to switch to the Archive Layout Window
    	Toast.makeText(this, "E-Mail", Toast.LENGTH_SHORT).show();		
    	Intent intent = new Intent(MainActivity.this, EMailArchiveActivity.class);
		Bundle sBundle = new Bundle();
		sBundle.putSerializable("lcontrol", listcontroller);
		intent.putExtra("bcontrol", sBundle);
    	startActivity(intent);
	}

	public void openActionStats() {
		// Provides the UI functions to switch to the Statistics Layout Window
    	Toast.makeText(this, "List Statistics", Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(MainActivity.this, StatsActivity.class);
		Bundle sBundle = new Bundle();
		sBundle.putSerializable("lcontrol", listcontroller);
		intent.putExtra("bcontrol", sBundle);
    	startActivity(intent);
	}
	
	public void addToDoListMain (View v) {
		Toast.makeText(this, "Added Item", Toast.LENGTH_SHORT).show();
		EditText textview = (EditText) findViewById(R.id.add_maintextfield);
		listcontroller.addItem(0, new ListItem (textview.getText().toString(), false, false));
		// Clear The Text Field for next entry
		textview.setText("");
		datamanager.saveList(listItem);
		toDoListViewAdapter.notifyDataSetChanged();
	}
	

}