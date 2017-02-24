package com.example.csdndemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class LanguageFragment extends Fragment{
	private WebView mWebView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment_language, container,false);
		mWebView=(WebView)view.findViewById(R.id.web_language);
		mWebView.setWebViewClient(new WebViewClient(){
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// 根据传入的参数再去加载新的网页
				view.loadUrl(url);
				// 表示当前WebView可以处理打开新网页的请求，不用借助系统浏览器
				return true;
			}
		});
		mWebView.loadUrl("http://bbs.csdn.net/forums/J2SE");
		return view;
	}

}
