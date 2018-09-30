package society.doscon.com.doscon

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by RDX on 30-09-2018.
 */
class Menuitem(var context: Context) : RecyclerView.Adapter<Menuitem.ViewHolder> (){
    lateinit var ta:Array<String>
    init {
        ta = context.getResources().getStringArray(R.array.nameimg);
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.grid_item?.text=ta[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context)
                .inflate(R.layout.menu_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ta.size
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var grid_item: TextView? = null
//        var home_txt: TextView? = null
//        var home_icon: ImageView? = null

        init {
            grid_item = view.findViewById(R.id.grid_item)
//            home_txt = view.findViewById(R.id.home_txt)
//            home_icon = view.findViewById(R.id.home_icon)
        }
    }
}