package society.doscon.com.doscon

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

/**
 * Created by RDX on 02-10-2018.
 */
class Splash : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_view)
        Handler().postDelayed(object : Runnable {
            override fun run() {
                startActivity(Intent(this@Splash, MainActivity::class.java))
                this@Splash.finish()
            }

        }, 2000)
    }
}