package cs.ualberta.ca.djphan_301a1;

import java.util.ArrayList;
import java.util.Collection;

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

public class ToDoListAdapter extends ArrayAdapter<ListItem> {;
	protected ToDoList todoListObject;
	protected Context context;
	protected LayoutInflater inflater;
	public ToDoListController listcontroller; // Access information to display
		
	public ToDoListAdapter(Context context, ArrayList<ListItem> listItem, ToDoListController listcontroller) {
		// Pass the context and controller to handle the multiple threads of Arrays
		// for the views
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
	          
	         // Pull information set in the object
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

	     // Get rid of click priority of check boxes.
	     convertView.setClickable(true);
	     convertView.setFocusable(true);
	     
		 convertView.setOnClickListener(new OnClickListener() {
			 // Information adapted from:
			 // Onclick Android Dev(http://developer.android.com/reference/android/view/View.OnClickListener.html)
			 // AlertDialog Android Dev(http://developer.android.com/reference/android/app/AlertDialog.html)
			@Override
			public void onClick(View v) {
				AlertDialog.Builder alertdialogbuilderarc = new AlertDialog.Builder(context);
				alertdialogbuilderarc.setMessage("Set " + item.getListItem() +" archive's setting ?");
				alertdialogbuilderarc.setCancelable(true);
				alertdialogbuilderarc.setPositiveButton("Accept", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(context, "Move to Archive from Main or Unarchived from Archive", Toast.LENGTH_SHORT).show();
						item.setCheckArchive(!item.getCheckArchive());
						listcontroller.updateTrackingLists();
						}
					
					});
					alertdialogbuilderarc.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
						@Override
						public void onClick(DialogInterface dialog, int which) {}
	
					});
	
					alertdialogbuilderarc.show();

				}

	  });     
		 // Information adapted from:
		 // OnLongclick Android Dev(http://developer.android.com/reference/android/view/View.OnLongClickListener.html)
		 // AlertDialog Android Dev(http://developer.android.com/reference/android/app/AlertDialog.html)
	     convertView.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(context);
				alertdialogbuilder.setMessage("Delete " + item.getListItem() +" ?");
				alertdialogbuilder.setCancelable(true);
				alertdialogbuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						ToDoListController listcontroller = new ToDoListController();
						listcontroller.removeItem(0,item);
						Toast.makeText(context, "Deleted Item", Toast.LENGTH_SHORT).show();
					}

				});
				alertdialogbuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}

				});

				alertdialogbuilder.show();
				return false;
			}	        	
	   
	        });
	      
	     checkBox.setTag(item);
	     checkBox.setChecked(item.getCheckItem());
	     listBody.setText(item.getListItem());
	     
	     return convertView;
	}
	

}
