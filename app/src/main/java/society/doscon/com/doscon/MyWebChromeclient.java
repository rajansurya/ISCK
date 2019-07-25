package society.doscon.com.doscon;

import android.content.Intent;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//class MyWebChromeclient extends WebChromeClient {
//
//
//    @Override
//    public boolean onCreateWindow(WebView view, boolean isDialog,
//                                  boolean isUserGesture, Message resultMsg) {
//
//        WebView newWebView = new WebView(WebViewActivity2.this);
//        view.addView(newWebView);
//        WebView.WebViewTransport transport = (WebView.WebViewTransport) resultMsg.obj;
//        transport.setWebView(newWebView);
//        resultMsg.sendToTarget();
//
//        newWebView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
//                browserIntent.setData(Uri.parse(url));
//                startActivity(browserIntent);
//                return true;
//            }
//        });
//        return true;
//    }
//}
