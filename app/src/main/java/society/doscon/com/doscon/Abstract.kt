package society.doscon.com.doscon

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.first_frgment_view.*
import kotlinx.android.synthetic.main.header_other.*


class Abstract : Activity() {
    companion object {
        fun newInstance(): Abstract {
            return Abstract()
        }
    }

    lateinit var webpagesLinear: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_content)
        title_name.text = "PROGRAM"
        back.setOnClickListener { this@Abstract.finish() }
        webpagesLinear = findViewById(R.id.webpagesLinear)
        webpagesLinear.getSettings().setJavaScriptEnabled(true);
        webpagesLinear.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webpagesLinear.setScrollbarFadingEnabled(true);
        webpagesLinear.getSettings().setDomStorageEnabled(true);
        webpagesLinear.getSettings().setLoadsImagesAutomatically(true);
        webpagesLinear.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        progressbar.visibility = View.VISIBLE
        webpagesLinear.setWebViewClient(AppWebViewClients(progressbar))
        webpagesLinear.loadUrl("http://isckrs.com/meet-welcome.php#abstract");


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