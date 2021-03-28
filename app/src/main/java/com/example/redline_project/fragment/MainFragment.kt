package com.example.redline_project.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.redline_project.MainApplication
import com.example.redline_project.R
import com.example.redline_project.data.Dogtype
import com.example.redline_project.databinding.FragmentMainBinding

class MainFragment : Fragment(), MainRecyclerViewListener {

    private val appComponent by lazy { MainApplication.appComponent }

    private var fragmentMainFragment : FragmentMainBinding? = null
    private val binding get() = fragmentMainFragment!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        appComponent.inject(this)
        fragmentMainFragment = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val list: List<String> = Dogtype.values().map {
            it.name
        }
        setListAdapter(list)
    }

    private fun setListAdapter(list: List<String>){
        val adapter = MainRecyclerViewAdapter(list, this)
        binding.mainfragmentRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.mainfragmentRecyclerView.adapter = adapter
    }
    override fun onDestroy() {
        super.onDestroy()
        fragmentMainFragment = null
    }

    override fun mainMainItemClicked(string: String) {
        val navController : NavController = Navigation.findNavController(requireActivity(), R.id.fragment_view_main_container)
        val bundle = Bundle()
        bundle.putString("getString", string)
        navController.navigate(R.id.displayScrenFragment_navigation, bundle)
    }
}