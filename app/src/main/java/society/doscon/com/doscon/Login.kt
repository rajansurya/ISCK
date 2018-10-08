package society.doscon.com.doscon

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import kotlinx.android.synthetic.main.login_view.*
import org.jetbrains.anko.toast
import org.json.JSONObject

class Login : Activity(), View.OnClickListener, SignUpAPICall.CallBackToClass {
    override fun returnDataToClass(tag: String?, data: String?) {
        println(data)
        when (tag) {
            "OAUTHTOKEN" -> {
                try {
                    val reader = JSONObject(data)
                    if (reader.has("status_api")) {
                        var status_api = reader.getString("status_api")
                        if (status_api.equals("true")) {
                            val requestJson = JSONObject()
                            requestJson.put("registrationId", etUserName.text)
                            val URL = "http://eventreg.icegroupindia.com/doscon18/api/reg-dos.php"
                            SignUpAPICall(URL, 0, "REGISTRATION", this@Login, this@Login).execute(requestJson)
                        } else {
                            toast(reader.getString("status_msg"))
                        }
                    }
                } catch (E: Exception) {
                    E.printStackTrace()
                }
            }
            "REGISTRATION" -> {
                var intent = Intent(this, RegistrationView::class.java)
                intent.putExtra("DATA", data)
                startActivity(intent)
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_loginbtn -> {
                println("clicked  sdfsdfsdfsdfsdfsdfsdf")
                if (validation()) {
                    val requestJson = JSONObject()
                    requestJson.put("uemail", etUserName.text)
                    requestJson.put("umobile", etPassword.text)
                    val URL = "http://eventreg.icegroupindia.com/doscon18/api/login-dos.php"
                    SignUpAPICall(URL, 0, "OAUTHTOKEN", this@Login, this@Login).execute(requestJson)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_view)
        tv_loginbtn.setOnClickListener(this)
    }

    fun validation(): Boolean {
        if (TextUtils.isEmpty(etUserName.text)) {
            usererror.setError("Please enter user name")
            return false
        } else if (TextUtils.isEmpty(etPassword.text)) {
            usererror.error = null
            etPassworderror.setError("Please enter password")
            return false
        } else {
            usererror.error = null
            etPassworderror.error = null
            return true
        }
    }
}