package society.doscon.com.doscon

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.home_view.*
import java.lang.reflect.Field
import java.util.*


class Home : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.abstracttx -> {
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.eventreg.icegroupindia.com/doscon18/abstract-login.php"))
                startActivity(intent)
            }
            R.id.program -> {
//                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.eventreg.icegroupindia.com/doscon18/abstract-login.php"))
//                startActivity(intent)
                startActivity(Intent(activity!!, Abstract::class.java))
            }
            R.id.registration -> {
//                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://eventreg.icegroupindia.com/doscon18/"))
//                startActivity(intent)
                var prefs: SharedPreferences = activity!!.getSharedPreferences("MY_PREFS_NAME", AppCompatActivity.MODE_PRIVATE);
                var restoredText = prefs.getString("DATA", null);
                if (!TextUtils.isEmpty(restoredText)) {
                    var intent = Intent(activity, TicketDetail::class.java)
                    intent.putExtra("DATA", restoredText)
                    startActivity(intent)
                }else{
                    var intent = Intent(activity, Login::class.java)
                    startActivity(intent)
                }
            }
            R.id.notification -> {

            }

        }
    }

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
    val DELAY_MS: Long = 1000//delay in milliseconds before task is to be executed
    val PERIOD_MS: Long = 4000
    var NUM_PAGES: Int = 2
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed(Runnable {
            var height: Int = parent_cube.height
            var width: Int = parent_cube.width
            val params = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
            params.leftMargin = width / 3 - abstracttx.width
            params.topMargin = height / 2 - abstracttx.height / 2
            abstracttx.layoutParams = params

            val params1 = RelativeLayout.LayoutParams(250, RelativeLayout.LayoutParams.WRAP_CONTENT)
            params1.leftMargin = width / 2 + registration.width / 4
            params1.topMargin = height / 2 - registration.height
            registration.layoutParams = params1

            val params2 = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
            params2.leftMargin = width / 2 - notification.width / 2
            params2.topMargin = height / 4 - abstracttx.height / 2
            notification.layoutParams = params2

            val params3 = RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT)
            params3.leftMargin = width / 2 - program.width / 2
            params3.topMargin = (height / 3) * 2
            program.layoutParams = params3

        }, 200)

        registration.setOnClickListener(this)
        abstracttx.setOnClickListener(this)
        program.setOnClickListener(this)
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
        if (timer == null) {
            timer = Timer() // This will create a new Thread
            timer!!.schedule(object : TimerTask() {
                override fun run() {
                    handler.post(Update)
                }
            }, DELAY_MS, PERIOD_MS)
        }
        try {
            val mScroller: Field
            mScroller = ViewPager::class.java.getDeclaredField("mScroller")
            mScroller.setAccessible(true)
            val scroller = FixedSpeedScroller(carousal.getContext())
            // scroller.setFixedDuration(5000);
            mScroller.set(carousal, scroller)
        } catch (e: NoSuchFieldException) {
        } catch (e: IllegalArgumentException) {
        } catch (e: IllegalAccessException) {
        }

    }

    override fun onPause() {
        super.onPause()

    }

    internal class Carousal(var context: Context, var images: IntArray) : PagerAdapter() {
        lateinit var layoutInflater: LayoutInflater

        init {

            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val itemView = layoutInflater.inflate(R.layout.item, container, false)

            val imageView = itemView.findViewById<ImageView>(R.id.imageView) as ImageView
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