package com.gmail.vladkhinski.database_hw.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.vladkhinski.database_hw.appDatabase
import com.gmail.vladkhinski.database_hw.databinding.FragmentUserDatabaseBinding
import com.gmail.vladkhinski.database_hw.extensions.getTextOrSetError
import com.gmail.vladkhinski.database_hw.model.User

class UserDatabase : Fragment() {
    private var _binding: FragmentUserDatabaseBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val userDao by lazy {
        requireContext().appDatabase.userDao()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return FragmentUserDatabaseBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            addUserButton.setOnClickListener {
                val name = name.getTextOrSetError()
                val surname = surname.getTextOrSetError()
                if (name == null || surname == null) return@setOnClickListener
                userDao.insertAll(User(name = name, surname = surname))
                editName.text = null
                editSurname.text = null
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}