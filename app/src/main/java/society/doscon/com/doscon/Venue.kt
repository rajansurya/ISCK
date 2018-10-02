package society.doscon.com.doscon

import android.app.Activity
import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.header_other.*
import kotlinx.android.synthetic.main.venue.*

/**
 * Created by RDX on 02-10-2018.
 */
class Venue : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.venue)
        venue.text = Html.fromHtml(resources.getString(R.string.venue))
        title_name.text="VENUE"
        back.setOnClickListener { this@Venue.finish() }
    }
}