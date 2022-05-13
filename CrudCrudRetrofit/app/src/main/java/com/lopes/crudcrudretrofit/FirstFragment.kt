package com.lopes.crudcrudretrofit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.lopes.crudcrudretrofit.databinding.FragmentFirstBinding
import com.lopes.crudcrudretrofit.presentation.ComicsViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FirstFragment : Fragment() {

    private val comicsViewModel: ComicsViewModel by viewModels()
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureViewModel()
        configureListeners()
    }

    private fun configureListeners() {
        binding.btnGetAllComics.setOnClickListener {
            comicsViewModel.getAllComics()
        }
        binding.btnCreateComics.setOnClickListener {
            comicsViewModel.sendComics()
        }
        binding.btnDeleteComic.setOnClickListener {
            comicsViewModel.deleteComicsById()
        }
    }

    private fun configureViewModel() {
        comicsViewModel.allComics.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, it.toString())
        })
        comicsViewModel.deleteMutableLiveData.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "Deleted comic result: $it", Toast.LENGTH_LONG).show()
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}