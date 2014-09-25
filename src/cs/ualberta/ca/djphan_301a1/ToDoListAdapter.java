package cs.ualberta.ca.djphan_301a1;

import java.util.ArrayList;
import java.util.Collection;

import android.view.View.OnClickListener;
import android.content.Context;
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

public class ToDoListAdapter extends ArrayAdapter<ListItem> {
	protected ToDoList todoListObject;
	protected Context context;
	protected LayoutInflater inflater;
	
	public ToDoListAdapter(Context context,  ArrayList<ListItem> listItem) {
		super(context, R.layout.todolist_item, R.id.addListTextMain, listItem);
		this.todoListObject = todoListObject;
		this.context = context;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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
	public View getView(int position, View convertView, ViewGroup parent) {
		final ListItem item = (ListItem) this.getItem(position);
		TextView listBody;
		CheckBox checkBox;
		
	     	     
	     if (convertView == null) {
	         convertView = (RelativeLayout) inflater.inflate(R.layout.todolist_item, null);
	          
	 	     listBody = (TextView) convertView.findViewById(R.id.addListTextMain);
		     checkBox = (CheckBox) convertView.findViewById(R.id.CheckBox);
		     
		     convertView.setTag ( new ViewHolder(listBody, checkBox) );
		     
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
	         public void onClick(View view) {	
	    		 Toast.makeText(context, "This item is: " + item.getListItem(), Toast.LENGTH_SHORT).show();
	        		
	        	}

	        });
	        
	     checkBox.setTag(item);
	     checkBox.setChecked(item.getCheckItem());
	     listBody.setText(item.getListItem());
	     
	     return convertView;
	}




	


	

}
