package EmailHandler;

import java.util.ArrayList;

import cs.ualberta.ca.djphan_301a1.ListItem;
import android.content.Context;
import android.content.Intent;
import android.util.SparseBooleanArray;
import android.widget.Toast;

public class EmailHandler {
	
	// Code adapted from stack overflow method: http://stackoverflow.com/questions/2197741/how-can-i-send-emails-from-my-android-application
	private Context context;
	
	public EmailHandler(Context context){
		this.context = context;
	}
	
	public void sendEmail(String emailString){
		// Email Function Create Intent using Native eMail application
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("message/rfc822");
		intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
		intent.putExtra(Intent.EXTRA_SUBJECT, "ToDos List");
		intent.putExtra(Intent.EXTRA_TEXT, emailString);
		
		try {
			// Catch errors if app not found to not crash
			context.startActivity(Intent.createChooser(intent, "Send Email"));
		} catch (android.content.ActivityNotFoundException ex) {
		    Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
		}

	}
	
	public void emailArrayList(ArrayList<ListItem> itemsList){
		// Method used to parse through our ArrayList of ListItems
		// and format them into a string for the email
		
		String formattedEmailString = "";
		
		for (int index = 0; index< itemsList.size(); index++){
           ListItem toDoItem = itemsList.get(index);
	       formattedEmailString += toDoItem.outputEmailString() + '\n';
		}
	   	
		Toast.makeText(context, "Email Sent.", Toast.LENGTH_SHORT).show();
		sendEmail(formattedEmailString);
		
		}
	
	public void emailSelectArrayList(SparseBooleanArray selection, ArrayList<ListItem> itemsList){
		// Method used to parse through our ArrayList of ListItems
		// and format them into a string for the email
		// mapped to a BooleanArray of select items
		
		String formattedEmailString = "";
		
		for (int index = 0; index< itemsList.size(); index++){	
			if(selection.valueAt(index)) {
	           ListItem toDoItem = itemsList.get(index);
		       formattedEmailString += toDoItem.outputEmailString() + '\n';
		       
			}
	   	
		Toast.makeText(context, "Email Sent. Selection", Toast.LENGTH_SHORT).show();
		sendEmail(formattedEmailString);
		
		}
	}
		

}

	

	


