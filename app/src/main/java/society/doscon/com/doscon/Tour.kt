package society.doscon.com.doscon

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.header_other.*
import kotlinx.android.synthetic.main.tour.*

class Tour : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tour)
        title_name.text = "TOUR"
        back.setOnClickListener { this@Tour.finish() }
        setupViewPager(viewpagertour);
        tabstour.setupWithViewPager(viewpagertour);
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFrag(TourFragment.newInstance(0), "TOUR 01")
        adapter.addFrag(TourFragment.newInstance(1), "TOUR 02")
        adapter.addFrag(TourFragment.newInstance(2), "TOUR 03")
        adapter.addFrag(TourFragment.newInstance(3), "TOUR 04")
        adapter.addFrag(TourFragment.newInstance(4), "TOUR 05")
        adapter.addFrag(TourFragment.newInstance(5), "TOUR 06")
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