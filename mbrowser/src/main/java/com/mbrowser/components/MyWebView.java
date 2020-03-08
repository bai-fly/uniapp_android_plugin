//package com.mbrowser.components;
//
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.widget.TextView;
//
//import com.mbrowser.common.MyWebViewClient;
//import com.taobao.weex.WXSDKInstance;
//import com.taobao.weex.ui.action.BasicComponentData;
//import com.taobao.weex.ui.component.WXComponent;
//import com.taobao.weex.ui.component.WXComponentProp;
//import com.taobao.weex.ui.component.WXVContainer;
//
//public class MyWebView extends WXComponent<WebView> {
//
//    private String url;
//
//    public MyWebView(WXSDKInstance instance, WXVContainer parent, String instanceId, boolean isLazy, BasicComponentData basicComponentData) {
//        super(instance, parent, instanceId, isLazy, basicComponentData);
//    }
//    @Override
//    protected WebView initComponentHostView(@NonNull Context context) {
//        WebView webView = new WebView(context);
//        WebSettings mWebSettings = webView.getSettings();
//
//        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
//        mWebSettings.setJavaScriptEnabled(true);//是否允许JavaScript脚本运行，默认为false。设置true时，会提醒可能造成XSS漏洞
//        mWebSettings.setSupportZoom(true);//是否可以缩放，默认true
//        mWebSettings.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
//        mWebSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
//        mWebSettings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
//        mWebSettings.setAppCacheEnabled(true);//是否使用缓存
//        mWebSettings.setDomStorageEnabled(true);//开启本地DOM存储
//        mWebSettings.setLoadsImagesAutomatically(true); // 加载图片
//        //如果不设置WebViewClient，请求会跳转系统浏览器
//        webView.setWebViewClient(new MyWebViewClient(){
//
//        });
//        return webView;
//    }
//    @WXComponentProp(name = "url")
//    public void setUrl(String url) {
//        this.url = url;
//    }
//}
