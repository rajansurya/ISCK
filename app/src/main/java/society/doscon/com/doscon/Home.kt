package society.doscon.com.doscon

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.home_view.*
import java.util.*


class Home : Fragment() {
    companion object {
        fun newInstance(): Home {
            return Home()
        }
    }

    var images: IntArray = intArrayOf(R.drawable.image_1, R.drawable.image_4)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.home_view, container, false)
        return view
    }

    var currentPage = 0
    var timer: Timer? = null
    val DELAY_MS: Long = 500//delay in milliseconds before task is to be executed
    val PERIOD_MS: Long = 3000
    var NUM_PAGES: Int = 2
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed(Runnable {
            var height: Int = parent_cube.height
            var width: Int = parent_cube.width
            val params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT )
            params.leftMargin=width / 2 - 200
            params.topMargin=height/2-abstracttx.height/2
            abstracttx.layoutParams = params

        },200)


        var adpter = Carousal(context!!, images)
        carousal.adapter = adpter
        val handler = Handler()
        val Update = Runnable {
            if (currentPage == NUM_PAGES) {
                currentPage = 0
            }
            if (carousal != null)
                carousal.setCurrentItem(currentPage++, true)
        }

        timer = Timer() // This will create a new Thread
        timer!!.schedule(object : TimerTask() {
            override fun run() {
                handler.post(Update)
            }
        }, DELAY_MS, PERIOD_MS)
    }

    override fun onPause() {
        super.onPause()
        timer=null
    }
    internal class Carousal(var context: Context, var images: IntArray) : PagerAdapter() {
        lateinit var layoutInflater: LayoutInflater

        init {

            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val itemView = layoutInflater.inflate(R.layout.item, container, false)

            val imageView = itemView.findViewById(R.id.imageView) as ImageView
            imageView.setImageResource(images[position])

            container.addView(itemView)
            return itemView
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object` as ImageView
        }

        override fun getCount(): Int {
            return images.size
        }

    }
}