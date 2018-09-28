package society.doscon.com.doscon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.commitee.*

class Commitee : Fragment() {
    companion object {
        fun newInstance(): Commitee {
            return Commitee()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.commitee, container, false)

        return view;
    }

   lateinit var fiilliste: Array<String>
    lateinit var listimg:ArrayList<String>
    internal lateinit var home_adapter: Home_Adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val displayMetrics = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels
        fiilliste = getResources().getStringArray(R.array.img_arr_commiti);
        home_adapter = Home_Adapter(activity!!.applicationContext, fiilliste.toCollection(ArrayList<String>()), width, height,"commity")
        gridview_cyc?.layoutManager = GridLayoutManager(activity, 2)
        gridview_cyc?.addItemDecoration(SpacesItemDecoration(1))
        gridview_cyc?.setAdapter(home_adapter)

        fiilliste = getResources().getStringArray(R.array.img_arr_member);
        home_adapter = Home_Adapter(activity!!.applicationContext, fiilliste.toCollection(ArrayList<String>()), width, height,"member")

        gridview_cyc_member?.layoutManager = GridLayoutManager(activity, 2)
        gridview_cyc_member?.addItemDecoration(SpacesItemDecoration(1))
        gridview_cyc_member?.setAdapter(home_adapter)
    }
}