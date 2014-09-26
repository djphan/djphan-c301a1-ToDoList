package EmailHandler;

import java.util.ArrayList;
import java.util.Collection;

import cs.ualberta.ca.djphan_301a1.ListItem;
import cs.ualberta.ca.djphan_301a1.R;
import cs.ualberta.ca.djphan_301a1.ToDoList;
import cs.ualberta.ca.djphan_301a1.ToDoListController;

import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class EmailAdapter extends ArrayAdapter<ListItem> {;

	protected ToDoList todoListObject;
	protected Context context;
	protected LayoutInflater inflater;
	public ToDoListController listcontroller;
		
	public EmailAdapter(Context context, ArrayList<ListItem> listItem, ToDoListController listcontroller) {
		super(context, R.layout.todolist_item, R.id.addListTextMain, listItem);
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.todoListObject = todoListObject;
		this.context = context;
		this.listcontroller = listcontroller;

	}
	
	private static class ViewHolder {
		// Code snip taken from Vogella Tutorials
		// (http://www.vogella.com/tutorials/AndroidListView/article.html)
		private TextView listBody;
		private CheckBox checkBox;
		
		public ViewHolder(TextView listBody, CheckBox checkBox) {
			this.listBody = listBody;
			this.checkBox = checkBox;
		}
		
		public TextView getListBody() {
			return listBody;
		}

		public void setListBody(TextView listBody) {
			this.listBody = listBody;
		}

		public CheckBox getCheckBox() {
			return checkBox;
		}

		public void setCheckBox(CheckBox checkBox) {
			this.checkBox = checkBox;
		}
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// Code snip taken from Vogella Tutorials
		// (http://www.vogella.com/tutorials/AndroidListView/article.html)
		final ListItem item = (ListItem) getItem(position);
		TextView listBody;
		CheckBox checkBox;
		 	     
	     if (convertView == null) {
	         convertView = (RelativeLayout) inflater.inflate(R.layout.todolist_item, null);
	          
	 	     listBody = (TextView) convertView.findViewById(R.id.addListTextMain);
		     checkBox = (CheckBox) convertView.findViewById(R.id.CheckBox);
		     
		     convertView.setTag (new ViewHolder(listBody, checkBox) );
		  
		     checkBox.setOnClickListener( new View.OnClickListener() {  
		    	 public void onClick(View view) {  
		    		 CheckBox checkbox = (CheckBox) view ;  
		             ListItem item = (ListItem) checkbox.getTag();  
		             item.setCheckItem(checkbox.isChecked());  
		             }	     
		     });
	    }
		     else {
		    	 ViewHolder viewholder = (ViewHolder) convertView.getTag();
		    	 checkBox = viewholder.getCheckBox();
		    	 listBody = viewholder.getListBody();
		     }

	     convertView.setClickable(true);
	     convertView.setFocusable(true);
	     
		 convertView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Implement Selection Here (?)
			}

	  });     
	      
	     checkBox.setTag(item);
	     checkBox.setChecked(item.getCheckItem());
	     listBody.setText(item.getListItem());
	     
	     return convertView;
	}

	

}
