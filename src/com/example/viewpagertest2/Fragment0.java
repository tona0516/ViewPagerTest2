package com.example.viewpagertest2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Fragment0 extends Fragment {

	private WebView mWebView;
	private Bundle mWebViewBundle;
	private String pageTitle;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment0, null);
		mWebView = (WebView) v.findViewById(R.id.webview);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.setWebViewClient(new WebViewClient(){
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				setPageTitle(mWebView.getTitle());
			}
		});
		mWebView.loadUrl("https://www.google.co.jp");
		// mWebView.onScrollChanged(mWebView.getScrollX(),
		// mWebView.getScrollY(),mWebView.getScrollX(),mWebView.getScrollY());
		return v;
	}

	@Override
	public void onPause() {
		super.onPause();
		mWebViewBundle = new Bundle();
		mWebView.saveState(mWebViewBundle);
	}

	/**
	 * Restore the state of the webview
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if (mWebViewBundle != null) {
			mWebView.restoreState(mWebViewBundle);
		}
	}

	public String getPageTitle() {
		return pageTitle;
	}

	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
}
