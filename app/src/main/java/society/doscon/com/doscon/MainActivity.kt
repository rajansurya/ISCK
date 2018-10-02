package society.doscon.com.doscon

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.text.Html
import android.view.Gravity
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.header_view.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), View.OnClickListener, Menuitem.menuckick {
    override fun menuClick(position: Int) {
        drawer_layout.closeDrawer(Gravity.LEFT)
        when(position){
            0->{
                startActivity(Intent(this,Highlight::class.java))
            }
            1->{
//                startActivity(Intent(this,Abstract::class.java))
                var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.eventreg.icegroupindia.com/doscon18/abstract-login.php"))
                startActivity(intent)
            }
            2->{
                startActivity(Intent(this,Commitee::class.java))
            }
            3->{
                toast("Coming Soon")
            }
            4->{
                startActivity(Intent(this,Exhibation::class.java))
            }
            5->{
                startActivity(Intent(this,Venue::class.java))
            }
            7->{
                toast("Coming Soon")
            }
            8->{
                startActivity(Intent(this,Contact::class.java))
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar);
//        toolbar.setTitle(getResources().getString(R.string.app_name));
        title_name.text = getResources().getString(R.string.app_name)
        sub_title_name.text = Html.fromHtml("<font color='#FCAA23'>WINTER CONFERENCE</font>")

//        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        setupViewPager(viewpager);
        tabs.setupWithViewPager(viewpager);
        first?.layoutManager = LinearLayoutManager(this)
        first?.addItemDecoration(SpacesItemDecoration(1))
        var adapter = Menuitem(this,this)
        first?.setAdapter(adapter)
        drawer_click.setOnClickListener(this)
    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(Home.newInstance(), "HOME")
        adapter.addFrag(Invitation.newInstance(), "INVITATION")
        adapter.addFrag(Registration.newInstance(), "REGISTRATION")
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
