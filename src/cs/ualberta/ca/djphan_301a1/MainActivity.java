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
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.FileInputStream;
import java.util.ArrayList;

public class MainActivity extends Activity {
	
	private ArrayList<ListItem> toDoList;
	private ArrayAdapter<ListItem> toDoListViewAdapter;
	private ListView oldList;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        case R.id.action_add:
        	return true;
        
        case R.id.action_archive:
        	return true;
        	
        case R.id.action_email:
        	return true;
        	
        case R.id.action_stats:
        	return true;
        	
        case R.id.action_settings:
        	return true;
	    
        default:
        	return super.onOptionsItemSelected(item);
	        
        }

    }
}
