package com.mbrowser.common;

import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.alibaba.fastjson.JSONObject;
import com.mbrowser.MBrowserModule;


public class MyWebViewClient extends WebViewClient {
    private static MyWebViewClient myWebViewClient = new MyWebViewClient();
    private static Object obj = new Object();
    public static MyWebViewClient getInstance(){
        return myWebViewClient;
    }
    public static void setMyWebViewClient(MyWebViewClient myWebViewClient){
        MyWebViewClient.myWebViewClient = myWebViewClient;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        return false;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
    {
        return false;
    }
}
