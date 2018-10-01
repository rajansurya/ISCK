package society.doscon.com.doscon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Home :Fragment(){
    companion object {
        fun newInstance(): Home {
            return Home()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view=inflater.inflate(R.layout.home_view,container,false)
        return view
    }
}