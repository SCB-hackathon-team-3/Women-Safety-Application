package com.womensafety.SafeStree;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class List extends Activity {
ListView l;
ArrayList<String> al1,al2;
ArrayAdapter<String> ad;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		l=(ListView) findViewById(R.id.listView1);
		al1=new ArrayList<String>();
		al2=new ArrayList<String>();
		
		Intent it=getIntent();
		al1=it.getStringArrayListExtra("key");
		al2=it.getStringArrayListExtra("pno");
		ad=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, al1);
		l.setAdapter(ad);
		
		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String data=(String)l.getItemAtPosition(arg2);
				int index=al1.indexOf(data);
				Intent it1=new Intent(List.this,Call.class);
				it1.putExtra("num", al2.get(index));
				startActivity(it1);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_list, menu);
		return true;
	}

}
