package cs.ualberta.ca.djphan_301a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ToDoListAdapter extends ArrayAdapter<String>{
	// Custom Adapter required to populate the ListView. This adapter contains
	// the checked box element with an edit text field to allow 
	// for the user to edit their ListItem
	
	private final Context context;
	private final String[] listStringValues;
	
	
	public ToDoListAdapter(Context context, String[] listStringValues) {
		// Figure out which R.Layout value to use
		super(context, R.layout.activity_main, listStringValues);
		this.context = context;
		this.listStringValues = listStringValues;
	}

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View listView = inflater.inflate(R.layout.activity_main, parent, false);
	   // ListView listView = (ListView) listView.findViewById(R.id.label);
	    //textView.setText(values[position]);
	    // change the icon for Windows and iPhone
	   // String s = values[position];

	    return listView;
	  }
		

	

}
