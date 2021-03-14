package com.womensafety.SafeStree;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
EditText e1,e2;
Button b1,b2;
String d1,d2;
SQLiteDatabase db;
ArrayList<String> al1,al2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		e1=(EditText) findViewById(R.id.editText1);
		e2=(EditText) findViewById(R.id.editText2);
		al1=new ArrayList<String>();
		al2=new ArrayList<String>();
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it1=getIntent();
				d1=e1.getText().toString();
				d2=e2.getText().toString();
				db=openOrCreateDatabase("Call",MODE_PRIVATE, null);
				db.execSQL("create table if not exists contacts(name varchar(20),phoneno varchar(10))");
				db.execSQL("insert into contacts values('"+d1+"','"+d2+"')");
				Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_LONG).show();
				Intent it=new Intent(MainActivity.this,MainActivity.class);
				startActivity(it);
			}
		});
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				db=openOrCreateDatabase("Call", MODE_PRIVATE, null);
				Cursor c=db.rawQuery("select * from contacts", null);
				c.moveToFirst();
				if(c!=null)
				{
					do {
						int i=c.getColumnIndex("name");
						int j=c.getColumnIndex("phoneno");
						String da1=c.getString(i);
						String da2=c.getString(j);
						al1.add(da1);
						al2.add(da2);
						
					}while(c.moveToNext());
					Intent it=new Intent(MainActivity.this,List.class);
					it.putStringArrayListExtra("key", al1);
					it.putStringArrayListExtra("pno", al2);
					startActivity(it);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
