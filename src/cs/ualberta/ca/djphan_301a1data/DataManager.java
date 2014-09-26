package cs.ualberta.ca.djphan_301a1data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cs.ualberta.ca.djphan_301a1.ListItem;

import android.content.Context;
import android.util.Log;

public class DataManager implements iDataManager{
	private static final String FILENAME = "file.sav";
	
	private Context context;
	
	public DataManager(Context context) {
		this.context = context;
	}
	
	public ArrayList<ListItem> loadToDoList() {
		ArrayList<ListItem> savelist = new ArrayList<ListItem>();

		try {
			FileInputStream fis = context.openFileInput(FILENAME);
			ObjectInputStream ois = new ObjectInputStream(fis);

			savelist = (ArrayList<ListItem>) ois.readObject();

		} catch (Exception e) {
			Log.i("LonelyTwitter", "Error casting");
			e.printStackTrace();
		} 

		return savelist;
	}
	
	public void saveList(Collection<ListItem> savelist) {
		try {
			FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(savelist);
			fos.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}



}
