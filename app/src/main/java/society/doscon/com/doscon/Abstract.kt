package society.doscon.com.doscon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.annotation.TargetApi
import android.graphics.Bitmap
import android.widget.Toast
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.first_frgment_view.*
import android.widget.ProgressBar




class Abstract : Fragment() {
    companion object {
        fun newInstance(): Abstract {
            return Abstract()
        }
    }
    lateinit var webpagesLinear: WebView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.first_frgment_view, container, false)
        webpagesLinear=view.findViewById(R.id.webpagesLinear)
        webpagesLinear.getSettings().setJavaScriptEnabled(true);
        webpagesLinear.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webpagesLinear.setScrollbarFadingEnabled(true);
        webpagesLinear.getSettings().setDomStorageEnabled(true);
        webpagesLinear.getSettings().setLoadsImagesAutomatically(true);
        webpagesLinear.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);


        return view;
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressbar.visibility=View.VISIBLE
        webpagesLinear.setWebViewClient(AppWebViewClients(progressbar))
        webpagesLinear.loadUrl("http://www.eventreg.icegroupindia.com/doscon18/abstract-login.php");
    }
    inner class AppWebViewClients(private val progressBar: ProgressBar) : WebViewClient() {

        init {
            progressBar.visibility = View.VISIBLE
        }

        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            // TODO Auto-generated method stub
            view.loadUrl(url)
            return true
        }

        override fun onPageFinished(view: WebView, url: String) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url)
            progressBar.visibility = View.GONE
        }
    }
}