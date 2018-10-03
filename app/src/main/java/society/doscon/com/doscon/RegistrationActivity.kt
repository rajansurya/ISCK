package society.doscon.com.doscon

import android.os.Bundle
import android.support.v4.app.FragmentActivity

class RegistrationActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_view_activity)
        val newFragment = Registration()
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentadd, newFragment, "TAG")
                .disallowAddToBackStack()
                .commit();
    }
}