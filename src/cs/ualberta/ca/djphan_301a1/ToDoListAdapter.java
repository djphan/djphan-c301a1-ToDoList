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
	protected MainActivity context;
	protected LayoutInflater inflater;
	public ToDoListController listcontroller;
		
	public ToDoListAdapter(MainActivity context, ArrayList<ListItem> listItem, ToDoListController listcontroller) {
		super(context, R.layout.todolist_item, R.id.addListTextMain, listItem);
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.todoListObject = todoListObject;
		this.context = context;
		this.listcontroller = listcontroller;

	}
	
	private static class ViewHolder {

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
		             /* Validate with Toast that value is changed
		             if( item.getCheckItem() == true ){
		            	 Toast.makeText(context, "TRUE", Toast.LENGTH_SHORT).show();
			            } else {
			            	Toast.makeText(context, "NOT TRUE", Toast.LENGTH_SHORT).show();
			            }
			            */
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
				AlertDialog.Builder alertdialogbuilderarc = new AlertDialog.Builder(context);
				alertdialogbuilderarc.setMessage("Archive " + item.getListItem() +" ?");
				alertdialogbuilderarc.setCancelable(true);
				alertdialogbuilderarc.setPositiveButton("Archive", new DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						item.setCheckArchive(true);
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
