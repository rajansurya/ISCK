package society.doscon.com.doscon

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.header_other.*
import kotlinx.android.synthetic.main.ticket_detail_view.*
import org.json.JSONObject

/**
 * Created by Rajan Gupta on 12-09-2018.
 */
class TicketDetail : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ticket_detail_view)
        cancel.setOnClickListener { this@TicketDetail.finish() }
//        title_name.text = "Registration Detail"
        var myretailer: String? = intent.extras.get("DATA") as? String
        val reader = JSONObject(myretailer).getJSONArray("Data").getJSONObject(0)
        indianstate.text = reader.getString("Name")
        payworldbranch.text = reader.getString("Member Type")
//        payworldbranchcode.text = reader.getString("Sub Member Type")
        bussinessname.text = reader.getString("Mobile No.")
        agentcode.text = reader.getString("Registration ID")
        partycode.text = reader.getString("Email ID")
        loginname.text = reader.getString("Address")
        personal_name.text = reader.getString("City") + "," + reader.getString("State") //+ "," + reader.getString("Country")
        assignmark.text = reader.getString("Pin Code")

    }
}