package com.example.csdndemo;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InfoAdapter extends ArrayAdapter<ItemInfoBean>{
	private int resourceId;

	public InfoAdapter(Context context, int resourceId, List<ItemInfoBean> objects) {
		super(context, resourceId, objects);
		// TODO Auto-generated constructor stub
		this.resourceId=resourceId;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ItemInfoBean info=getItem(position);
		//通过上下文加载布局,并由resouceId获取视图
		View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
		ImageView imageView=(ImageView)view.findViewById(R.id.image);
		TextView textView=(TextView)view.findViewById(R.id.text);
		imageView.setImageResource(info.getImageId());
		textView.setText(info.getText());

		return view;
	}






}