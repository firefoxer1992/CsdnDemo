package com.example.csdndemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends Activity{
	private ListView itemListView;
    String items[]={"Ezreal","Riven","Vayne","Arli","Jinx","Lux"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		itemListView=(ListView)findViewById(R.id.second_activity_list);
		itemListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
  
}
