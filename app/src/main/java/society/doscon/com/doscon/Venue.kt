package society.doscon.com.doscon

import android.app.Activity
import android.os.Bundle
import android.text.Html
import android.webkit.WebView
import kotlinx.android.synthetic.main.header_other.*
import kotlinx.android.synthetic.main.venue.*

/**
 * Created by RDX on 02-10-2018.
 */
class Venue : Activity() {
    lateinit var webpagesLinear: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.venue)
        webpagesLinear=findViewById(R.id.venue)
        webpagesLinear.getSettings().setJavaScriptEnabled(true);
        webpagesLinear.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webpagesLinear.setScrollbarFadingEnabled(true);
        webpagesLinear.getSettings().setDomStorageEnabled(true);
        webpagesLinear.getSettings().setLoadsImagesAutomatically(true);
        webpagesLinear.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webpagesLinear.loadData( resources.getString(R.string.venue), "text/html; charset=utf-8", "utf-8");
        title_name.text="VENUE"
        back.setOnClickListener { this@Venue.finish() }
    }
}