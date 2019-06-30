package society.doscon.com.doscon

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.header_view.*

class MainActivity : AppCompatActivity(), View.OnClickListener, Menuitem.menuckick {
    public  fun onClickitem(view: View){
        when (view?.id) {
            R.id.officebear -> {
                startActivity(Intent(this, Commitee::class.java))
            }
            R.id.officebear2 -> {
                startActivity(Intent(this, RegistrationActivity::class.java))
            }
            R.id.officebear3 -> {
                startActivity(Intent(this, Highlight::class.java))
            }
            R.id.officebear4 -> {
                startActivity(Intent(this, Abstract::class.java))
            }
            R.id.officebear5 -> {

            }
            R.id.officebear6 -> {
                startActivity(Intent(this, Venue::class.java))
            }

        }
    }

    override fun menuClick(position: Int) {
        drawer_layout.closeDrawer(Gravity.LEFT)
        when (position) {
            0 -> {
                drawer_layout.closeDrawer(Gravity.LEFT)
            }
            1 -> {
                startActivity(Intent(this, RegistrationActivity::class.java))
            }
           /* 2 -> {
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.eventreg.icegroupindia.com/doscon18/abstract-login.php"))
                startActivity(intent)
            }*/
            2 -> {
                startActivity(Intent(this, Commitee::class.java))
            }
            3 -> {
                startActivity(Intent(this, Abstract::class.java))
            }
            /*3 -> {
                startActivity(Intent(this, Exhibation::class.java))
            }*/
            4 -> {
                startActivity(Intent(this, Venue::class.java))
            }
            /*6 -> {
                startActivity(Intent(this, Tour::class.java))
            }*/

           /* 7 -> {
                startActivity(Intent(this, Accomodation::class.java))
            }*/
            5 -> {
                startActivity(Intent(this, Contact::class.java))
            }
            6 -> {
                if (ta[9].equals("LOGOUT")) {
                getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE).edit().clear().commit()
                    var intent = Intent(this, Login::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                }else{
                    var intent = Intent(this, Login::class.java)
                    startActivity(intent)
                }

            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.drawer_click -> {
                if (drawer_layout.isDrawerOpen(Gravity.START)) {
                    drawer_layout.closeDrawer(Gravity.LEFT)
                } else {
                    drawer_layout.openDrawer(Gravity.LEFT)
                }
            }
        }
    }

    lateinit var ta: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        var myretailer: String? = intent?.extras?.get("DATA") as? String
      var prefs:  SharedPreferences  = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        var restoredText = prefs.getString("DATA", null);
//        if (restoredText != null) {
        if (!TextUtils.isEmpty(restoredText)) {
            var intent = Intent(this, TicketDetail::class.java)
            intent.putExtra("DATA", restoredText)
            startActivity(intent)
            ta = getResources().getStringArray(R.array.tabname);
            ta.set(9, "LOGOUT")
        } else {
            ta = getResources().getStringArray(R.array.tabname);
        }
        title_name.text = "INDIAN SOCIETY OF CORNEA & KERATOREFRATIVE SURGEONS";
//        sub_title_name.text = Html.fromHtml("<font color='#FCAA23'>MEET 2019</font>")

//        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        setupViewPager(viewpager);
        tabs.setupWithViewPager(viewpager);
        first?.layoutManager = LinearLayoutManager(this)
        first?.addItemDecoration(SpacesItemDecoration(1))
        var adapter = Menuitem(this, this, ta)
        first?.setAdapter(adapter)
        drawer_click.setOnClickListener(this)
    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(Home.newInstance(), "HOME")
//        adapter.addFrag(Invitation.newInstance(), "INVITATION")
//        adapter.addFrag(Highlight.newInstance(), "KERASIGHT")
//        adapter.addFrag(Home.newInstance(), "HIGHLIGHTS")
//        adapter.addFrag(Abstract.newInstance(), "ABSTRACT")
//        adapter.addFrag(Commitee.newInstance(), "COMMITTEE")
//        adapter.addFrag(Invitation.newInstance(), "PROGRAM")
//        adapter.addFrag(Invitation.newInstance(), "EXHIBITION")
//        adapter.addFrag(Invitation.newInstance(), "VENUE")
//        adapter.addFrag(Invitation.newInstance(), "TOURS")
//        adapter.addFrag(Invitation.newInstance(), "ACCOMMODATION")
//        adapter.addFrag(Invitation.newInstance(), "CONTACT")
        viewPager.adapter = adapter
    }

    inner class ViewPagerAdapter(var fragmnger: FragmentManager) : FragmentPagerAdapter(fragmnger) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()
        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFrag(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }

        override fun getItem(position: Int): Fragment {
            return mFragmentList.get(position);
        }

    }

}
