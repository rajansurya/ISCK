package society.doscon.com.doscon

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.header_other.*

/**
 * Created by RDX on 07-10-2018.
 */
class Accomodation : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.accomodation)
        title_name.text = "ACCOMODATION"
        back.setOnClickListener { this@Accomodation.finish() }
    }

}