package com.gmail.vladkhinski.database_hw.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.vladkhinski.database_hw.adapter.UserListAdapter
import com.gmail.vladkhinski.database_hw.appDatabase
import com.gmail.vladkhinski.database_hw.databinding.UserListBinding

class UserList : Fragment() {

    private var _binding: UserListBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val adapter = UserListAdapter()

    private val userDao by lazy {
        requireContext().appDatabase.userDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        return UserListBinding.inflate(inflater, container, false)
            .also { binding ->
                _binding = binding
            }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rebuildResult()
        with(binding) {
            swipe.setOnRefreshListener {
                adapter.submitList(emptyList())
                rebuildResult()
                swipe.isRefreshing = false
            }
            adapter.submitList(emptyList())
            recyclerView.adapter = adapter
            rebuildResult()
        }

    }

    private fun rebuildResult() {
        adapter.submitList(userDao.getAll())
    }

}
