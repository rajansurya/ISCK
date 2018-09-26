package society.doscon.com.doscon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.text.Html
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setSubtitle(Html.fromHtml("<font color='#FCAA23'>WINTER CONFERENCE</font>"));
//        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true);
        setupViewPager(viewpager);
        tabs.setupWithViewPager(viewpager);
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(Invitation.newInstance(), "INVITATION")
        adapter.addFrag(Registration.newInstance(), "REGISTRATION")
        adapter.addFrag(Highlight.newInstance(), "HIGHLIGHTS")
        adapter.addFrag(Invitation.newInstance(), "ABSTRACT")
        adapter.addFrag(Invitation.newInstance(), "COMMITTEE")
        adapter.addFrag(Invitation.newInstance(), "PROGRAM")
        adapter.addFrag(Invitation.newInstance(), "EXHIBITION")
        adapter.addFrag(Invitation.newInstance(), "VENUE")
        adapter.addFrag(Invitation.newInstance(), "TOURS")
        adapter.addFrag(Invitation.newInstance(), "ACCOMMODATION")
        adapter.addFrag(Invitation.newInstance(), "CONTACT")
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
