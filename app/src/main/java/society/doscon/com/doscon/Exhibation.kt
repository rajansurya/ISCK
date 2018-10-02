package society.doscon.com.doscon

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.exhibition.*
import kotlinx.android.synthetic.main.header_other.*

/**
 * Created by RDX on 02-10-2018.
 */
class Exhibation : Activity(),View.OnClickListener {
    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.exhilayout->{
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://doscon18.org/images/exhibition-layout.pdf"))
                startActivity(intent)
            }
            R.id.exhiletter->{
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://doscon18.org/images/exhibitor-letter-with-tariff.pdf"))
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.exhibition)
        title_name.text="EXHIBATION"
        back.setOnClickListener { this@Exhibation.finish() }
        exhilayout.setOnClickListener(this)
        exhiletter.setOnClickListener(this)
    }
}