package com.womensafety.SafeStree;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Call extends Activity {
Button b;
TextView t;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_call);
		b=(Button) findViewById(R.id.button1);
		t=(TextView) findViewById(R.id.textView1);
		Intent it=getIntent();
		final String data=it.getStringExtra("num");
		t.setText("Phone Number : "+data);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+data));
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_call, menu);
		return true;
	}

}
