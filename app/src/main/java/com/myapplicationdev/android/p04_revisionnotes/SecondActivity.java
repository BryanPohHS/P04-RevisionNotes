package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note> note;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		note = new ArrayList<Note>();

		lv = findViewById(R.id.lv);

		aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, note);
		lv.setAdapter(aa);

		// Create the DBHelper object, passing in the
		// activity's Context
		DBHelper db = new DBHelper(SecondActivity.this);

		// Insert a task
		ArrayList<Note> data = db.getAllNotes();
		db.close();

		String txt = "";
		for (int i = 0; i < data.size(); i++) {
			note.add(new Note(data.get(i).getId(), data.get(i).getNoteContent(), data.get(i).getStars()));

			Log.d("Database Content", i +". "+data.get(i));
			txt += i + ". " + data.get(i) + "\n";
		}

	}


}
