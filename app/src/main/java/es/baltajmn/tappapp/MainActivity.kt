package es.baltajmn.tappapp

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import es.baltajmn.tappapp.databinding.ActivityMainBinding
import es.baltajmn.tappapp.fragment.OrderFragment
import es.baltajmn.tappapp.fragment.TotalFragment
import es.baltajmn.tappapp.fragment.UserFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var page = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wormsIndicator = binding.dotsIndicator
        val adapter = ViewPagerAdapter(this)

        adapter.addFragment(UserFragment(), "User")
        adapter.addFragment(OrderFragment(), "Order")
        adapter.addFragment(TotalFragment(), "Total")

        binding.backwardButton.setOnClickListener {
            page--
            binding.viewPager.setCurrentItem(page, true)
        }

        binding.forwardButton.setOnClickListener {
            page++
            binding.viewPager.setCurrentItem(page, true)
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.backwardButton.visibility = GONE
                    }
                    1 -> {
                        binding.backwardButton.visibility = VISIBLE
                        binding.forwardButton.visibility = VISIBLE
                        binding.finishButton.visibility = GONE
                    }
                    2 -> {
                        binding.forwardButton.visibility = GONE
                        binding.finishButton.visibility = VISIBLE
                    }
                }
            }
        })

        binding.viewPager.adapter = adapter
        wormsIndicator.setViewPager2(binding.viewPager)
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