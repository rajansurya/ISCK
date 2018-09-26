package society.doscon.com.doscon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Invitation : Fragment(){
    companion  object {
    fun newInstance(): Invitation {
        return Invitation()
    }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.first_frgment_view, container, false);
    }
}