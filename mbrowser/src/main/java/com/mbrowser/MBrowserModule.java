package com.mbrowser;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;

import com.alibaba.fastjson.JSONObject;
import com.mbrowser.activity.BrowserActivity;
import com.mbrowser.common.MyWebViewClient;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.bridge.WXBridgeManager;

public class MBrowserModule  extends WXSDKEngine.DestroyableModule{
    public static BrowserActivity browserActivity;
    @JSMethod(uiThread = true)
    public void open(JSONObject options, JSCallback jsCallback){

        String url = options.getString("url");
        Object initCookieObj = options.get("initCookie");
        boolean initCookie = false;
        try{
            initCookie = Boolean.parseBoolean(initCookieObj.toString());
        }catch (Exception e){

        }
        System.out.println(url);
        Context context = this.mWXSDKInstance.getContext();

        Intent intent = new Intent(context, BrowserActivity.class);
        intent.putExtra("url",url);
        intent.putExtra("initCookie",initCookie);
        MyWebViewClient.setMyWebViewClient(new MyWebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return false;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request)
            {
                return false;
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                String cookie =  CookieManager.getInstance().getCookie(url);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("url",url);
                jsonObject.put("cookie",cookie);
                MBrowserModule mBrowserModule = MBrowserModule.this;
                MBrowserModule.this.mWXSDKInstance.fireModuleEvent("pageChange",mBrowserModule,jsonObject);

            }
        });
        context.startActivity(intent);
    }

    @JSMethod(uiThread = true)
    public void close(){
        if(browserActivity!=null){
            browserActivity.finish();
        }
    }

    @Override
    public void destroy() {

    }
}
