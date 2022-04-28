package com.gmail.vladkhinski.database_hw.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.gmail.vladkhinski.database_hw.databinding.ViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabFragment : Fragment() {
    private var _binding: ViewPagerBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ViewPagerBinding.inflate(inflater, container, false)
            .also { binding ->
                _binding = binding
            }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            pager.adapter = FragmentTabAdapter(this@TabFragment)

            TabLayoutMediator(tabLayout, pager) { tab, position ->
                tab.text = when (position) {
                    0 -> "List Users"
                    1 -> "Add to Database"
                    else -> error("Unsupported position $position")
                }
            }.attach()
        }
    }
}

class FragmentTabAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> UserList()
            1 -> UserDatabase()
            else -> error("Unsupported Position")
        }
    }
}

