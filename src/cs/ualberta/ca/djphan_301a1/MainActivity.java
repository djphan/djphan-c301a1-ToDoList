package cs.ualberta.ca.djphan_301a1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.io.FileInputStream;
import java.util.ArrayList;





public class MainActivity extends Activity {
	
	private ArrayList<ListItem> listItem;
	private ArrayAdapter<ListItem> listItemViewAdapter;
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
