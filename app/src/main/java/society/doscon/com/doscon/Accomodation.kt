package society.doscon.com.doscon

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.accomodation.*
import kotlinx.android.synthetic.main.first_frgment_view.*
import kotlinx.android.synthetic.main.header_other.*

/**
 * Created by RDX on 07-10-2018.
 */
class Accomodation : Activity() {
    lateinit var webpagesLinear: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.accomodation)

        back.setOnClickListener { this@Accomodation.finish() }
        webpagesLinear = findViewById(R.id.webpagesLinear)
        webpagesLinear.getSettings().setJavaScriptEnabled(true);
        webpagesLinear.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webpagesLinear.setScrollbarFadingEnabled(true);
        webpagesLinear.getSettings().setDomStorageEnabled(true);
        webpagesLinear.getSettings().setLoadsImagesAutomatically(true);
        webpagesLinear.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        progressbar.visibility = View.VISIBLE
        webpagesLinear.setWebViewClient(AppWebViewClients(progressbar))
        if (intent.getStringExtra("which").equals("bearer")){
            webpagesLinear.loadUrl("https://www.glaucomasociety.in/article-3-current-office-bearers.php");
            title_name.text = "OFFICE BEARERS"
            }
        else{
            webpagesLinear.loadUrl("https://www.glaucomasociety.in/membership-registration.php");
            title_name.text = "JOIN GSI"
            }
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