package es.baltajmn.tappapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import es.baltajmn.tappapp.databinding.ActivityMainBinding
import es.baltajmn.tappapp.fragment.OrderFragment
import es.baltajmn.tappapp.fragment.TotalFragment
import es.baltajmn.tappapp.fragment.UserFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wormsIndicator = binding.dotsIndicator
        val viewPager = binding.viewPager
        val adapter = ViewPagerAdapter(this)

        adapter.addFragment(UserFragment(), "User")
        adapter.addFragment(OrderFragment(), "Order")
        adapter.addFragment(TotalFragment(), "Total")

        viewPager.adapter = adapter
        wormsIndicator.setViewPager2(viewPager)

    }

    private inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        private val mFragmentList = ArrayList<Fragment>()
        private val mFragmentTitleList = ArrayList<String>()

        override fun getItemCount(): Int {
            return mFragmentList.size
        }

        override fun createFragment(position: Int): Fragment {
            return mFragmentList[position]
        }

        fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }
    }
}