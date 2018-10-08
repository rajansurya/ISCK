package society.doscon.com.doscon

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.Window
import org.jetbrains.anko.toast

object  StaticFuc{
    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.getActiveNetworkInfo() as? NetworkInfo;
        if (activeNetwork != null) {
            // connected to the internet
            return if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                true;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to mobile data
                true
            } else {
                false
            }
        } else {
            return false
        }
    }
    fun getProgressDialog(ctx: Context): ProgressDialog {
        val dialog = ProgressDialog(ctx)
        try {

            dialog.setCancelable(false)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.show()
            dialog.setContentView(R.layout.custom_dialog)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return dialog
    }
}