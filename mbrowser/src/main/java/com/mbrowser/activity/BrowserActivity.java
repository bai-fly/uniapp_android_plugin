package com.mbrowser.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mbrowser.MBrowserModule;
import com.mbrowser.R;
import com.mbrowser.common.MyWebViewClient;

public class BrowserActivity extends Activity {
    static WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MBrowserModule.browserActivity = this;
           requestWindowFeature(Window.FEATURE_NO_TITLE);
       // setContentView(R.layout.activity_browser);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


//        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
//        if(actionBar != null){
//            actionBar.setHomeButtonEnabled(true);
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        webView = new WebView(this);
        WebSettings mWebSettings = webView.getSettings();

        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        mWebSettings.setJavaScriptEnabled(true);//是否允许JavaScript脚本运行，默认为false。设置true时，会提醒可能造成XSS漏洞
        mWebSettings.setSupportZoom(true);//是否可以缩放，默认true
        mWebSettings.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        mWebSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        mWebSettings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        mWebSettings.setAppCacheEnabled(true);//是否使用缓存
        mWebSettings.setDomStorageEnabled(true);//开启本地DOM存储
        mWebSettings.setLoadsImagesAutomatically(true); // 加载图片


        //如果不设置WebViewClient，请求会跳转系统浏览器
        webView.setWebViewClient(MyWebViewClient.getInstance());


        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
        webView.setLayoutParams(layoutParams);
        setContentView(webView);
        String url = this.getIntent().getStringExtra("url");
        Boolean initCookie = this.getIntent().getBooleanExtra("initCookie",false);
        if(initCookie){
            CookieManager.getInstance().removeAllCookie();
        }
        webView.loadUrl(url);
    }

    public void initWebView(){

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}